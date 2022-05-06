package com.techtrek5.zihengBackend.CategoryPackage.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Component
@Table(name = "category", schema = "bankdb")
public class CategoryModel {
    @Id
    @Column(nullable = false)
    long id;
    private String name;
}
