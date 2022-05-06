package com.techtrek5.zihengBackend.authentication.registration;

import com.techtrek5.zihengBackend.authentication.UserPackage.model.UserModel;
import com.techtrek5.zihengBackend.authentication.UserPackage.model.UserRoles;
import com.techtrek5.zihengBackend.authentication.UserPackage.service.UserService;
import com.techtrek5.zihengBackend.authentication.registration.email.EmailService;
import com.techtrek5.zihengBackend.authentication.registration.token.ConfirmationTokenModel;
import com.techtrek5.zihengBackend.authentication.registration.token.ConfirmationTokenService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class RegistrationService {
    private UserService userService;
    private ConfirmationTokenService confirmationTokenService;
    private UserModel userModel;
    private EmailService emailService;

    public  String register(RegistrationModel registrationModel){
        String token = userService.signUpUser(new UserModel(
                registrationModel.getUsername(),
                registrationModel.getPassword(),
                registrationModel.getName(),
                registrationModel.getAppointment(),
                UserRoles.USER
        ));
        String emailBodyText = "click link to complete your registration: \n";
        String link = "http://localhost:8080/registration/confirm?token="+token;
        emailService.send(registrationModel.getUsername(), emailBodyText+link);
        return token;
    }

    @Transactional
    public String confirmToken(String token){
        ConfirmationTokenModel confirmationTokenModel = confirmationTokenService.getToken(token)
                .orElseThrow(()-> new IllegalStateException("Token not found"));
        if(confirmationTokenModel.getConfirmedAt() != null)
            throw new IllegalStateException("Email is already confirmed");
        LocalDateTime expiredAt = confirmationTokenModel.getExpiresAt();
        if(expiredAt.isBefore(LocalDateTime.now()))
            throw new IllegalStateException("Token expired");
        confirmationTokenService.setConfirmedAt(token);
        userService.enableUser(confirmationTokenModel.getUserModel().getUsername());
        return "confirmed";
    }
}





























