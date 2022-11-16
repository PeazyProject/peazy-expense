package com.peazy.expense.model.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "Supplier_MiscExpense", schema = "alanlee")
@Data
public class MiscExpenseEntity {
	@Id
	@Column(name = "SeqNo", unique = true, nullable = false)
	private long seqNo;
	private String codeKey;
	private String amount;
	private Date expenseDt;
	private String createUser;
	private Date createDt;
	private String updateUser;
	private Date updateDt;
}
