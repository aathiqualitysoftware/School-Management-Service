package com.lrs.Service;

import com.lrs.Dto.ExpenseUpdate;
import com.lrs.Entity.Expenses;
import com.lrs.exception.ServiceException;

import java.util.List;

public interface ExpenseService {
    Expenses insertExpense(Expenses expenses) throws ServiceException;
    Expenses isExist(Long id) throws ServiceException;
    Expenses expenseUpdate(Expenses expenseTypeExist, ExpenseUpdate expenseUpdate) throws ServiceException;
    void expenseDelete(Long id) throws ServiceException;
    List<Expenses> getExpenses() throws ServiceException;
}
