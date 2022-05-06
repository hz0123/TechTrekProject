package com.techtrek5.zihengBackend.authentication.UserPackage.service;

import com.techtrek5.zihengBackend.authentication.UserPackage.model.UserModel;

import java.util.List;
import java.util.Optional;

public interface IService {
    Optional<UserModel> findByid(long id);
    Optional<List<UserModel>> findByusername(String username);
    Optional<List<UserModel>> findByname(String name);
    Optional<List<UserModel>> findByappointment(String appointment);
    String save(UserModel userModel);
    int enableUser(String email);
}
