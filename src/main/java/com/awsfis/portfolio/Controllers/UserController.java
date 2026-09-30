package com.awsfis.portfolio.Controllers;


import com.awsfis.portfolio.Model.Users;
import com.awsfis.portfolio.Services.UserServices;
import com.awsfis.portfolio.dtos.Login;
import com.awsfis.portfolio.dtos.SignUpRequest;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
public class UserController {


    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/api/hello")
    public String hello() {
        return "hello world";
    }

    @PostMapping("/api/signup")
    public ResponseEntity<?> signUp(@RequestBody SignUpRequest body){
        if(userServices.signUp(body)){
            return ResponseEntity.ok(Map.of("message", "User Created successfully"));
        } else{
            return ResponseEntity.badRequest().body(Map.of("message","unable to create user"));
        }
    }

    @PostMapping("/api/login")
    public ResponseEntity<?> login(@RequestBody Login login){
        if(userServices.login(login)){
            return ResponseEntity.ok(Map.of("message","User logged in successfully"));
        }
        else{
            return ResponseEntity.badRequest().body(Map.of("message","Unable to create user"));
        }

    }




}
