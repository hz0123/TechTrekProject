package com.techtrek5.zihengBackend.ExpensePackage.service;

import com.techtrek5.zihengBackend.ExpensePackage.dao.IExpenseDao;
import com.techtrek5.zihengBackend.ExpensePackage.model.ExpenseModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ExpenseService implements ExpenseIService {
    private IExpenseDao iExpenseDao;
    private ExpenseModel expenseModel;

    @Override
    public Optional<List<ExpenseModel>> findByname(String name) {
        return iExpenseDao.findByname(name);
    }

    @Override
    public Optional<List<ExpenseModel>> findBydescription(String description) {
        return iExpenseDao.findBydescription(description);
    }

    @Override
    public Optional<List<ExpenseModel>> findByamount(float amount) {
        return iExpenseDao.findByamount(amount);
    }

    @Override
    public Optional<List<ExpenseModel>> findBycreatedAt(LocalDate createdAt) {
        return iExpenseDao.findBycreatedAt(createdAt);
    }

    @Override
    public Optional<List<ExpenseModel>> findBycreatedBy(String createdBy) {
        return iExpenseDao.findBycreatedBy(createdBy);
    }

    @Override
    public Optional<List<ExpenseModel>> findByupdatedAt(String updatedAt) {
        return iExpenseDao.findByupdatedAt(updatedAt);
    }

    @Override
    public Optional<List<ExpenseModel>> findByupdatedBy(String updatedBy) {
        return iExpenseDao.findByupdatedBy(updatedBy);
    }

    @Override
    public Optional<ExpenseModel> findByid(long id) {
        return iExpenseDao.findByid(id);
    }

    @Override
    public Optional<List<ExpenseModel>> findByprojectId(String projectId) {
        return iExpenseDao.findByprojectId(projectId);
    }


    @Override
    public Optional<List<ExpenseModel>> findBycategoryId(String categoryId) {
        return iExpenseDao.findBycategoryId(categoryId);
    }

    @Override
    public ExpenseModel save(ExpenseModel expenseModel) {
        return iExpenseDao.save(expenseModel);
    }

    @Override
    public Optional<List<ExpenseModel>> findAllExpense() {
        return iExpenseDao.findAllExpense();
    }

    @Override
    public int updateExpanseModel(ExpenseModel expenseModel) {
        long id = expenseModel.getId();
        String projectId = expenseModel.getProjectId();
        String categoryId  = expenseModel.getCategoryId();
        String name =  expenseModel.getName();
        String description = expenseModel.getDescription();
        float amount = expenseModel.getAmount();
        LocalDate createdAt = expenseModel.getCreatedAt();
        String createdBy = expenseModel.getCreatedBy();
        String updatedAt = expenseModel.getUpdatedAt();
        String updatedBy = expenseModel.getUpdatedBy();
        return iExpenseDao.updateExpanseModel(
                                            id,
                                            amount,
                                            categoryId,
                                            createdAt,
                                            createdBy,
                                            description,
                                            name,
                                            projectId,
                                            updatedAt,
                                            updatedBy);
    }

    @Override
    public int deleteByid(long id) {
        return iExpenseDao.deleteByid(id);
    }


}
