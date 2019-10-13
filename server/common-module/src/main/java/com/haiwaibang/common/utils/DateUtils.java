package com.haiwaibang.common.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by msg on 2018/3/26.
 */
public class DateUtils {
    public static final String ISO_DATE_FORMAT = "yyyyMMdd";
    public static final String ISO_EXPANDED_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATEMIN_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String DATE_PATTERN = "yyyyMMddHHmmss";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String MONTH_PATTERN = "MM";
    public static final String DAY_PATTERN = "dd";
    public static final String HOUR_PATTERN = "HH";
    private static Random random = new Random();
    private DateUtils(){

    }

    public static synchronized String generateId() {
        StringBuilder result = new StringBuilder();
        result = result.append(System.currentTimeMillis());

        for(int i = 0; i < 10; ++i) {
            result = result.append(random.nextInt(10));
        }

        return result.toString();
    }

    protected static final float normalizedJulian(float jd) {
        return (float)Math.round(jd + 0.5F) - 0.5F;
    }

    public static final Date toDate(float jd) {
        float z = normalizedJulian(jd) + 0.5F;
        float w = (float)((int)((z - 1867216.2F) / 36524.25F));
        float x = (float)((int)(w / 4.0F));
        float a = z + 1.0F + w - x;
        float b = a + 1524.0F;
        float c = (float)((int)(((double)b - 122.1D) / 365.25D));
        float d = (float)((int)(365.25F * c));
        float e = (float)((int)((double)(b - d) / 30.6001D));
        float f = (float)((int)(30.6001F * e));
        int day = (int)(b - d - f);
        int month = (int)(e - 1.0F);
        if(month > 12) {
            month -= 12;
        }

        int year = (int)(c - 4715.0F);
        if(month > 2) {
            --year;
        }

        Calendar calendar = Calendar.getInstance();
        calendar.set(1, year);
        calendar.set(2, month - 1);
        calendar.set(5, day);
        return calendar.getTime();
    }

