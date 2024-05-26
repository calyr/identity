package com.calyrsoft.identity.datasource;

import com.calyrsoft.identity.model.User;

import java.util.List;

public interface IDataSource {
    List<User> getUser(String ci);
}
