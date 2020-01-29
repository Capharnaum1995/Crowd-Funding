package com.crowdFunding.databaseProvider.service.api;

import com.crowdFunding.common.dto.UserRegistrationInfoDTO;
import com.crowdFunding.databaseProvider.model.User;

public interface UserService {

    Integer getCountByAccount(String account);

    Integer createUser(UserRegistrationInfoDTO userRegistrationInfoDTO);

    User retrieveUserByAccount(String account);
}
