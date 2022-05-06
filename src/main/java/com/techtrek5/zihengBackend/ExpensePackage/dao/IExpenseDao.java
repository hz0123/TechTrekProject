package com.techtrek5.zihengBackend.ExpensePackage.dao;

import com.techtrek5.zihengBackend.ExpensePackage.model.ExpenseModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IExpenseDao {
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
    ExpenseModel save(ExpenseModel expenseModel);
}
