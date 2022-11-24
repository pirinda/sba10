/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sba.lib;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.joda.time.DateTime;
import org.joda.time.Period;

/**
 *
 * @author Sergio Flores
 */
public abstract class DLibTimeUtils {

    /**
     * @param locale Locale desired.
     * @return First day of week with java.util.Calendar constants.
     */
    public static int getFirstDayOfWeek(final Locale locale) {
        return new GregorianCalendar(locale).getFirstDayOfWeek();
    }

    public static int getFirstDayOfWeekStd() {
        return Calendar.SUNDAY;
    }

    /**
     * @param locale Locale desired.
     * @param calendarStyle Calendar.SHORT or Calendar.LONG.
     * @return Days of week names.
     */
    public static String[] createDaysOfWeek(final Locale locale, final int calendarStyle) {
        int day = 0;
        String name = "";
        String[] names = new String[7];
        GregorianCalendar gc = new GregorianCalendar(locale);
        Set<Map.Entry<String, Integer>> set = gc.getDisplayNames(Calendar.DAY_OF_WEEK, calendarStyle, locale).entrySet();
        Object[] array = set.toArray();

        day = gc.getFirstDayOfWeek();
        for (int i = 0; i < names.length; i++) {
            name = "";
            for (Object entry : array) {
                if (day == (Integer) ((Map.Entry) entry).getValue()) {
                    name = (String) ((Map.Entry) entry).getKey();
                    break;
                }
            }

            names[i] = name;
            if (++day > names.length) {
                day = 1;
            }
        }

        return names;
    }

    /**
     * @param calendarStyle Calendar.SHORT or Calendar.LONG.
     * @return Days of week names.
     */
    public static String[] createDaysOfWeekStd(final int calendarStyle) {
        String name = "";
        String[] names = new String[7];
        GregorianCalendar gc = new GregorianCalendar();
        Set<Map.Entry<String, Integer>> set = gc.getDisplayNames(Calendar.DAY_OF_WEEK, calendarStyle, Locale.getDefault()).entrySet();
        Object[] array = set.toArray();

        for (int i = 1; i <= names.length; i++) {
            name = "";
            for (Object entry : array) {
                if (i == (Integer) ((Map.Entry) entry).getValue()) {
                    name = (String) ((Map.Entry) entry).getKey();
                    break;
                }
            }

            names[i - 1] = name;
        }

        return names;
    }

    /**
     * @param locale Locale desired.
     * @param calendarStyle Calendar.SHORT or Calendar.LONG.
     * @return Months of year names.
     */
    public static String[] createMonthsOfYear(final Locale locale, final int calendarStyle) {
        String name = "";
        String[] names = new String[12];
        GregorianCalendar calendar = new GregorianCalendar(locale);
        Set<Map.Entry<String, Integer>> set = calendar.getDisplayNames(Calendar.MONTH, calendarStyle, locale).entrySet();
        Object[] array = set.toArray();

        for (int i = 0; i < names.length; i++) {
            name = "";
            for (Object entry : array) {
                if (i == (Integer) ((Map.Entry) entry).getValue()) {
                    name = (String) ((Map.Entry) entry).getKey();
                    break;
                }
            }

            names[i] = name;
        }

        return names;
    }

    /**
     * @param calendarStyle Calendar.SHORT or Calendar.LONG.
     * @return Months of year names.
     */
    public static String[] createMonthsOfYearStd(final int calendarStyle) {
        return createMonthsOfYear(Locale.getDefault(), calendarStyle);
    }

    /*
     * Convert to Date Only method
     */

    public static Date convertToDateOnly(final Date datetime) {
        int[] date = null;
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(datetime);
        date = new int[] { calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE) };

