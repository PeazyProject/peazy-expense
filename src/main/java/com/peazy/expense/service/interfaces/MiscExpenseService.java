package com.peazy.expense.service.interfaces;

import java.text.ParseException;
import java.util.List;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.expense.model.entity.MiscExpenseEntity;

public interface MiscExpenseService {
    public List<MiscExpenseEntity> queryMiscExpenseBySupplier(String supplier, String fromDate,
            String toDate) throws JsonProcessingException, ParseException;

    public void insertMiscExpense(String codeKey, String amount, String expenseDt)
            throws ParseException;

    public void deleteMiscExpenses(List<Long> seqNos);

    public void updateMiscExpense(long seqNo, String codeKey, String amount, String expenseDt)
            throws ParseException;
}
