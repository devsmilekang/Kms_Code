package kmsUtill;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//모든 메소드는 여기에 담아 놓을꺼야

public class KmsMethod {
	public KmsMethod() {}
	//숫자 콤마 찍기 및 숫자체크
	//update 2014-05-12 (소숫점 숫자일 때 처리)
	public static String commaAdd(Object num){
		String original = String.valueOf(num).trim();
		//String original = String.valueOf(20000.12).trim();
		System.out.println(original);
		try{			
			String original_decimal[] = original.split("[.]");
			System.out.println("original_decimal.length : " +original.split(".").length);
			if(original_decimal.length > 2 ){
				System.out.println(".이 2개 이상 들어있습니다.");
				return original;
			}
			String convert = "";
			int count = 1;
			for(int k=original_decimal[0].length()-1; k>-1; k--){			
				//숫자인지 체크
				System.out.println("char : " + (int)original_decimal[0].charAt(k));
				if(original_decimal[0].charAt(k) >= 48 && original_decimal[0].charAt(k) <= 57){
					if( (count%3) == 0 && k < original_decimal[0].length()-1 && k > 0){
						convert = "," +original_decimal[0].charAt(k)  + convert;
					}
					else{
						convert = original_decimal[0].charAt(k) + convert;
					}
				}
				else{
					System.out.println("commaAdd 에러 -> 숫자가 아닌 값이 들어있습니다.");
					return original;
				}
				count++;
			}
			if(original_decimal.length == 2){
				return convert+"."+original_decimal[1];
			}
			else{
				return convert;
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("숫자 ,처리 에러");
			return original;
		}
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
