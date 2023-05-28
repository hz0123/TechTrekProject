package com.techtrek5.backend.authentication.UserPackage.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Collections;

@Data
@NoArgsConstructor
@Entity
@Component
@Table(name = "user", schema = "bankdb")
public class UserModel implements UserDetails {
    @Id
    @GeneratedValue
    long id;
    private String username;
    private String password;
    private String name;
    private String appointment;
    private UserRoles userRoles;
    private boolean locked = false;
    private boolean enabled = false;

    public UserModel(String username,
                     String password,
                     String name,
                     String appointment,
                     UserRoles userRoles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.appointment = appointment;
        this.userRoles = userRoles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(userRoles.name());
        return Collections.singletonList(simpleGrantedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return enabled;
    }
}
