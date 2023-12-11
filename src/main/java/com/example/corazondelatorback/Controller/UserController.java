package com.example.corazondelatorback.Controller;

import com.example.corazondelatorback.Model.Comic;
import com.example.corazondelatorback.Model.Newspaper;
import com.example.corazondelatorback.Model.User;
import com.example.corazondelatorback.Services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping(value = "/getUser")
    public List<User> getAllUser(){
        return userService.UserList();
    }
    @PostMapping(value = "/addUser")
    public String addUser(@RequestBody User user){
        return userService.adminCreate(user);
    }

    @PutMapping("/updateUser/{id}")
    public String updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }
}
