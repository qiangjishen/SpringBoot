package cn.cnnic.sprngBoot2Famework.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static DateUtil dateUtil;
	
	private static final String LONG_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String STR_DATE_PATTERN = "yyyyMMdd";
	
	private SimpleDateFormat sdf;

	private DateUtil() {
		this.sdf = new SimpleDateFormat();
	}

	public static DateUtil getInstance() {
		if (null == dateUtil) {
			dateUtil = new DateUtil();
		}
		return dateUtil;
	}
	

	public static String formatLongPattern(Date date) {
		return format(date, LONG_PATTERN);
	}

	public String flp(Date date) {
		return formatLongPattern(date);
	}
	
	/**
	 * 
	 * @param date
	 * @param timeType
	 * @param flag   0表示开始  1表示结束时间
	 * @return
	 */
	public static Date getDatefromString(String date, String timeType) {
		Date eDate = null;
		String pattern = "";
		
		if(timeType.equals("day")) {
			pattern = "yyyy-MM-dd";
		}else {
			if(timeType.equals("hour")) {
				pattern = "yyyy-MM-dd HH";
			}else {
				pattern = "yyyy-MM-dd HH:mm";
			}
		}
		
		try {
		
				SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);

					eDate=dateFormat.parse(date);
	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return eDate;
	}
	
	
	/**
	 * 针对秒为59的进行特殊处理，不了计算天数准确
	 * @param date
	 * @param timeType
	 * @param flag   0表示开始  1表示结束时间
	 * @return
	 */
	public static Date getEndDatefromString(String date, String timeType) {
		Date eDate = null;
		String pattern = "";
		
		if(timeType.equals("day")) {
			pattern = "yyyy-MM-dd";
		}else {
			if(timeType.equals("hour")) {
				pattern = "yyyy-MM-dd HH";
			}else {
				pattern = "yyyy-MM-dd HH:mm:ss";
			}
		}
		
		try {
		
				SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);

					eDate=dateFormat.parse(date);
	
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return eDate;
	}

	public static String format(Date date, String pattern) {
		if (date == null)
			return null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(pattern);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	public static String formatWithOutPattern(Date date) {
		if (date == null)
			return null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(LONG_PATTERN);
			return sdf.format(date);
		} catch (Exception e) {
			return null;
		}
	}
	
	
	public static String getTodayDate() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
		return f.format(d);
	}
	
	
	public static String getTodayTime() {
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
		Date d = new Date();
		return f.format(d);
	}
	
	public static String getDate2String(Date d) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		return f.format(d);
	}

	public static Date getTodayDay() {
		return new Date();
	}
	
	/**
	 * 返回date用string表示的日期
	 * @param dateString
	 * @param dataFormat
	 * @return
	 */
	public static Date string2Date(String dateString, String dataFormat){
		DateFormat format = new SimpleDateFormat(dataFormat);
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return date;
	}
	

	/**
	 * 返回date用int表示的日期(yyyyMMdd)
	 * @param date
	 * @return
	 */
	public static Integer getDay2Int(Date date) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = 0;
		day += calendar.get(Calendar.YEAR) * 10000;
		day += (calendar.get(Calendar.MONTH) + 1) * 100;
		day += calendar.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	/**
	 * 返回date用int表示的时间(HHmmss)
	 * @param date
	 * @return
	 */
	public static Integer getTime2Int(Date date) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int day = 0;
		day += calendar.get(Calendar.HOUR_OF_DAY) * 10000;
		day += calendar.get(Calendar.MINUTE) * 100;
		day += calendar.get(Calendar.SECOND);
		return day;
	}

	/**
	 * 根据int返回具体的日期
	 * @param date
	 * @return
	 */
	public static Date getDateFromNumber(long date) {
		int _date = (int) date;
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, _date / 10000);
		calendar.set(Calendar.MONTH, _date % 10000 / 100 - 1);
		calendar.set(Calendar.DAY_OF_MONTH, _date % 100);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 设置某天的最开始时间
	 * @param date
	 * @return
	 */
	public static Date getFirestTimeOfDay(Date date) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 设置某天的最晚时间
	 * @param date
	 * @return
	 */
	public static Date getEndTimeOfDay(Date date) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		return calendar.getTime();
	}

	/**
	 * 比较date是否介于from和to之间(包含from和to)
	 * @param date
	 * @param from
	 * @param to
	 * @return
	 */
	public static boolean isBetween(Date date, Date from, Date to) {
		if (date == null || (from == null && to == null))
			return false;

		if (from == null)
			return date.compareTo(to) <= 0;
		if (to == null)
			return date.compareTo(from) >= 0;

		return date.compareTo(from) >= 0 && date.compareTo(to) <= 0;
	}

	public static Date getMonthBegin(Date date) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	public static Date getYearBegin(Date date) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.MONTH, 0);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return calendar.getTime();
	}

	public static Date getWeekBegin(Date date) {
		if (date == null)
			return null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
		return calendar.getTime();
	}

	/** 得到一天是一年中的第几周的方法 */
	public static int getWeekOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		int week = cal.get(Calendar.WEEK_OF_YEAR);
		if (month == 12 && week == 1) {
			year++;
		}
		return year * 100 + week;
	}

	/** 得到一天是一年中的第几个月份的方法 */
	public static int getMonthOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH) + 1;
		return year * 100 + month;
	}
	
	/** 
	 * 	得到当前周的第一天的日期返回int
	 * */
	public static int getBeginDayOfWeek(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		int day = 0;
		day += calendar.get(Calendar.YEAR) * 10000;
		day += (calendar.get(Calendar.MONTH) + 1) * 100;
		day += calendar.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	
	/** 
	 * 	得到当前周的 最后一天的日期返回int
	 * */
	public static int getEndDayOfWeek(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
		int day = 0;
		day += calendar.get(Calendar.YEAR) * 10000;
		day += (calendar.get(Calendar.MONTH) + 1) * 100;
		day += calendar.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	/** 
	 * 	得到当前月的第一天的日期返回int
	 * */
	public static int getBeginDayOfMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_MONTH,1);
		int day = 0;
		day += calendar.get(Calendar.YEAR) * 10000;
		day += (calendar.get(Calendar.MONTH) + 1) * 100;
		day += calendar.get(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	
	/** 
	 * 	得到当前月的 最后一天的日期返回int
	 * */
	public static int getEndDayOfMonth(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.set(Calendar.DAY_OF_MONTH,Calendar.DATE);
		int day = 0;
		day += calendar.get(Calendar.YEAR) * 10000;
		day += (calendar.get(Calendar.MONTH) + 1) * 100;
		day += calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		return day;
	}
	
	
	/**
	 * 当前系统时间
	 * @return
	 */
	public static Date now() {
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		
		return cal.getTime();
	}
	
	/**
	 * 最近几小时
	 * @return
	 */
	public static String getLastHour(int diff) {
		String value = "";
		Date date = new Date();
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MINUTE,-diff);
		cal.set(Calendar.SECOND,0);
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(LONG_PATTERN);
			value =  sdf.format(cal.getTime());
		} catch (Exception e) {
			return null;
		}
		
		return value;
	}
	
	/**
	 * 最近24小时
	 * @return
	 */
	public static String getQpmLast24Hour(int diff) {
		String value = "";
	
		Date date = new Date();
		Calendar cal=Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR,-diff);
		cal.set(Calendar.MINUTE,0);
		cal.set(Calendar.SECOND,0);
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(LONG_PATTERN);
			value =  sdf.format(cal.getTime());
		} catch (Exception e) {
			return null;
		}
		
		return value;
	}
	

	/**
	 * 最近一分钟
	 * @return
	 */
	public static String getLastMin(int diff, int second) {
		String value = "";
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE,-diff);
		cal.set(Calendar.SECOND, second);
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(LONG_PATTERN);
			value =  sdf.format(cal.getTime());
		} catch (Exception e) {
			return null;
		}
		
		return value;
	}
	
	/**
	 * 最近一分钟
	 * @return
	 */
	public static Date getLastMinDate(int diff) {
		String value = "";
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE,-diff);
		//cal.add(Calendar.HOUR_OF_DAY, -cal.get(Calendar.HOUR_OF_DAY));
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(LONG_PATTERN);
			
		} catch (Exception e) {
			return null;
		}
		
		return cal.getTime();
	}
	
	/**
	 * 最近一分钟
	 * @return
	 */
	public static String getLastMinString(int diff) {
		String value = "";
		
		Calendar cal=Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.MINUTE,-diff);
		cal.set(Calendar.SECOND,0);
		//cal.add(Calendar.HOUR_OF_DAY, -cal.get(Calendar.HOUR_OF_DAY));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat(LONG_PATTERN);
	
		
		return sdf.format(cal.getTime());
	}
	
	/**
	 * 根据类型及时间，计算两个时间的间隔
	 * @param beginDate
	 * @param endDate
	 * @param type
	 * @return
	 */
	public static long getDiffOfDays(Date beginDate, Date endDate, String type) {
		long diff = 0;
		Calendar calB=Calendar.getInstance();
		Calendar calE=Calendar.getInstance();
		calB.setTime(beginDate);
		calE.setTime(endDate);
		
		if(type.equals("day")) {
			calB.set(Calendar.HOUR, 0);
			calB.set(Calendar.MINUTE, 0);
			calB.set(Calendar.SECOND, 0);
			
			calE.set(Calendar.HOUR, 0);
			calE.set(Calendar.MINUTE, 0);
			calE.set(Calendar.SECOND, 0);
			
			diff = (calE.getTimeInMillis() - calB.getTimeInMillis())/(1000*60*60*24);
		}
		if(type.equals("hour")) {
			calB.set(Calendar.MINUTE, 0);
			calB.set(Calendar.SECOND, 0);
			
			calE.set(Calendar.MINUTE, 0);
			calE.set(Calendar.SECOND, 0);	
			
			diff = (calE.getTimeInMillis() - calB.getTimeInMillis())/(1000*60*60);
		}
		
		if(type.equals("min")) {
			calB.set(Calendar.SECOND, 0);
			
			calE.set(Calendar.SECOND, 59);
			
			diff = (calE.getTimeInMillis() - calB.getTimeInMillis())/(1000*60);
		}
		
		
		return diff;
	}
	
	/**
	 * 根据类型及时间，计算两个时间的间隔
	 * @param beginDate
	 * @param endDate
	 * @param type
	 * @return
	 */
	public static long getDiffOfTime(Date beginDate, Date endDate, String type) {
		long diff = 0;
		Calendar calB=Calendar.getInstance();
		Calendar calE=Calendar.getInstance();
		calB.setTime(beginDate);
		calE.setTime(endDate);

		if(type.equals("day")) {
			calB.set(Calendar.HOUR, 0);
			calB.set(Calendar.MINUTE, 0);
			calB.set(Calendar.SECOND, 0);
			
			calE.set(Calendar.HOUR, 0);
			calE.set(Calendar.MINUTE, 0);
			calE.set(Calendar.SECOND, 0);
		}
		if(type.equals("hour")) {
			calB.set(Calendar.MINUTE, 0);
			calB.set(Calendar.SECOND, 0);
			
			calE.set(Calendar.MINUTE, 0);
			calE.set(Calendar.SECOND, 0);	
	
		}
		
		if(type.equals("min")) {
			calB.set(Calendar.SECOND, 0);
			
			calE.set(Calendar.SECOND, 59);
			
			
		}
		

		diff = (calE.getTimeInMillis() - calB.getTimeInMillis())/(1000*60);
		
		return diff;
	}
	
	/**
	 * 比较两个时间是否相等
	 * @param beginDate
	 * @param endDate
	 * @param type
	 * @return
	 */
	public static boolean compareDate(Date beginDate, Date endDate) {
		boolean b = false;
		
		long diff = 0;
		Calendar calB=Calendar.getInstance();
		Calendar calE=Calendar.getInstance();
		calB.setTime(beginDate);
		calE.setTime(endDate);

		calB.set(Calendar.SECOND, 0);

		calE.set(Calendar.SECOND, 0);
		
		diff = (calE.getTimeInMillis() - calB.getTimeInMillis());
	
		if(diff ==0)  {
			b = true;
		}

		
		return b;
	}
	
	
	/**
	 * 根据类型及时间，后一个时间
	 * @param beginDate
	 * @param endDate
	 * @param type
	 * @return
	 */
	public static Date getPreDays(Date beginDate, String type, int diff) {
		
		Calendar calB=Calendar.getInstance();
		calB.setTime(beginDate);
		
		if(type.equals("day")) {
			calB.add(Calendar.DAY_OF_YEAR, diff);

		}
		if(type.equals("hour")) {
			calB.add(Calendar.HOUR_OF_DAY, diff);

		}
		
		if(type.equals("min")) {
			calB.add(Calendar.MINUTE, diff);
		}
		
		
		return calB.getTime();
	}
	
	
	//传入int类型时间，返回Date类型
	public static Date getDateFromInt(int date){
		String strDate = String.valueOf(date);
		SimpleDateFormat sdf = new SimpleDateFormat(STR_DATE_PATTERN);
		Date d = null;
		try {
			d = sdf.parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	public static String getMinBetweenDate(String expire){
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat(LONG_PATTERN);
		try {
			Date eDate=dateFormat.parse(expire);
			if (eDate.before(now)) {
				return "已失效"+((now.getTime()-eDate.getTime())/1000/60);
			}
			if (eDate.after(now)) {
				return ((eDate.getTime()-now.getTime())/1000/60)+"";
			}
			if (eDate.equals(now)) {
				return "0";
			}
		} catch (ParseException e) {		
			e.printStackTrace();
		}
		return "0";
	}
	
}
