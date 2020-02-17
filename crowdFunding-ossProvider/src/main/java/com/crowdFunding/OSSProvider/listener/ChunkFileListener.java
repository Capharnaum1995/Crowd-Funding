package com.crowdFunding.OSSProvider.listener;

import com.alibaba.fastjson.JSON;
import com.crowdFunding.OSSProvider.provider.OSSProvider;
import com.crowdFunding.common.dto.ChunkFileDTO;
import com.crowdFunding.common.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeOrderlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerOrderly;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@Component   //listener作为组件注入spring的容器
@Slf4j
public class ChunkFileListener {

    @Value("${rocketmq.name-server}")
    private String nameServer;

    @Value("${rocketmq.consumer.group}")
    private String consumerGroup;

    @Autowired
    private OSSProvider ossProvider;

    @Bean
    public DefaultMQPushConsumer getOrderlyConsumer() throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        //Message model defaults to clustering.
        consumer.setNamesrvAddr(nameServer);
        //这个消费者组第一次启动时从队列的最后位置开始消费，后面启动时
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        consumer.subscribe("File-Upload", "*");//File-Upload
        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> messages, ConsumeOrderlyContext context) {
                //消息队列是否消费成功的标志位
                AtomicBoolean consumeSuccess = new AtomicBoolean(true);
                //自动提交，不知道干嘛的。。。,默认为true
                context.setAutoCommit(true);
                //队列挂起时间，默认为-1
                context.setSuspendCurrentQueueTimeMillis(3000);

                //1. 消费消息
                messages.forEach(item -> {
                    ChunkFileDTO chunkFileDTO = JSON.parseObject(new String(item.getBody()), ChunkFileDTO.class);
                    if (chunkFileDTO.getComplete()) {
                        String fileId = chunkFileDTO.getFileId();
                        //合并文件
                        ResultEntity<String> resultEntity = ossProvider.completeChunkFile(fileId);
                        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
                            consumeSuccess.set(false);
                        }

                    } else {
                        //上传分片
                        ResultEntity<String> resultEntity = ossProvider.uploadChunkFile(chunkFileDTO);
                        if (ResultEntity.FAILED.equals(resultEntity.getStatus())) {
                            consumeSuccess.set(false);
                        }
                    }
                });

                //2. 消费成功，提交事务；消费失败则挂起队列一段时间后，下次再消费？？？
                if (consumeSuccess.get()) {
                    return ConsumeOrderlyStatus.SUCCESS;
                } else {
                    return ConsumeOrderlyStatus.SUSPEND_CURRENT_QUEUE_A_MOMENT;
                }
            }
        });
        consumer.start();
        return consumer;
    }
}

