package kmsUtill;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//��� �޼ҵ�� ���⿡ ��� ��������

public class KmsMethod {
	public KmsMethod() {}
	//���� �޸� ���
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
	
	// ���� �޸� ����
	public static String commaRemove(Object num){
		return String.valueOf(num).replaceAll(",", "");
	}
	
	//Null���� �� ������ �����ֱ�
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
	
	//���ϴ� Date Type���� ��¥��������
	/***********************************************************************************************
	 *  
	 * @param date
	 * @param format
	 * @return String 
	 * 
	 * Fromat Type
	 * 1. ��¥ : yyyy, YYYY -> �⵵, MM -> ��, dd -> day in month, DD -> day in year
	 * 2. �ð� : HH(24�ð� ����), hh(12�ð� ����), mm -> ��, ss -> ��, SS -> Millisecond 
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
	
	//���� ��¥ ��������
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
