package Main;

import java.io.IOException;

import kmsUtill.KmsMethod;
import kmsUtill.KmsProperty;

public class Main {
	public static void main(String args[]){
		KmsMethod kms = new KmsMethod();
	
		//�����޸����
		//System.out.print("���� �޸���� : ");
		System.out.println(KmsMethod.commaAdd(2000000000));
		
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
	}
}
