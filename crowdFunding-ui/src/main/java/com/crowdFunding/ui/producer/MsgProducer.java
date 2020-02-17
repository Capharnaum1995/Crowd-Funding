package com.crowdFunding.ui.producer;

import com.crowdFunding.common.constant.Constant;
import com.crowdFunding.common.dto.ChunkFileDTO;
import com.crowdFunding.common.entity.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MsgProducer {

    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步上传文件分片
     *
     * @param chunkFileDTO
     * @return
     */
    public ResultEntity<String> produceChunkFile(ChunkFileDTO chunkFileDTO) {
        SendResult sendResult = rocketMQTemplate.syncSendOrderly("File-Upload", chunkFileDTO, chunkFileDTO.getFileId(), 15000);
        SendStatus sendStatus = sendResult.getSendStatus();
        if (SendStatus.SEND_OK.equals(sendStatus)) {
            return ResultEntity.successWithoutData();
        }
        //上传失败，根据上传的分片类型打印日志
        if (chunkFileDTO.getComplete()) {
            //合并分片
            log.error(Constant.CHUNK_UPLOAD_FAILD + "  [fileId=" + chunkFileDTO.getFileId() + "]");
        } else {
            //普通分片
            log.warn(Constant.CHUNK_UPLOAD_FAILD + "  [fileId=" + chunkFileDTO.getFileId() + "chunkIndex=" + chunkFileDTO.getChunkIndex() + "]");
        }
        return ResultEntity.failed(Constant.CHUNK_UPLOAD_FAILD);
    }


}
