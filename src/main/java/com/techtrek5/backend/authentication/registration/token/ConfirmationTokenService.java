package com.techtrek5.backend.authentication.registration.token;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {
    private ConfirmationTokenRepository confirmationTokenRepository;
    public void saveConfirmationToken(ConfirmationTokenModel token){
        confirmationTokenRepository.save(token);
    }

    public Optional<ConfirmationTokenModel> getToken(String token){
        return confirmationTokenRepository.findByToken(token);
    }

    public int setConfirmedAt(String token){
        return confirmationTokenRepository.updateTokenConfirmation(token, LocalDateTime.now());
    }
}
