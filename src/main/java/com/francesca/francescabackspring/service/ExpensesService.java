package com.francesca.francescabackspring.service;

import com.francesca.francescabackspring.DTO.OneExpenseDTO;
import com.francesca.francescabackspring.entity.Expense;
import com.francesca.francescabackspring.repository.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService {

    @Qualifier("expensesRepository")
    @Autowired
    private ExpensesRepository repository;

    public ExpensesService(@Qualifier("expensesRepository") ExpensesRepository repository){
        this.repository= repository;
    }

    public List<Expense> getExpenses() { return repository.findAll();  }

    public OneExpenseDTO getExpense(int id) { return repository.getExpenseById(id);}

    public Expense newExpense(Expense e) { return repository.save(e);
    }
}
