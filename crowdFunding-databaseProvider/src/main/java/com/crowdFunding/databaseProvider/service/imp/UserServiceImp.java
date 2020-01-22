package com.crowdFunding.databaseProvider.service.imp;

import com.crowdFunding.common.dto.UserRegistrationInfoDTO;
import com.crowdFunding.databaseProvider.mapper.UserMapper;
import com.crowdFunding.databaseProvider.model.User;
import com.crowdFunding.databaseProvider.model.UserExample;
import com.crowdFunding.databaseProvider.service.api.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer getCountByAccount(String account) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(account);
        return Integer.parseInt(String.valueOf(userMapper.countByExample(userExample)));
    }

    @Override
    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    //该类前@Transactional(readOnly = true)是只读的，数据库操作时无法执行写的操作，会出现“Connection is read-only.”的异常。
    public Integer createUser(UserRegistrationInfoDTO userRegistrationInfoDTO) {
        User user = new User();
        BeanUtils.copyProperties(userRegistrationInfoDTO, user);
        return userMapper.insertSelective(user);
    }

}
