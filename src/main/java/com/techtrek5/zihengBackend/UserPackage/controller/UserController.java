package com.techtrek5.zihengBackend.UserPackage.controller;

import com.techtrek5.zihengBackend.UserPackage.model.UserModel;
import com.techtrek5.zihengBackend.UserPackage.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/usercontroller")
public class UserController {
    private UserService userService;
    private UserModel userModel;

    @GetMapping(path = "/health")
    public String healthcheck(){//test for controller response
        return "hello";
    }

    @PostMapping(path = "/save")
    public String save(@RequestBody UserModel userModel){//test for controller response
        return userService.save(userModel);
    }

    @PostMapping(path = "/findid/{id}")
    public Optional<UserModel> findId(@PathVariable("id") long id){//test for controller response
        return userService.findByid(id);
    }

    @PostMapping(path = "/findusername/{username}")
    public Optional<List<UserModel>> findUsername(@PathVariable("username") String username){//test for controller response
        return userService.findByusername(username);
    }

    @PostMapping(path = "/findname/{name}")
    public Optional<List<UserModel>> findName(@PathVariable("name") String name){//test for controller response
        return userService.findByname(name);
    }

    @PostMapping(path = "/findappointment/{appointment}")
    public Optional<List<UserModel>> findAppointment(@PathVariable("appointment") String appointment){//test for controller response
        return userService.findByappointment(appointment);
    }
}
