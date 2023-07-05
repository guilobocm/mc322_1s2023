package models.utils;

import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    public static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        return calendar;
    }
}
