package sis.util;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by bollsal on 2016. 11. 22..
 */
public class DateUtil {

    public static Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        return calendar.getTime();
    }

    public static Date getEndDate(Date startDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.setTime(startDate);
        calendar.add(Calendar.DAY_OF_YEAR, 16 * 7 - 3);
        return calendar.getTime();
    }
}
