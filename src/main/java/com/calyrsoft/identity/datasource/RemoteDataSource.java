package com.calyrsoft.identity.datasource;

import com.calyrsoft.identity.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class RemoteDataSource implements IDataSource{

    private ArrayList<User> list = new ArrayList(
      List.of(new User(
              "5200000",
              "Roberto Carlos",
              "Callisaya",
              "Mamani",
              "07/07/1986"
                ),
              new User(
                      "6500000",
                      "Gabriela",
                      "Orosco",
                      "Montaño",
                      "12/05/1986"
              ))
    );

    @Override
    public List<User> getUser(String ci) {
        var posibleUserList = list.stream()
                .filter( user -> user.getCi().equals(ci))
                .collect(Collectors.toList());
        return posibleUserList;
    }
}
