package com.techtrek5.backend.ExpensePackage.repository;

import com.techtrek5.backend.ExpensePackage.dao.IExpenseDao;
import com.techtrek5.backend.ExpensePackage.model.ExpenseModel;
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
    @Query(value = "select * from expense", nativeQuery = true)
    Optional<List<ExpenseModel>> findAllExpense();

    @Transactional
    @Modifying
    @Query(value = "update expense set " +
            "amount = ?2, category_id=?3, created_at=?4, created_by=?5, description=?6, name=?7, " +
            "project_id=?8, updated_at=?9, updated_by=?10" +
            " where id = ?1" , nativeQuery = true)
    int updateExpanseModel(long id,
                           float amount,
                           String categoryId,
                           LocalDate createdAt,
                           String createdBy,
                           String description,
                           String name,
                           String projectId,
                           String updatedAt,
                           String updatedBy);

    @Transactional
    @Modifying
    @Query(value = "delete from expense where id = ?1" , nativeQuery = true)
    int deleteByid(long id);

}
