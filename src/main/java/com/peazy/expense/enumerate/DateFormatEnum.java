package com.peazy.expense.enumerate;

public enum DateFormatEnum {
    YYYYMMDD_SLASH("yyyy/MM/dd");

    String dateFormatString;

    private DateFormatEnum(String dateFormatString) {
        this.dateFormatString = dateFormatString;
    }

    public String getDateFormatString() {
        return dateFormatString;
    }

    @Override
    public String toString() {
        return this.getDateFormatString();
    }
}