    public static final int daysBetween(Date early, Date late) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(early);
        c2.setTime(late);
        return daysBetween(c1, c2);
    }

    public static final int daysBetween(Calendar early, Calendar late) {
        return (int)(toJulian(late) - toJulian(early));
    }

    public static final float toJulian(Calendar calendar) {
        int y = calendar.get(1);
        int m = calendar.get(2);
        int d = calendar.get(5);
        int a = y / 100;
        int b = a / 4;
        int c = 2 - a + b;
        float e = (float)((int)(365.25F * (float)(y + 4716)));
        float f = (float)((int)(30.6001F * (float)(m + 1)));
        return (float)(c + d) + e + f - 1524.5F;
    }

    public static final float toJulian(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return toJulian(c);
    }

    public static final String dateIncrease(String isoString, String fmt, int field, int amount) {
        try {
            Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
            cal.setTime(stringToDate(isoString, fmt));
            cal.add(field, amount);
            return dateToString(cal.getTime(), fmt);
        } catch (Exception var5) {
            return null;
        }
    }

    public static final String roll(String isoString, String fmt, int field, boolean up){
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(stringToDate(isoString, fmt));
        cal.roll(field, up);
        return dateToString(cal.getTime(), fmt);
    }

    public static final String roll(String isoString, int field, boolean up) {
        return roll(isoString, DATETIME_PATTERN, field, up);
    }

    public static Date stringToDateWithFormat(String dateText, String format) {
        if(dateText == null) {
            return null;
        } else {
            SimpleDateFormat df = null;

            try {
                if(format == null) {
                    df = new SimpleDateFormat();
                } else {
                    df = new SimpleDateFormat(format);
                }

                df.setLenient(false);
                return df.parse(dateText);
            } catch (ParseException var5) {
                return null;
            }
        }
    }

    public static Timestamp getCurrentTimestamp() {
        return new Timestamp((new Date()).getTime());
    }

    public static Date stringToDate(String dateString, String format) {
        return stringToDateWithFormat(dateString, format);
    }

    public static Date stringToDate(String dateString) {
        return stringToDateWithFormat(dateString, ISO_EXPANDED_DATE_FORMAT);
    }

    public static String dateToString(Date date, String pattern) {
        if(date == null) {
            return null;
        } else {
            try {
                SimpleDateFormat sfDate = new SimpleDateFormat(pattern);
                sfDate.setLenient(false);
                return sfDate.format(date);
            } catch (Exception var3) {
                return null;
            }
        }
    }

    public static String dateToString(Date date) {
        return dateToString(date, ISO_EXPANDED_DATE_FORMAT);
    }

    public static Date getCurrentDateTime() {
        Calendar calNow = Calendar.getInstance();
        return calNow.getTime();
    }

    public static String getCurrentDateString(String pattern) {
        return dateToString(getCurrentDateTime(), pattern);
    }

    public static String getCurrentDateString() {
        return dateToString(getCurrentDateTime(), ISO_EXPANDED_DATE_FORMAT);
    }

    public static String dateToStringWithTime() {
        return dateToString(new Date(), DATETIME_PATTERN);
    }

    public static String dateToStringWithTime(Date date) {
        return dateToString(date, DATETIME_PATTERN);
    }

    public static Date dateIncreaseByDay(Date date, int days) {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(date);
        cal.add(5, days);
        return cal.getTime();
    }

    public static Date dateIncreaseByMonth(Date date, int mnt) {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(date);
        cal.add(2, mnt);
        return cal.getTime();
    }

    public static Date dateIncreaseByYear(Date date, int mnt) {
        Calendar cal = GregorianCalendar.getInstance(TimeZone.getTimeZone("GMT"));
        cal.setTime(date);
        cal.add(1, mnt);
        return cal.getTime();
    }

    public static String dateIncreaseByDay(String date, int days) {
        return dateIncreaseByDay(date, ISO_DATE_FORMAT, days);
    }

    public static String dateIncreaseByDay(String date, String fmt, int days) {
        return dateIncrease(date, fmt, 5, days);
    }

    public static String stringToString(String src, String srcfmt, String desfmt) {
        return dateToString(stringToDate(src, srcfmt), desfmt);
    }

    public static String getYear(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat(YEAR_PATTERN);
        return formater.format(date);
    }

    public static String getMonth(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat(MONTH_PATTERN);
       return formater.format(date);
    }

    public static String getDay(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat(DAY_PATTERN);
        return formater.format(date);
    }

    public static String getHour(Date date) {
        SimpleDateFormat formater = new SimpleDateFormat(HOUR_PATTERN);
        return formater.format(date);
    }

    public static int getMinsFromDate(Date dt) {
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(dt);
        int hour = cal.get(11);
        int min = cal.get(12);
        return hour * 60 + min;
    }

    public static Date convertToDate(String str, boolean isExpiry) {
        SimpleDateFormat fmt = new SimpleDateFormat(DATEMIN_PATTERN);
        Date dt = null;

        try {
            dt = fmt.parse(str);
        } catch (ParseException var6) {
            Calendar cal = Calendar.getInstance();
            if(isExpiry) {
                cal.add(5, 1);
                cal.set(11, 23);
                cal.set(12, 59);
            } else {
                cal.set(11, 0);
                cal.set(12, 0);
            }

            dt = cal.getTime();
        }

        return dt;
    }

    public static Date convertToDate(String str) {
        SimpleDateFormat fmt = new SimpleDateFormat(DATEMIN_PATTERN);
        Date dt = null;

        try {
            dt = fmt.parse(str);
        } catch (ParseException var4) {
            dt = new Date();
        }

        return dt;
    }

    public static String dateFromat(Date date, int minute) {
        int year = Integer.parseInt(getYear(date));
        int month = Integer.parseInt(getMonth(date));
        int day = Integer.parseInt(getDay(date));
        int hour = minute / 60;
        int min = minute % 60;
        return year + (month > 9?String.valueOf(month):"0" + month) + (day > 9?String.valueOf(day):"0" + day) + " " + (hour > 9?String.valueOf(hour):"0" + hour) + (min > 9?String.valueOf(min):"0" + min)  + "00";
    }

    public static String sDateFormat() {
        return (new SimpleDateFormat(DATE_PATTERN)).format(Calendar.getInstance().getTime());
    }
}
