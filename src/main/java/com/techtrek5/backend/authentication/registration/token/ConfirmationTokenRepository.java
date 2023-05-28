package com.techtrek5.backend.authentication.registration.token;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ConfirmationTokenRepository extends JpaRepository<ConfirmationTokenModel, Long> {
    @Transactional
    @Modifying
    @Query(value = "update confirmation_token_model set confirmed_at = ?2 where token = ?1", nativeQuery = true)
    int updateTokenConfirmation(String token, LocalDateTime confirmedAt);
    Optional<ConfirmationTokenModel> findByToken(String token);

}
