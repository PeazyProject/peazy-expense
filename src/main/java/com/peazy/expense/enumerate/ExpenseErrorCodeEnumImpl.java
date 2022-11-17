package com.peazy.expense.enumerate;

public enum ExpenseErrorCodeEnumImpl implements ErrorCodeEunm {

	SUPPLIER_IS_EMPTY("0001"),
	ADD_MISC_EXPENSE_FAIL("0002"),
	UPDATE_MISC_EXPENSE_FAIL("0003"),
	DETAIL_MISC_EXPENSE_FAIL("0004");

	private String code;

	private ExpenseErrorCodeEnumImpl(String errorCode) {
		this.code = errorCode;
	}

	@Override
	public String getCategory() {
		return "Expense";
	}

	@Override
	public String getCode() {
		return this.code;
	}

	@Override
	public String getLang() {
		return null;
	}

}
