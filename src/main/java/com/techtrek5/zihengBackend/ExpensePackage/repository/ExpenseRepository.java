package com.techtrek5.zihengBackend.ExpensePackage.repository;

import com.techtrek5.zihengBackend.ExpensePackage.dao.IExpenseDao;
import com.techtrek5.zihengBackend.ExpensePackage.model.ExpenseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends IExpenseDao, JpaRepository<ExpenseModel, Long> {
    Optional<ExpenseModel> findByid(long id);
    Optional<List<ExpenseModel>> findByprojectId(String projectId);
    Optional<List<ExpenseModel>> findBycategoryId(String categoryId);
    Optional<List<ExpenseModel>> findByname(String name);
    Optional<List<ExpenseModel>> findBydescription(String description);
    Optional<List<ExpenseModel>> findByamount(float amount);
    Optional<List<ExpenseModel>> findBycreatedAt(LocalDate createdAt);
    Optional<List<ExpenseModel>> findBycreatedBy(String createdBy);
    Optional<List<ExpenseModel>> findByupdatedAt(String updatedAt);
    Optional<List<ExpenseModel>> findByupdatedBy(String updatedBy);
}
