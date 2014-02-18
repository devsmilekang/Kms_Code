package kmsUtill;

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
	public String commaRemove(Object num){
		return String.valueOf(num).replaceAll(",", "");
	}
	
	//Null값을 빈 값으로 돌려주기
	public String isNull(Object obj){
		return isNull(obj, "");
	}
	public String isNull(Object obj, String str){
		if(obj == null || "".equals(String.valueOf(obj).trim()) || "null".equals(String.valueOf(obj).trim())){
			return str;
		}
		else{
			return String.valueOf(obj);
		} 
	}
	
}
