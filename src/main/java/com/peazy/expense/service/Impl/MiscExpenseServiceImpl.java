package com.peazy.expense.service.Impl;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.expense.model.entity.MiscExpenseEntity;
import com.peazy.expense.repository.MiscExpenseRepository;
import com.peazy.expense.service.interfaces.MiscExpenseService;
import com.peazy.expense.util.DateUtils;

@Service
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeout = 36000,
        rollbackFor = Exception.class)
public class MiscExpenseServiceImpl implements MiscExpenseService {
    @Autowired
    private MiscExpenseRepository miscExpenseRepository;

    public List<MiscExpenseEntity> queryMiscExpenseBySupplier(String supplier, String fromDate,
            String toDate) throws JsonProcessingException, ParseException {
        return miscExpenseRepository.queryExpense(supplier, DateUtils.formatDate(fromDate),
                DateUtils.setCurrentDate(DateUtils.formatDate(toDate)));
    }

    public void insertMiscExpense(String codeKey, String amount, String expenseDt)
            throws ParseException {
        MiscExpenseEntity miscExpenseEntity = new MiscExpenseEntity();
        miscExpenseEntity.setCodeKey(codeKey);
        miscExpenseEntity.setAmount(amount);
        miscExpenseEntity.setExpenseDt(
                StringUtils.isNotBlank(expenseDt) ? DateUtils.formatDate(expenseDt) : new Date());
        // TODO created by & last update by can not be hard code
        miscExpenseEntity.setCreateUser("Hard Code");
        miscExpenseEntity.setUpdateUser("Hard Code");
        miscExpenseRepository.save(miscExpenseEntity);
    }

    public void deleteMiscExpenses(List<Long> seqNos) {
        miscExpenseRepository.deleteBySeqNoIn(seqNos);
    }

    public void updateMiscExpense(long seqNo, String codeKey, String amount, String expenseDt)
            throws ParseException {
        Optional<MiscExpenseEntity> miscExpenseEntityOpt = miscExpenseRepository.findById(seqNo);
        if (miscExpenseEntityOpt.isPresent()) {
            MiscExpenseEntity miscExpenseEntity = miscExpenseEntityOpt.get();
            System.err.println(miscExpenseEntity.toString());
            miscExpenseEntity.setCodeKey(
                    StringUtils.isNotBlank(codeKey) ? codeKey : miscExpenseEntity.getCodeKey());
            miscExpenseEntity.setAmount(
                    StringUtils.isNotBlank(amount) ? amount : miscExpenseEntity.getAmount());
            miscExpenseEntity.setExpenseDt(
                    StringUtils.isNotBlank(expenseDt) ? DateUtils.formatDate(expenseDt)
                            : miscExpenseEntity.getExpenseDt());
            miscExpenseRepository.save(miscExpenseEntity);
        }
    }
}
