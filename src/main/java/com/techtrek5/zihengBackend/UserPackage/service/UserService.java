package com.techtrek5.zihengBackend.UserPackage.service;

import com.techtrek5.zihengBackend.UserPackage.dao.IDao;
import com.techtrek5.zihengBackend.UserPackage.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService implements IService{
    private IDao iDao;
    private UserModel userModel;

    @Override
    public Optional<List<UserModel>> findByusername(String username) {
        return iDao.findByusername(username);
    }

    @Override
    public Optional<List<UserModel>> findByname(String name) {
        return iDao.findByname(name);
    }

    @Override
    public Optional<List<UserModel>> findByappointment(String appointment) {
        return iDao.findByappointment(appointment);
    }

    @Override
    public Optional<UserModel> findByid(long id) {
        return iDao.findByid(id);
    }

    @Override
    public String save(UserModel userModel) {
        iDao.save(userModel);
        return "successfully saved";
    }
}
