package com.peazy.expense.model.request;

import java.util.List;
import com.peazy.expense.model.args.MiscExpenseBean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class AddMiscExpenseRequest {
    private List<MiscExpenseBean> miscExpenses;
}
