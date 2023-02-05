package com.francesca.francescabackspring.repository;

import com.francesca.francescabackspring.DTO.OneExpenseDTO;
import com.francesca.francescabackspring.DTO.OneProductDTO;
import com.francesca.francescabackspring.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expense, Integer> {

    @Query(value = "SELECT new com.francesca.francescabackspring.DTO.OneExpenseDTO(e.id, e.description, e.price, e.id_sucursal) FROM Expense e WHERE e.id = :id")
    OneExpenseDTO getExpenseById(int id);
    @Query("SELECT SUM(e.price)" +
            "FROM Expense e " +
            "WHERE MONTH(e.dateExpense)= :month AND YEAR(e.dateExpense)= :year "

    )
    float getExpenses(int month, int year);
}
