package com.calyrsoft.identity.service;


import com.calyrsoft.identity.repository.IIdentityRepository;
import com.calyrsoft.identity.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {

    private IIdentityRepository identityRepository;

    @Autowired
    public IdentityService(IIdentityRepository identityRepository) {
        this.identityRepository = identityRepository;
    }

    public User findById(String ci) throws Exception{
        return identityRepository.findByCi(ci);
    }
}
