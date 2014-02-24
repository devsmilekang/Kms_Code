package kmsUtill;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//모든 메소드는 여기에 담아 놓을꺼야

public class KmsMethod {
	public KmsMethod() {}
	//숫자 콤마 찍기
	public static String commaAdd(Object num){
		String original = String.valueOf(num).trim();
		String convert = "";
		int count = 1;
		for(int k=original.length()-1; k>-1; k--){			
			if( (count%3) == 0 && k < original.length()-1 && k > 0){
				convert = "," +original.charAt(k)  + convert;
			}
			else{
				convert = original.charAt(k) + convert;
			}
			count++;
		}
		return convert;
	}
	
	// 숫자 콤마 제거
	public static String commaRemove(Object num){
		return String.valueOf(num).replaceAll(",", "");
	}
	
	//Null값을 빈 값으로 돌려주기
	public static String isNull(Object obj){
		return isNull(obj, "");
	}
	public static String isNull(Object obj, String str){
		if(obj == null || "".equals(String.valueOf(obj).trim()) || "null".equals(String.valueOf(obj).trim())){
			return str;
		}
		else{
			return String.valueOf(obj);
		}
	}
	
	//원하는 Date Type으로 날짜가져오기
	/***********************************************************************************************
	 *  
	 * @param date
	 * @param format
	 * @return String 
	 * 
	 * Fromat Type
	 * 1. 날짜 : yyyy, YYYY -> 년도, MM -> 월, dd -> day in month, DD -> day in year
	 * 2. 시간 : HH(24시간 기준), hh(12시간 기준), mm -> 분, ss -> 초, SS -> Millisecond 
	 * 
	 **********************************************************************************************/
	public static String getData(Date date, String format){
		try{
			SimpleDateFormat date_format = new SimpleDateFormat(format);
			return date_format.format(date);
		}
		catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
	
	//오늘 날짜 가져오기
	public static String getToday(String format){
		try{
			SimpleDateFormat date_format = new SimpleDateFormat(format);
			return date_format.format(Calendar.getInstance().getTime());
		}
		catch(Exception e){
			e.printStackTrace();
			return "";
		}
	}
}
