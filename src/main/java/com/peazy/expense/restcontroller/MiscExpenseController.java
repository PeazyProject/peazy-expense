package com.peazy.expense.restcontroller;

import java.text.ParseException;
import java.util.List;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.peazy.expense.model.args.MiscExpenseBean;
import com.peazy.expense.model.entity.MiscExpenseEntity;
import com.peazy.expense.model.request.AddMiscExpenseRequest;
import com.peazy.expense.model.request.DeleteMiscExpenseRequest;
import com.peazy.expense.model.request.UpdateMiscExpenseRequest;
import com.peazy.expense.service.interfaces.MiscExpenseService;


@CrossOrigin
@RestController
@RequestMapping(path = "/miscExpense", produces = MediaType.APPLICATION_JSON_VALUE)
public class MiscExpenseController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MiscExpenseService miscExpenseService;

    @GetMapping(value = "/getMiscExpense")
    public ResponseEntity<List<MiscExpenseEntity>> getMiscExpense(
            @RequestParam(required = false) String supplier,
            @RequestParam(required = false) String fromDate,
            @RequestParam(required = false) String toDate)
            throws JsonProcessingException, ParseException {
        List<MiscExpenseEntity> miscExpenseEntities =
                miscExpenseService.queryMiscExpenseBySupplier(supplier, fromDate, toDate);
        logger.info("getMiscExpense = {}", miscExpenseEntities);
        return ResponseEntity.ok(miscExpenseEntities);
    }

    @PostMapping(value = "/addMiscExpenses")
    public HttpStatus addMiscExpenses(@RequestBody AddMiscExpenseRequest request) {
        logger.info("addMiscExpenses = {}", request);
        try {
            if (!CollectionUtils.isEmpty(request.getMiscExpenses())) {
                for (MiscExpenseBean miscExpense : request.getMiscExpenses()) {
                    miscExpenseService.insertMiscExpense(miscExpense.getCodeKey(),
                            miscExpense.getAmount(), miscExpense.getExpenseDt());
                }
            }
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return HttpStatus.OK;
    }

    @PutMapping(value = "updateMiscExpenses")
    public HttpStatus updateMiscExpenses(@RequestBody UpdateMiscExpenseRequest request) {
        logger.info("updateMiscExpenses = {}", request);
        try {
            if (!CollectionUtils.isEmpty(request.getMiscExpenses())) {
                for (MiscExpenseBean miscExpense : request.getMiscExpenses()) {
                    miscExpenseService.updateMiscExpense(miscExpense.getSeqNo(),
                            miscExpense.getCodeKey(), miscExpense.getAmount(),
                            miscExpense.getExpenseDt());
                }
            }
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.OK;
    }

    @DeleteMapping(value = "deleteMiscExpenses")
    public HttpStatus deleteMiscExpenses(@RequestBody DeleteMiscExpenseRequest request) {
        logger.info("deleteMiscExpenses = {}", request);
        try {
            if (!CollectionUtils.isEmpty(request.getDeleteMiscExpenses())) {
                miscExpenseService.deleteMiscExpenses(request.getDeleteMiscExpenses());
            }
        } catch (Exception e) {
            logger.error(ExceptionUtils.getStackTrace(e));
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.OK;
    }
}
