package cn.util;

import java.util.Date;


//DataUtil类主要用于生成年、月、日、时、分、秒的信息，用于生成保存截图文件目录名和文件名
public class DataUtil{
	//格式化输入日期，@return 返回字符型日期
	public static String format(java.util.Date date,String format){
		String result="";
		try{
			if(date != null){
				java.text.DateFormat df=new java.text.SimpleDateFormat(format);
				result=df.format(date);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	//返回年份   @return返回年份
	public static int getYear(java.util.Date date){
		java.util.Calendar c=java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.YEAR);
	}
	
	//返回月份 @return返回月份
	public static int getMonth(java.util.Date date){
		java.util.Calendar c= java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MONTH)+1;
	}
	
	//返回在月份中的第几天  @return返回月份中的第几天
	public static int getDay(java.util.Date date){
		java.util.Calendar c= java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.DAY_OF_MONTH);
	}
	
	/*
	 * 返回小时
	 * @param date
	 * 日期
	 * @return返回小时
	 */
	public static int getHour(java.util.Date date){
		java.util.Calendar c=java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.HOUR_OF_DAY);
	}
	
	/*
	 * 返回分钟
	 * @param date
	 * 日期
	 * @return返回分钟
	 */
	public static int getMinute(java.util.Date date){
		java.util.Calendar c=java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.MINUTE);
	}
	
	/*
	 * 返回秒
	 * @param date
	 * 日期
	 * @return返回秒
	 */
	public static int getSecond(java.util.Date date){
		java.util.Calendar c=java.util.Calendar.getInstance();
		c.setTime(date);
		return c.get(java.util.Calendar.SECOND);
	}
}
