package com.calyrsoft.identity.repository;

import com.calyrsoft.identity.model.User;

public interface IIdentityRepository {

    User findByCi(String ci) throws Exception;
}
