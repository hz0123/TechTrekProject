package com.techtrek5.backend.authentication.UserPackage.service;

import com.techtrek5.backend.authentication.UserPackage.dao.IDao;
import com.techtrek5.backend.authentication.UserPackage.model.UserModel;
import com.techtrek5.backend.authentication.registration.token.ConfirmationTokenModel;
import com.techtrek5.backend.authentication.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService implements IService, UserDetailsService {
    private IDao iDao;
    private UserModel userModel;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private ConfirmationTokenService confirmationTokenService;

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

    @Override
    public int enableUser(String username) {
        return iDao.enableUser(username);
    }

    public String signUpUser(UserModel userModel){
        String encodedPassword = bCryptPasswordEncoder.encode(userModel.getPassword());
        userModel.setPassword(encodedPassword);
        iDao.save(userModel);
        String token = UUID.randomUUID().toString();
        ConfirmationTokenModel confirmationTokenModel = new ConfirmationTokenModel
                (token, LocalDateTime.now(), LocalDateTime.now().plusMinutes(10), userModel);
        confirmationTokenService.saveConfirmationToken(confirmationTokenModel);
        return token;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return (UserDetails) iDao.findByusernameRegister(username).orElseThrow(
                ()-> new UsernameNotFoundException("no user found with username="+ username));
    }

}
