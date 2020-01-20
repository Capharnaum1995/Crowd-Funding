package com.crowdFunding.databaseProvider.service.imp;

import com.crowdFunding.databaseProvider.mapper.UserMapper;
import com.crowdFunding.databaseProvider.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;


}
