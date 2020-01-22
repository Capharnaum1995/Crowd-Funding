package com.crowdFunding.databaseProvider.service.api;

import com.crowdFunding.common.dto.UserRegistrationInfoDTO;

public interface UserService {

    Integer getCountByAccount(String account);

    Integer createUser(UserRegistrationInfoDTO userRegistrationInfoDTO);
}
