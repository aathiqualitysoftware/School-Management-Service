package com.lrs.ServiceImpl;

import com.lrs.Dto.ExpenseUpdate;
import com.lrs.Entity.Exams;
import com.lrs.Entity.Expenses;
import com.lrs.Repository.ExpenseRepository;
import com.lrs.Service.ExpenseService;
import com.lrs.exception.ErrorCode;
import com.lrs.exception.ServiceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ExpenseServiceImpl implements ExpenseService {
    ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseServiceImpl(ExpenseRepository expenseRepository){
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Expenses insertExpense(Expenses expenses) throws ServiceException {
        expenses.setId(null);
        return expenseRepository.save(expenses);
    }

    @Override
    public Expenses isExist(Long id) throws ServiceException {
        Optional<Expenses> expense = expenseRepository.findById(id);
        if(expense.isEmpty()){
            throw new ServiceException(ErrorCode.SVS_ERR_0026);
        }
        return expense.get();
    }

    @Override
    public Expenses expenseUpdate(Expenses expenseExist, ExpenseUpdate expenseUpdate) throws ServiceException {

        expenseExist.setName(expenseUpdate.getName());
        expenseExist.setExpenseHeadId(expenseUpdate.getExpenseHeadId());
        expenseExist.setInvoiceNumber(expenseUpdate.getInvoiceNumber());
        expenseExist.setDate(expenseUpdate.getDate().toInstant()
                .atZone(java.time.ZoneId.systemDefault())
                .toLocalDate());
        expenseExist.setAmount(expenseUpdate.getAmount());
        expenseExist.setDescription(expenseUpdate.getDescription());

        return expenseRepository.save(expenseExist);
    }

    @Override
    public void expenseDelete(Long id) throws ServiceException {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Expenses> getExpenses() throws ServiceException {
        List<Expenses> expenses = expenseRepository.findAll();
        if(expenses.isEmpty()){
            throw new ServiceException(ErrorCode.SVS_ERR_0026);
        }
        return expenses;
    }
    public Expenses save(Expenses status) {
        return expenseRepository.save(status);
    }
    public Expenses update(Expenses status) {
        return expenseRepository.save(status);
    }
    public void delete(Long id) {
        expenseRepository.deleteById(id);
    }
    public List<Expenses> getAll() {
        return expenseRepository.findAll();
    }
    public Expenses getById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

}
