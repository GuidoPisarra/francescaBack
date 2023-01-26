package com.francesca.francescabackspring.controller;


import com.francesca.francescabackspring.DTO.OneExpenseDTO;
import com.francesca.francescabackspring.DTO.OneProductDTO;
import com.francesca.francescabackspring.entity.Expense;
import com.francesca.francescabackspring.entity.Product;
import com.francesca.francescabackspring.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ExpensesController {

    @Qualifier("expensesService")
    @Autowired
    private final ExpensesService service;


    public ExpensesController(@Qualifier ("expensesService") ExpensesService service) {
        super();
        this.service = service;
    }

    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/expense")
    public Iterable<Expense> getExpenses() {return service.getExpenses();}

    @CrossOrigin(origins = "*", methods= {RequestMethod.GET})
    @GetMapping("/expense/{id}")
    public OneExpenseDTO getExpense(@PathVariable(value="id") int id) {return service.getExpense(id);}

    @CrossOrigin(origins = "*", methods= {RequestMethod.POST})
    @PostMapping("/expense")
    public Expense newExpense(@RequestBody Expense e){return service.newExpense(e);}


}
