package com.techtrek5.backend.ExpensePackage.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;

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
