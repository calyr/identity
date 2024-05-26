package com.calyrsoft.identity.repository;

import com.calyrsoft.identity.datasource.IDataSource;
import com.calyrsoft.identity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdentityRepository implements IIdentityRepository {

    @Autowired
    IDataSource dataSource;

    @Override
    public User findByCi(String ci) throws Exception {
        var result = dataSource.getUser(ci);
        if( result.size() == 0) {
            throw new Exception("User not found");
        } else if(result.size()>1) {
            throw new Exception("Double identity for ci: "+ci);
        } else {
            return result.get(0);
        }
    }
}
