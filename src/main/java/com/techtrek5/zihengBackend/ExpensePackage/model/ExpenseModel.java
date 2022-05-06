package com.techtrek5.zihengBackend.ExpensePackage.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Component
@Table(name = "expense", schema = "bankdb")
public class ExpenseModel {
    @Id
    @Column(nullable = false)
    long id;
    @Column(name = "project_id")
    private String projectId;
    private String categoryId;
    private String name;
    private String description;
    private float amount;
    private LocalDate createdAt;
    private String createdBy;
    private String updatedAt;
    private String updatedBy;
}
