package kmsUtill;

//모든 메소드는 여기에 담아 놓을꺼야

public class KmsMethod {
	public KmsMethod() {}
	//숫자 콤마 찍기
	public String commaAdd(Object num){
		String original = String.valueOf(num);
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
}
