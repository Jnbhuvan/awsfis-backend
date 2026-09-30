package com.awsfis.portfolio.Services;


import com.awsfis.portfolio.Model.Users;
import com.awsfis.portfolio.Repo.UserRepo;
import com.awsfis.portfolio.dtos.Login;
import com.awsfis.portfolio.dtos.SignUpRequest;
import org.springframework.stereotype.Service;
import tools.jackson.databind.node.BooleanNode;

import java.sql.SQLOutput;
import java.util.Optional;

@Service
public class UserServices {
    private UserRepo userRepo;

    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    public Boolean signUp(SignUpRequest user) {
        try {

            System.out.println(user);
            Users users = new Users();
            users.setEmail(user.getEmail());
            users.setName(user.getName());
            users.setPassword(user.getPassword());
            userRepo.save(users);
            return Boolean.TRUE;
        } catch (Exception e) {
            System.out.println(e);
            return Boolean.FALSE;
        }
    }


    public boolean login(Login login) {

        Optional<Users> user = userRepo.findByEmail(login.getEmail());
        if (user.isPresent()) {
            return user.get().getPassword().equals(login.getPassword());
        } else {
            return false;
        }
    }
}