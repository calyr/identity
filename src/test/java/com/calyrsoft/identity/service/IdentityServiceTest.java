package com.calyrsoft.identity.service;

import com.calyrsoft.identity.datasource.IDataSource;
import com.calyrsoft.identity.model.User;
import com.calyrsoft.identity.repository.IIdentityRepository;
import com.calyrsoft.identity.repository.IdentityRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IdentityServiceTest {

    @InjectMocks
    private IdentityRepository identityRepository;

    @Mock
    private IDataSource dataSource;

    User user1 = new User(
            "5298000",
            "Roberto Carlos",
            "Callisaya",
            "Mamani",
            "07/07/1986"
    );
    User user2 = new User(
            "5298001",
            "Roberto Carlos",
            "Callisaya",
            "Mamani",
            "07/07/1986"
    );



    @Test
    @DisplayName("Given one ci that corresponds to an only User")
    public void userExits() throws Exception {


        IdentityService identityService1 = new IdentityService(identityRepository);

        when( dataSource.getUser(anyString())).thenReturn(
                new ArrayList(List.of(
                        user1
                )));

        User user = identityService1.findById("5298000");
        assertEquals(user1.getCi(), user.getCi() );
    }

    @Test
    @DisplayName("Given a CI that corresponds to two o more users would return an Exception")
    public void ciHasMoreUsers() throws Exception {
        IdentityService identityService = new IdentityService(identityRepository);
        when(
                dataSource.getUser(anyString())
        ).thenReturn(
                new ArrayList<>(List.of(user1, user2))
        );
        assertThrows(
             Exception.class,
                () -> {
                    User user = identityService.findById("5298377");
                }
        );


    }

}