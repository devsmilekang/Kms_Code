package Main;

import java.io.IOException;

import kmsUtill.KmsMail;
import kmsUtill.KmsMethod;
import kmsUtill.KmsProperty;

public class Main {
	public static void main(String args[]){
		KmsMethod kms = new KmsMethod();
	
		//숫자콤마찍기
		//System.out.print("숫자 콤마찍기 : ");
		//System.out.println(KmsMethod.commaAdd(2000000000));
		
		//숫자콤마제거
		//System.out.print("숫자 콤마제거 : ");
		//System.out.println(KmsMethod.commaRemove("2,000,000"));
		
		//Null, 빈값일 때 문자변환
		//System.out.print("Null, 빈값일 때 문자변환 ");
		//System.out.println(KmsMethod.isNull("", "null 값"));
		
		//property 읽어오기
		/*System.out.print("property 읽어오기 ");
		try {
			KmsProperty pro = new KmsProperty("path");
			System.out.println(pro.getProperty("property_name"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Mail 보내기
		/*try{
			String to = "kangminser88@naver.com";
			String from = "kangminser@handysoft.co.kr";
			String host = "sniper.handysoft.co.kr";
			KmsMail mail = new KmsMail(to, from, host, "as");
			mail.sendMail("제목", "내용", "");
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
	}
}
