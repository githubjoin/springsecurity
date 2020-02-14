package com.practice.liam.rest.api.controller.v1;

import com.practice.liam.rest.api.entity.User;
import com.practice.liam.rest.api.repository.UserJpaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
public class UserController {

    @Autowired
    UserJpaRepo userJpaRepo;

    @GetMapping(value = "/user")
    public List<User> findAllUser() {
        return userJpaRepo.findAll();
    }

    @PostMapping(value = "/user")
    public User save() {
        User user = User.builder()
                .uid("captinamerica@avangers.com")
                .name("james")
                .build();
        return userJpaRepo.save(user);
    }
}