        return createDate(date[0], date[1], date[2]);
    }

    /*
     * Create Date methods
     */

    public static Date createDate(final int year) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.clear();
        calendar.set(year, 0, 1, 0, 0, 0);
        return calendar.getTime();
    }

    public static Date createDate(final int year, final int month) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.clear();
        calendar.set(year, month - 1, 1, 0, 0, 0);
        return calendar.getTime();
    }

    public static Date createDate(final int year, final int month, final int day) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.clear();
        calendar.set(year, month - 1, day, 0, 0, 0);
        return calendar.getTime();
    }

    /*
     * Digest Date methods
     */

    public static int[] digestDate(final Date date) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(convertToDateOnly(date));
        return new int[] { calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE) };
    }

    public static int[] digestMonth(final Date date) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(convertToDateOnly(date));
        return new int[] { calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1 };
    }

    public static int[] digestYear(final Date date) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(convertToDateOnly(date));
        return new int[] { calendar.get(Calendar.YEAR) };
    }

    /*
     * Get BOM, EOM, BOY and EOY methods
     */

    public static int getMaxDayOfMonth(final Date date) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(convertToDateOnly(date));
        return calendar.getActualMaximum(Calendar.DATE);
    }

    public static Date getBeginOfMonth(final Date date) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(convertToDateOnly(date));
        calendar.set(GregorianCalendar.DATE, 1);
        return calendar.getTime();
    }

    public static Date getEndOfMonth(final Date date) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(convertToDateOnly(date));
        calendar.set(GregorianCalendar.DATE, getMaxDayOfMonth(convertToDateOnly(date)));
        return calendar.getTime();
    }

    public static Date getBeginOfYear(final Date date) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(convertToDateOnly(date));
        calendar.set(GregorianCalendar.MONTH, 0);
        calendar.set(GregorianCalendar.DATE, 1);
        return calendar.getTime();
    }

    public static Date getEndOfYear(final Date date) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(convertToDateOnly(date));
        calendar.set(GregorianCalendar.MONTH, 11);
        calendar.set(GregorianCalendar.DATE, 31);
        return calendar.getTime();
    }

    public static Date[] getWholeMonth(final Date date) {
        return new Date[] { getBeginOfMonth(date), getEndOfMonth(date) };
    }

    public static Date[] getWholeYear(final Date date) {
        return new Date[] { getBeginOfYear(date), getEndOfYear(date) };
    }

    /*
     * Check if Date belongs to period and other validation methods
     */

    /**
     * Checks if date belongs to provided period.
     * @param date Date about to be evaluated.
     * @param periodStart Period's starting date.
     * @param periodEnd Period's ending date.
     * @return <code>true</code> if date belongs to provided period.
     */
    public static boolean isBelongingToPeriod(final Date date, final Date periodStart, final Date periodEnd) {
        boolean belongs = false;
        java.util.Date tPeriodStart = convertToDateOnly(periodStart);
        java.util.Date tPeriodEnd = convertToDateOnly(periodEnd);
        java.util.Date tDate = convertToDateOnly(date);
        
        if (!tPeriodStart.after(tPeriodEnd)) { // check that period is closed
            belongs = !(tDate.before(convertToDateOnly(periodStart)) || tDate.after(convertToDateOnly(periodEnd)));
        }

        return belongs;
    }

    /**
     * Checks if time span belongs to provided period.
     * @param spanStart Time-span's starting date about to be evaluated.
     * @param spanEnd Time-span's ending date about to be evaluated, when null means that time span is unlimited.
     * @param periodStart Period's starting date.
     * @param periodEnd Period's ending date.
     * @return <code>true</code> if time span belongs to provided period.
     */
    public static boolean isBelongingToPeriod(final Date spanStart, final Date spanEnd, final Date periodStart, final Date periodEnd) {
        boolean belongs = false;
        java.util.Date spaSta = convertToDateOnly(spanStart);
        java.util.Date spaEnd = spanEnd == null ? null : convertToDateOnly(spanEnd);
        java.util.Date perSta = convertToDateOnly(periodStart);
        java.util.Date perEnd = convertToDateOnly(periodEnd);
        
        if ((spaEnd == null || !spaSta.after(spaEnd)) && !perSta.after(perEnd)) { // check that time span and period are closed
            if (spaEnd == null) {
                // time span is unlimited
                
                // time span belongs if:
                // a) time-span' start is less or equal than period' end.
                belongs = spaSta.before(perEnd) || isSameDate(spaSta, perEnd);
            }
            else {
                // time span is limited
                
                // time span belongs if:
                // a) time-span' start is less or equal than period' start and time-span' end is greater or equal than period' start; or
                // b) time-span' start is greater or equal than period' start and time-span' start is less or equal than period' end.
                
                if ((spaSta.before(perSta) || isSameDate(spaSta, perSta)) && (isSameDate(spaEnd, perSta) || spaEnd.after(perSta))) {
                    belongs = true;
                }
                else if ((spaSta.after(perSta) || isSameDate(spaSta, perSta)) && (spaSta.before(perEnd) || isSameDate(spaSta, perEnd))) {
                    belongs = true;
                }
            }
        }
        
        return belongs;
    }

    public static boolean isBelongingToPeriod(final Date date, final int year, final int month) {
        java.util.Date aux = createDate(year, month);
        java.util.Date auxBom = getBeginOfMonth(aux);
        java.util.Date auxEom = getEndOfMonth(aux);
        java.util.Date curDate = convertToDateOnly(date);

        return curDate.getTime() >= auxBom.getTime() && curDate.getTime() <= auxEom.getTime();
    }

    public static boolean isSameDate(final Date date1, final Date date2) {
        boolean same = true;

        if (date1 == null && date2 != null || date1 != null && date2 == null) {
            same = false;
        }
        else if (!DLibUtils.compareKeys(digestDate(date1), digestDate(date2))) {
            same = false;
        }

        return same;
    }

    public static boolean isSameDatetime(final Date date1, final Date date2) {
        boolean same = true;

        if (date1 == null && date2 != null || date1 != null && date2 == null) {
            same = false;
        }
        else if (date1.getTime() != date2.getTime()) {
            same = false;
        }

        return same;
    }

    public static void validatePeriod(Date periodStart, Date periodEnd) throws Exception {
        if (periodStart.compareTo(periodEnd) > 0) {
            throw new Exception("Las fecha inicial (" + DLibUtils.DateFormatDate.format(periodStart) + ") "
                    + "debe ser anterior o igual a la fecha final (" + DLibUtils.DateFormatDate.format(periodEnd) + ").");
        }
    }

    public static void validatePeriod(int year, Date periodStart, Date periodEnd) throws Exception {
        int[] start = DLibTimeUtils.digestDate(periodStart);
        int[] end = DLibTimeUtils.digestDate(periodEnd);

        if (!(year == start[0] && year == end[0])) {
            throw new Exception("Las fechas inicial (" + DLibUtils.DateFormatDate.format(periodStart) + ") "
                    + "y final (" + DLibUtils.DateFormatDate.format(periodEnd) + ") deben pertenecer al año " + year + ".");
        }
        else if (periodStart.compareTo(periodEnd) > 0) {
            throw new Exception("La fecha inicial (" + DLibUtils.DateFormatDate.format(periodStart) + ") "
                    + "debe ser anterior o igual a la fecha final (" + DLibUtils.DateFormatDate.format(periodEnd) + ").");
        }
    }

    /*
     * Miscellaneous Date methods
     */

    public static boolean isLeapYear(final int year) {
        return year % 4 == 0;
    }

    public static boolean isLeapYear(final Date date) {
        return isLeapYear(digestYear(date)[0]);
    }

    public static Date addDate(final Date date, final int addYear, final int addMonth, final int addDay) {
        GregorianCalendar calendar = new GregorianCalendar();

        calendar.setTime(convertToDateOnly(date));
        calendar.add(Calendar.YEAR, addYear);
        calendar.add(Calendar.MONTH, addMonth);
        calendar.add(Calendar.DATE, addDay);
        return calendar.getTime();
    }

    public static long getDaysDiff(final Date newer, final Date older) {
        return (newer.getTime() - older.getTime()) / (1000L * 60L * 60L * 24L);
    }

    public static long getHoursDiff(final Date newer, final Date older) {
        return (newer.getTime() - older.getTime()) / (1000L * 60L * 60L);
    }
    
    public static int countPeriodDays(final Date periodStart, final Date periodEnd) {
        return (int) getDaysDiff(periodEnd, periodStart) + 1;
    }

    /**
     * Formats date as age in format '9 y, 9 m'. 'y' stands for year, and 'm' for month.
     * @param date Base date.
     * @param today Today.
     * @return Formatted string.
     */
    public static String formatAge(final Date date, final Date today) {
        String string = "";
        
        if (date != null) {
            DateTime start = new DateTime(date);
            DateTime end = new DateTime(today);
            Period period = new Period(start, end);
            
            string = "" + period.getYears() + " a, " + period.getMonths() + " m";
        }
        
        return string;
    }
    
    /**
     * Formats period of dates considereing if they are from the same year or same month.
     * @param startDate Start date of period.
     * @param endDate End date of period.
     * @return Formatted string.
     */
    public static String dateFormatDatePeriodLong(final Date startDate, final Date endDate) {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.setTime(startDate); 
        end.setTime(endDate);
        
        if (start.get(Calendar.YEAR) != start.get(Calendar.YEAR)) {
            return DLibUtils.DateFormatDateLong.format(startDate) + " al " + DLibUtils.DateFormatDateLong.format(endDate);
        }
        else if (start.get(Calendar.MONTH) != start.get(Calendar.MONTH)) {
            return DLibUtils.DateFormatDateDayMonthLong.format(startDate) + " al " + DLibUtils.DateFormatDateLong.format(endDate);
        }
        else {
            return DLibUtils.DateFormatDateDay.format(startDate) + " al " + DLibUtils.DateFormatDateLong.format(endDate);
        }
    }
}
