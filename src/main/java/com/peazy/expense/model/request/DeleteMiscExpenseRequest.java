package com.peazy.expense.model.request;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class DeleteMiscExpenseRequest {
    private List<Long> deleteMiscExpenses;
}
