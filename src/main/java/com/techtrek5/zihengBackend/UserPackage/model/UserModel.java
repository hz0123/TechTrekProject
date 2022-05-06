package com.techtrek5.zihengBackend.UserPackage.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Component
@Table(name = "usertable", schema = "bankdb")
public class UserModel {
    @Id
    @GeneratedValue
    long id;
    private String username;
    private String password;
    private String name;
    private String appointment;
}
