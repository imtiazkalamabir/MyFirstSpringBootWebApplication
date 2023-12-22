package com.in28mintues.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String password) {
        return  username.equalsIgnoreCase("in28minutes") &&
                password.equalsIgnoreCase("dummy");
    }

}
