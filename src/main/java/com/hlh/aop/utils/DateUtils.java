package com.hlh.aop.utils;

import org.apache.commons.lang.StringUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtils {
	public static final String YYYY_M_D = "yyyy-M-d";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
	public static final String YYYY_MM_DD_HH = "yyyy-MM-dd HH";
	public static final String YYYYMMDDHHMMSSSSS = "yyyyMMddhhmmssSSS";
	public static final String YYYY_MM_DD_HH_MM_SSSSS = "yyyy-MM-dd HH:mm:ss SSS";
	public static final String YYYYMMDD = "yyyyMMdd";
	public static final String HH_mm = "HH:mm";

	public static final String YYYY_NIAN_MM_YUE_DD_RI_HH_MM = "yyyy年MM月dd日 HH:mm";
	public static final String YYYY_NIAN_MM_YUE_DD_RI = "yyyy年MM月dd日";
	public static final String HH_mm_ss = "HH:mm:ss";
	public static final String HH_mm_ss_SSS = "HH:mm:ss SSS";
	public static final String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
	public static long getDateDiffByDay(String time1, String time2) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat(YYYY_MM_DD);
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot;
	}
	
	public static long getDateDiffByYear(String departureDate, String birthday) {
		Calendar calDeparture = Calendar.getInstance();
		calDeparture.setTime(DateUtils.parseDate(departureDate));

		Calendar calBirth = Calendar.getInstance();
		calBirth.setTime(DateUtils.parseDate(birthday));
		if (calDeparture.before(calBirth)) {
			throw new IllegalArgumentException("还未出生!");
		}

		int yearDeparture = calDeparture.get(Calendar.YEAR);
		int monthDeparture = calDeparture.get(Calendar.MONTH) + 1;
		int dayOfMonthDeparture = calDeparture.get(Calendar.DAY_OF_MONTH);

		int yearBirth = calBirth.get(Calendar.YEAR);
		int monthBirth = calBirth.get(Calendar.MONTH) + 1;
		int dayOfMonthBirth = calBirth.get(Calendar.DAY_OF_MONTH);

		int age = yearDeparture - yearBirth;

		if (monthDeparture <= monthBirth) {
			if (monthDeparture == monthBirth) {
				if (dayOfMonthDeparture < dayOfMonthBirth) {
					age--;
				}
			} else {
				age--;
			}
		}
		return age;
    }
	   	
	
	public static Date getDateAfterMinutes(long duration) {
		long curr = System.currentTimeMillis();
		curr = curr + duration * 60 * 1000;
		return new Date(curr);
	}
	
	public static Date getDateBeforeMinutes(long duration) {
        long curr = System.currentTimeMillis();
        curr = curr - duration * 60 * 1000;
        return new Date(curr);
    }
	
	public static Date getDateBeforeHours(long hours) {
        long curr = System.currentTimeMillis();
        curr = curr - hours*60 * 60 * 1000;
        return new Date(curr);
    }
	
	/**
	 * 当前时间之前几分钟
	 * @param date
	 * @param duration
	 * @return 时间串
	 */
	public static String getDateStrBeforeDateMinutes(Date date,long duration) {
		long curr = date.getTime();
		curr = curr - duration * 60 * 1000;
		SimpleDateFormat fmt = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		return fmt.format(new Date(curr));
	}
	
	/**
	 * 当前时间之后n分钟
	 * @param date
	 * @param duration
	 * @return
	 */
	public static Date getDateAfterDateMinutes(Date date,long duration) {
		long curr = date.getTime();
		curr = curr + duration * 60 * 1000;
		return new Date(curr);
	}
	
	
	/**
	 * 当前时间之后的几天
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date getDateAfterDateDays(Date date,long day) {
		long curr = date.getTime();
		curr = curr + day*24*60*60*1000;
		return new Date(curr);
	}
	
	
	/** 
     * 两个时间相差多少秒
     * 
     * @param time1 时间参数 1 格式：1990-01-01 12:00:00 
     * @param time2 时间参数 2 格式：2009-01-01 12:00:00 
     * @return String 返回值为：秒
     */  
    public static long getDateDiffBySecond(String time1, String time2) {
        long quot = 0;
        SimpleDateFormat ft = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
        try {
            Date date1 = ft.parse(time1);
            Date date2 = ft.parse(time2);
            quot = date1.getTime() - date2.getTime();
            quot = quot / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return quot;
    }
    
    /** 
     * 两个时间相差多少毫秒
     * 
     * @param time1 时间参数 1 格式：Date
     * @param time2 时间参数 2 格式：Date
     * @return String 返回值为：毫秒
     */
    public static long getDateDiffByMillisecond(Date time1, Date time2) {
        long quot = 0;
        quot = time1.getTime() - time2.getTime();
        return quot;
    }
    
    /** 
     * 两个时间相差多少秒
     * 
     * @param time1 时间参数 1 格式：Date
     * @param time2 时间参数 2 格式：Date
     * @return String 返回值为：秒
     */
    public static int getDateDiffBySecond(Date time1, Date time2) {
        long quot = 0;
        quot = time1.getTime() - time2.getTime();
        quot = quot / 1000;
        return (int)quot;
    }
	
	/** 
     * 两个时间相差多少分钟
     * 
     * @param time1 时间参数 1 格式：1990-01-01 12:00:00 
     * @param time2 时间参数 2 格式：2009-01-01 12:00:00 
     * @return String 返回值为：分钟
     */  
	public static long getDateDiffByMin(String time1, String time2) {
		long quot = 0;
		SimpleDateFormat ft = new SimpleDateFormat(YYYY_MM_DD_HH_MM_SS);
		try {
			Date date1 = ft.parse(time1);
			Date date2 = ft.parse(time2);
			quot = date1.getTime() - date2.getTime();
			quot = quot / 1000 / 60;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return quot;
	}
	
    public static int getDateDiffByHour(Date time1, Date time2) {
        long quot = 0;
        quot = time1.getTime() - time2.getTime();
        quot = quot / 1000 / 60 / 60;
        return (int) quot;
    }

	public static int getDateDiffByDay(Date time1, Date time2) {
		long quot = 0;
		quot = time1.getTime() - time2.getTime();
		quot = quot / 1000 / 60 / 60 / 24;
		return (int)quot;
	}
	
	/** 
     * 两个时间相差多少分钟
     * 
     * @param time1 时间参数 1 格式：Date
     * @param time2 时间参数 2 格式：Date
     * @return String 返回值为：分钟
     */
	public static int getDateDiffByMin(Date time1, Date time2) {
		long quot = 0;
		quot = time1.getTime() - time2.getTime();
		quot = quot / 1000 / 60;
		return (int)quot;
	}
	

	public static Date getDateDiffNDay(String strDate, int n) {
		SimpleDateFormat ft = new SimpleDateFormat(YYYY_MM_DD);
		try {
			Date dDate = ft.parse(strDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(dDate);
			calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + n);
			return calendar.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Date parseDate(String sDate, String pattern) {
		DateFormat format = new SimpleDateFormat(pattern);
		if (StringUtils.isNotEmpty(sDate)) {
			try {
				return format.parse(sDate);
			} catch (ParseException e) {
				e.printStackTrace(); // To change body of catch statement use
										// File | Settings | File Templates.
				return null;
			}
		}
		return null;
	}

	public static Date parseCnDate(String sDate) {
		return parseDate(sDate, YYYY_NIAN_MM_YUE_DD_RI);
	}

	public static Date parseDate(String sDate) {
		return parseDate(sDate, YYYY_MM_DD);
	}
	public static Date parseCnHmDate(String sDate) {
		return parseDate(sDate, YYYY_MM_DD_HH_MM_SS);
	}
    public static Date parseHhDate(String sDate) {
        return parseDate(sDate, YYYY_MM_DD_HH);
    }

	public static String formatDateByFormat(Date sDate,String Format){
		return formatDate(sDate, Format);
	}
	public static String formatDateYYYYMMDD(Date sDate) {
		return formatDate(sDate, YYYYMMDD);
	}
	
	public static String formatDate(Date sDate) {
		return formatDate(sDate, YYYY_MM_DD);
	}
	public static String formatTime(Date sDate) {
		return formatDate(sDate, HH_mm_ss);
	}
	public static String formatTimeMillisecond(Date sDate) {
		return formatDate(sDate, HH_mm_ss_SSS);
	}

	public static String formatCnDate(Date sDate) {
		return formatDate(sDate, YYYY_NIAN_MM_YUE_DD_RI);
	}
	
	public static String formatCnHmDate(Date sDate) {
		return formatDate(sDate, YYYY_MM_DD_HH_MM_SS);
	}
	
    public static String formatHhMmDate(Date sDate) {
        return formatDate(sDate, YYYY_MM_DD_HH_MM);
    }

    public static String formatHhDate(Date sDate) {
        return formatDate(sDate, YYYY_MM_DD_HH);
    }
	   
	public static String formatCnHmDateS(Date sDate) {
		return formatDate(sDate, YYYY_MM_DD_HH_MM_SSSSS);
	}
	
	public static String formatHmDate(Date sDate) {
		return formatDate(sDate, HH_mm);
	}

	public static String formatDate(Date sDate, String formatStr) {
		if (sDate == null)
			return "";
		DateFormat format = new SimpleDateFormat(formatStr);
		return format.format(sDate);
	}

    public static String formatDate(Long sDate, String formatStr) {
        if (sDate == null)
            return "";
        Date date = new Date(sDate);
        DateFormat format = new SimpleDateFormat(formatStr);
        return format.format(date);
    }

	public static String defaultFormatDate(Date sDate) {
		return formatDate(sDate, YYYY_MM_DD_HH_MM_SS);
	}

	public static boolean isValidDate(String dateStr, String pattern) {
		return formatDate(parseDate(dateStr, pattern), pattern).equals(dateStr);
	}

	public static Date addMinutes(Date date, int amount) {
		return add(date, Calendar.MINUTE, amount);
	}
	
	public static String formatDateHour(Date sDate) {
		return formatDate(sDate, YYYY_MM_DD_HH_MM);
	}
	public static Date addHours(Date date, int amount) {
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}

	public static Date addDays(Date date, int amount) {
		return add(date, Calendar.DAY_OF_MONTH, amount);
	}

	public static Date add(Date date, int calendarField, int amount) {
		if (date == null) {
			throw new IllegalArgumentException("The date must not be null");
		}
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(calendarField, amount);
		return c.getTime();
	}

	public static String getStringCurrentDateTime() {
		Calendar rightNow = Calendar.getInstance();
		int intYear = rightNow.get(Calendar.YEAR);

		int intMonth = rightNow.get(Calendar.MONTH) + 1;
		String strMonth = null;
		if (intMonth < 10) {
			strMonth = "0" + intMonth;
		} else {
			strMonth = "" + intMonth;
		}

		int intDate = rightNow.get(Calendar.DATE);
		String strDate = null;
		if (intDate < 10) {
			strDate = "0" + intDate;
		} else {
			strDate = "" + intDate;
		}

		int intHour = rightNow.get(Calendar.HOUR_OF_DAY);
		String strHour = null;
		if (intHour < 10) {
			strHour = "0" + intHour;
		} else {
			strHour = "" + intHour;
		}

		int intMinute = rightNow.get(Calendar.MINUTE);
		String strMinute = null;
		if (intMinute < 10) {
			strMinute = "0" + intMinute;
		} else {
			strMinute = "" + intMinute;
		}

		int intSecond = rightNow.get(Calendar.SECOND);
		String strSecond = null;
		if (intSecond < 10) {
			strSecond = "0" + intSecond;
		} else {
			strSecond = "" + intSecond;
		}

		return intYear + "-" + strMonth + "-" + strDate + " " + strHour + ":" + strMinute + ":" + strSecond;

	}

	/**
	 * 用来转换日期格式的公用方法
	 * 
	 * @param dateString
	 *            需要转换的时间
	 * @param sourceDateFormat
	 *            原时间格式
	 * @param destDateFormat
	 *            目的时间格式
	 * @return 转换后的时间
	 * @throws ParseException
	 *             日期格式错误时抛出的异常
	 */
	public static String convertDateFormat(String dateString, String sourceDateFormat, String destDateFormat)
			throws ParseException {
		DateFormat dfOne = new SimpleDateFormat(sourceDateFormat);
		DateFormat dfTwo = new SimpleDateFormat(destDateFormat);
		Date date = dfOne.parse(dateString);
		return dfTwo.format(date);
	}

	public static String getthreeMothDate() {
		Calendar time = Calendar.getInstance();
		time.add(Calendar.MONTH, 2);
		int dayNum = time.getActualMaximum(Calendar.DAY_OF_MONTH);
		time.set(Calendar.DATE, dayNum);
		Date date = time.getTime();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String format = df.format(date);
		return format;
	}
	public static String formatDateMinute(Date sDate) {
		return formatDate(sDate, YYYY_MM_DD_HH_MM);
	}
	
	public static Date parseCnMinuteDate(String sDate) {
		return parseDate(sDate, YYYY_MM_DD_HH_MM);
	}
	
	public static String getDateToString() {
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}

	public static String getNextDateToString(long n) {
		Date date = new Date(new Date().getTime() + 1000 * 3600 * 24 * n);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(date);
	}
	
	public static Date getNextYearToString(Date date) {
	    Calendar time = Calendar.getInstance();
	    time.setTime(date);
	    time.add(Calendar.YEAR,1);
        return time.getTime();
    }
	
	public static String getBeforeDateToString(long n) {
	    Date date = new Date(new Date().getTime() - 1000 * 3600 * 24*n);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

	public static Date getDateNotTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}
	
	public static Date getNowDateWithOutTime() {
		Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

	public static boolean isBeforeEquals(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		Date d1 = parseDate(formatDate(date1));
		Date d2 = parseDate(formatDate(date2));
		return !d1.after(d2);
	}

	public static boolean isAfterEquals(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		Date d1 = parseDate(formatDate(date1));
		Date d2 = parseDate(formatDate(date2));
		return !d1.before(d2);
	}
	
	public static Boolean isSameEquals(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return false;
		}
		return formatDate(date1).equals(formatDate(date2));
	}
	
	public static int getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
	
	public static int getMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}
	
	public static int getDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public static int getHourOfDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.HOUR_OF_DAY);
	}
	
	/**
	 * 根据两个日期得出年龄，带小数
	 * 注：nowDate大于birthDay的日期时，年龄多加0.5岁（不考虑年份）;owDate小于birthDay的日期时，年龄多减0.5岁（不考虑年份）;
	 * 例：过了12岁，就是12.5岁;79未满80，就是79.5岁;
	 * @param birthDay
	 * @param nowDate
	 * @return
	 */
	public static double getAge(Date birthDay, Date nowDate) {
		int year = getYear(birthDay);
		int month = getMonth(birthDay);
		int day = getDay(birthDay);
		int year1 = getYear(nowDate);
		int month1 = getMonth(nowDate);
		int day1 = getDay(nowDate);
		
		double age = year1 - year;
		if(month1 > month || (month1 == month && day1 > day)) {
			age+=0.5;
		}
		if(month1 < month || (month1 == month && day1 < day)) {
			age-=0.5;
		}
		return age;
	}
	
	/**
	 * 转换long类型的日期
	 * @param date long类型的事件
	 * @param pattern 要转换的格式
	 * @return 返回的字符串日期格式
	 */
	public static String parseDate(long date, String pattern){
		
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		return format.format(date);
	}
	
	
	/**
	 * 根据日期获得星期
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekOfDate(Date date) {
		String[] weekDaysName = { "周日", "周一", "周二", "周三", "周四", "周五",
				"周六" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		return weekDaysName[intWeek];
	}
	
	public static Integer getWeekOfDateInt(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int intWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1 ;
		return intWeek;
	}

	
	/**
	 * 当前日期分钟相加或相减所得日期（+,-）操作,输入一个日期得到分钟加减后的日期。
	 * 
	 * @param date
	 * @return
	 */
	public static Date DsDay_Minute(Date date, int minute) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int minutes = calendar.get(Calendar.MINUTE);
		calendar.set(Calendar.MINUTE, minutes + minute);
		return calendar.getTime();
	}
	
	/**
	 * 判断两个时间的大小.
	 * 
	 * @param startTime
	 * @param endTime
	 * @return
	 */
	public static boolean isCompareTime(Date startTime, Date endTime) {
		if (endTime.getTime() > startTime.getTime()) {
			return true;
		} else {
			return false;
		}

	}
	
	/**
	 * 格式时间
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String getFormatDate(Date date, String format) {
		if (date != null) {
			SimpleDateFormat f = new SimpleDateFormat(format);
			return f.format(date);
		} else {
			return null;
		}
	}
	
	/**
	 * 当前日期小时相加或相减所得日期（+,-）操作,输入一个日期得到天数加减后的日期。
	 * 
	 * @param date
	 * @return
	 */
	public static Date DsDay_Hour(Date date, Integer hours) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, hours);

		return cal.getTime();
	}
	
	/**
	 * 当前日期分钟相加或相减所得日期（+,-）操作,输入一个日期得到天数加减后的日期。
	 * 
	 * @param date
	 * @return
	 */
	public static Date DsDay_Minute(Date date, Integer minutes) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE, minutes);
		return cal.getTime();
	}
	
	
	/**
	 * 当前日期小时相加或相减所得日期（+,-）操作,输入一个日期得到天数加减后的日期。
	 * 
	 * @param date
	 * @return
	 */
	public static Date DsDay_Date(Date date, Integer dates) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, dates);

		return cal.getTime();
	}
	
	
	public static List<String> getBetweenDays(Date startDay,Date endDay){
		List<String> middles = new ArrayList<String>();
		
		Calendar start = Calendar.getInstance();
		start.setTime(startDay);
		
		Calendar end = Calendar.getInstance();
		end.setTime(endDay);

		Calendar middle = start;
		while(true){
			if(middle.compareTo(start)>=0 && middle.compareTo(end)<=0){
				middles.add(DateUtils.formatDate(middle.getTime(), DateUtils.YYYY_M_D));
			}
			
			if(middle.compareTo(end)>0){
				break;
			}
			
			middle.add(Calendar.DATE, 1);
		}
		return middles;
	}
	
	 /**
	  * 得到现在时间
	  * 
	  * @return 字符串 yyyyMMdd HHmmss
	  */
	 public static String getStringToday() {
	  Date currentTime = new Date();
	  SimpleDateFormat formatter = new SimpleDateFormat(DateUtils.YYYYMMDDHHMMSS);
	  String dateString = formatter.format(currentTime);
	  return dateString;
	 }
	 
	 /**
	  * 本月第一天
	  * @param date
	  * @return
	  */
	public static Date getFirstdayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}
	 
	/**
	 *  本月最后一天
	 * @param date
	 * @return
	 */
	public static Date getLastdayOfMonth(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int value = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, value);
		date = cal.getTime();
		return date;
	}	
	
	  public static void main(String[] args) {
		    System.out.println(getStringToday());
	        System.out.println(getDateDiffByYear("2012-11-1", "1985-9-1"));
	        System.out.println(formatCnHmDate(getNextYearToString(new Date())));
	        System.out.println(getDateDiffByHour(new Date(), parseHhDate("2015-09-10 14:55:40")));
	        System.out.println(formatCnHmDate(getDateAfterMinutes(-5)));
	        System.out.println(formatCnHmDate(getDateBeforeMinutes(5)));
	        System.out.println(getNextDateToString(30));
	        System.out.println(formatHhDate(new Date()));
	        System.out.println(parseHhDate(formatHhDate(new Date())));
	        System.out.println(formatHhDate(parseHhDate("2015-09-10 15:03:40")));
	        System.out.println(isBeforeEquals(new Date(), parseHhDate("2015-09-17 15:03:40")));
	        System.out.println(isAfterEquals(new Date(), parseHhDate("2015-09-15 15:03:40")));
	        String str = "VST:60,DEFAULT:30";
	        System.out.println(DsDay_Minute(new Date(),-5));
	    }

}
