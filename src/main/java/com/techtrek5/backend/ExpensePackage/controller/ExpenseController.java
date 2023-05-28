package com.techtrek5.backend.ExpensePackage.controller;

import com.techtrek5.backend.ExpensePackage.model.ExpenseModel;
import com.techtrek5.backend.ExpensePackage.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/expensecontroller")
public class ExpenseController {
    private ExpenseService expenseService;
    private ExpenseModel expenseModel;

    @PostMapping(path = "/save")
    public ExpenseModel save(@RequestBody ExpenseModel expenseModel){//test for controller response
        return expenseService.save(expenseModel);
    }

    @PostMapping(path = "/findid/{id}")
    public Optional<ExpenseModel> findId(@PathVariable("id") long id){//test for controller response
        return expenseService.findByid(id);
    }

    @PostMapping(path = "/findByprojectId/{projectId}")
    public Optional<List<ExpenseModel>> findByprojectId(String projectId){
        return expenseService.findByprojectId(projectId);
    }

    @PostMapping(path = "/findBycategoryId/{categoryId}")
    public Optional<List<ExpenseModel>> findBycategoryId(String categoryId){
        return expenseService.findBycategoryId(categoryId);
    }

    @PostMapping(path = "/findByname/{name}")
    public Optional<List<ExpenseModel>> findByname(String name){
        return expenseService.findByname(name);
    }

    @PostMapping(path = "/findBydescription/{description}")
    public Optional<List<ExpenseModel>> findBydescription(String description){
        return expenseService.findBydescription(description);
    }

    @PostMapping(path = "/findByamount/{amount}")
    public Optional<List<ExpenseModel>> findByamount(float amount){
        return expenseService.findByamount(amount);
    }

    @PostMapping(path = "/findBycreatedAt/{description}")
    public Optional<List<ExpenseModel>> findBycreatedAt(LocalDate createdAt){
        return expenseService.findBycreatedAt(createdAt);
    }

    @PostMapping(path = "/findBycreatedBy/{createdBy}")
    public Optional<List<ExpenseModel>> findBycreatedBy(String createdBy){
        return expenseService.findBycreatedBy(createdBy);
    }

    @PostMapping(path = "/findByupdatedAt/{updatedAt}")
    public Optional<List<ExpenseModel>> findByupdatedAt(String updatedAt){
        return expenseService.findByupdatedAt(updatedAt);
    }

    @PostMapping(path = "/findByupdatedBy/{amount}")
    public Optional<List<ExpenseModel>> findByupdatedBy(String updatedBy){
        return expenseService.findByupdatedBy(updatedBy);
    }

    @GetMapping(path = "/findall")
    public Optional<List<ExpenseModel>> findAll(){
        return expenseService.findAllExpense();
    }

    @PostMapping(path = "/updateexpenses")
    public void updateExpenses(@RequestBody ExpenseModel expenseModel){
        expenseService.updateExpanseModel(expenseModel);
    }

    @PostMapping(path = "/deleteexpenses/{id}")
    public void updateExpenses(@PathVariable("id") long id){
        expenseService.deleteByid(id);
    }

}
