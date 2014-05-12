package kmsUtill;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//��� �޼ҵ�� ���⿡ ��� ��������

public class KmsMethod {
	public KmsMethod() {}
	//���� �޸� ��� �� ����üũ
	//update 2014-05-12 (�Ҽ��� ������ �� ó��)
	public static String commaAdd(Object num){
		String original = String.valueOf(num).trim();
		//String original = String.valueOf(20000.12).trim();
		System.out.println(original);
		try{			
			String original_decimal[] = original.split("[.]");
			System.out.println("original_decimal.length : " +original.split(".").length);
			if(original_decimal.length > 2 ){
				System.out.println(".�� 2�� �̻� ����ֽ��ϴ�.");
				return original;
			}
			String convert = "";
			int count = 1;
			for(int k=original_decimal[0].length()-1; k>-1; k--){			
				//�������� üũ
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
					System.out.println("commaAdd ���� -> ���ڰ� �ƴ� ���� ����ֽ��ϴ�.");
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
			System.out.println("���� ,ó�� ����");
			return original;
		}
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
