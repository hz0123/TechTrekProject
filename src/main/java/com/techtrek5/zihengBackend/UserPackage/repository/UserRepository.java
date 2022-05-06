package com.techtrek5.zihengBackend.UserPackage.repository;

import com.techtrek5.zihengBackend.UserPackage.dao.IDao;
import com.techtrek5.zihengBackend.UserPackage.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends IDao, JpaRepository<UserModel, Long> {
    Optional<UserModel> findByid(long id);
    Optional<List<UserModel>> findByusername(String username);
    Optional<List<UserModel>> findByname(String name);
    Optional<List<UserModel>> findByappointment(String appointment);

}
