package com.peazy.expense.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.StringUtils;
import com.peazy.expense.enumerate.DateFormatEnum;

public class DateUtils {
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT =
            new SimpleDateFormat(DateFormatEnum.YYYYMMDD_SLASH.getDateFormatString());

    public static Date formatDate(String dateString) throws ParseException {
        return StringUtils.isNotBlank(dateString) ? SIMPLE_DATE_FORMAT.parse(dateString) : null;
    }

    public static Date addDate(Date originDate, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(originDate);
        calendar.add(Calendar.DATE, day);
        return calendar.getTime();
    }

    public static Date setCurrentDate(Date originDate) {
        if (originDate != null) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(originDate);
            calendar.add(Calendar.HOUR, 23);
            calendar.add(Calendar.MINUTE, 59);
            calendar.add(Calendar.SECOND, 59);
            return calendar.getTime();
        }
        return originDate;
    }
}
