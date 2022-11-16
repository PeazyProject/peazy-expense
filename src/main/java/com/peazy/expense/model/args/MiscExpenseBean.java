package com.peazy.expense.model.args;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class MiscExpenseBean {
    private long seqNo;
    private String codeKey;
    private String amount;
}
