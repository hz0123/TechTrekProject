package com.techtrek5.backend.authentication.UserPackage.repository;

import com.techtrek5.backend.authentication.UserPackage.dao.IDao;
import com.techtrek5.backend.authentication.UserPackage.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends IDao, JpaRepository<UserModel, Long> {
    Optional<UserModel> findByid(long id);
    Optional<List<UserModel>> findByusername(String username);
    Optional<List<UserModel>> findByname(String name);
    Optional<List<UserModel>> findByappointment(String appointment);
    Optional<UserModel> findByUsername(String email);
    @Transactional
    @Modifying
    @Query(value = "update user set enabled=true where username =?1", nativeQuery = true)
    int enableUser(String email);
    @Query(value = "select * from user where username =?1",nativeQuery = true)
    Optional<UserModel> findByusernameRegister(String username);

}
