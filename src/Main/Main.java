package Main;

import kmsUtill.KmsMethod;

public class Main {
	public static void main(String args[]){
		KmsMethod kms = new KmsMethod();
	
		//�����޸����
		//System.out.print("���� �޸���� : ");
		//System.out.println(KmsMethod.commaAdd(2000000000));
		
		//�����޸�����
		//System.out.print("���� �޸����� : ");
		//System.out.println(KmsMethod.commaRemove("2,000,000"));
		
		//Null, ���� �� ���ں�ȯ
		//System.out.print("Null, ���� �� ���ں�ȯ ");
		//System.out.println(KmsMethod.isNull("", "null ��"));
		
		//property �о����
		/*System.out.print("property �о���� ");
		try {
			KmsProperty pro = new KmsProperty("path");
			System.out.println(pro.getProperty("property_name"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//Mail ������
		/*try{
			String filepath[] = {"test.txt", "test.txt"};
			String to = "kangminser88@naver.com";
			String from = "kangminser@handysoft.co.kr";
			String host = "sniper.handysoft.co.kr";
			KmsMail mail = new KmsMail(to, from, host, "as");
			mail.sendMail("����", "����", filepath);
		}
		catch(Exception e){
			e.printStackTrace();
		}*/
		
		//Excel Data ����(����)
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
		
		//���ϴ� Date Type���� ��¥�������� getDate
		//���� ��¥ �������� getToday
		//System.out.println(KmsMethod.getToday("yyyy-MM-dd HH:mm:ss"));
		
	}
}
