package com.francesca.francescabackspring.service;

import com.francesca.francescabackspring.DTO.IncomesExpensesReportDTO;
import com.francesca.francescabackspring.DTO.OneExpenseDTO;
import com.francesca.francescabackspring.entity.Expense;
import com.francesca.francescabackspring.repository.ExpensesRepository;
import com.francesca.francescabackspring.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ExpensesService {

    @Qualifier("expensesRepository")
    @Autowired
    private ExpensesRepository repository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ExpensesRepository expensesRepository;

    public ExpensesService(@Qualifier("expensesRepository") ExpensesRepository repository){
        this.repository= repository;
    }

    public List<Expense> getExpenses() { return repository.findAll();  }

    public OneExpenseDTO getExpense(int id) { return repository.getExpenseById(id);}

    public Expense newExpense(Expense e) {
        e.setDateExpense(new Date());
        return repository.save(e); }

    public IncomesExpensesReportDTO getIncomesExpensesReport(int month, int year) {

        float expenses = repository.getExpenses(month, year);
        float incomes = salesRepository.getIncomes(month, year);

        return new IncomesExpensesReportDTO(incomes, expenses, (incomes-expenses));
    }
}
