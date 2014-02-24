package Main;

import kmsUtill.KmsMethod;

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
			String filepath[] = {"test.txt", "test.txt"};
			String to = "kangminser88@naver.com";
			String from = "kangminser@handysoft.co.kr";
			String host = "sniper.handysoft.co.kr";
			KmsMail mail = new KmsMail(to, from, host, "as");
			mail.sendMail("제목", "내용", filepath);
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		
		//Excel Data 추출(엑셀)
		/*try {
			KmsExcel excel = new KmsExcel("","test.xlsx");
			ArrayList<Object[]> list =  excel.sheet_extract(0);
			for(int k=0; k<list.size(); k++){
				Object obj[] = list.get(k);
				for(int m=0; m<obj.length; m++){
					System.out.print(obj[m] + " : ");
				}
				System.out.println();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//원하는 Date Type으로 날짜가져오기 getDate
		//오늘 날짜 가져오기 getToday
		//System.out.println(KmsMethod.getToday("yyyy-MM-dd HH:mm:ss"));
		
	}
}
