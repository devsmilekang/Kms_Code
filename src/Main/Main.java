package Main;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import kmsUtill.KmsMethod;

public class Main {
	public static void main(String args[]){
		KmsMethod kms = new KmsMethod();
		//�����޸����
		System.out.print("���� �޸���� : ");
		System.out.println(KmsMethod.commaAdd(2000.2));
		
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
		//���� ��¥ ��������
		//System.out.println(KmsMethod.getToday("yyyy-MM-dd HH:mm:ss"));
		
		/*String a = "\\";
		System.out.println(a.replaceAll("\\\\", "/"));
		
		String b= "11110";
		
		System.out.println(b.split("[.]")[0]);*/
		
		/*String date = "2014-04-24";
		System.out.println(Integer.parseInt(date.substring(0,4))+Integer.parseInt(date.substring(5,7))+date.substring(8,10));
		System.out.println(Integer.parseInt(date.substring(5,7)));
		
		Calendar cal =  Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2014, Integer.parseInt("04")-1,24,0,0,0);
		
		System.out.println(cal2.after(cal));
		System.out.println(Integer.parseInt("04")-1);
		SimpleDateFormat format = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		System.out.println(format.format(cal.getTime()) + " : " + format.format(cal2.getTime()));
		*/
		
		StringBuffer msg = new StringBuffer();
		Calendar current_cal = Calendar.getInstance();
		Calendar gian_cal = Calendar.getInstance();
		String startdate="2014-04-26";
		String category ="201";
		int gian_time =0;

		if("".equals(startdate)){
			msg.append("�ް���û���� ���۳�¥�� �����ϴ�.");
		}
		else if("".equals(category)){
			msg.append("�ް���û���� �ް������� �����ϴ�.");
		}
		/*else if("201".equals(category) || "205".equals(category)){
			gian_time = 9;
		}
		else if("202".equals(category) || "206".equals(category)){
			gian_time = 12;
		}*/

		gian_cal.set(Integer.parseInt(startdate.substring(0,4)),Integer.parseInt(startdate.substring(5,7))-1,Integer.parseInt(startdate.substring(8,10)),gian_time,0,0);

		if(gian_cal.after(current_cal)){
			msg.append("0|ok");
		}
		else{
			msg.append("������ �ް����۳�¥�� ���糯¥���� ���Դϴ�.");
		}
			System.out.println(msg.toString());
		//return msg.toString();

		 
		 
		 
		 Calendar cal = Calendar.getInstance();
		 int date_of_week = cal.get(Calendar.DAY_OF_WEEK); // �Ͽ��� : 1 , ������ :2 ....����� : 7
		 //ȭ������ �ƹ��͵� ���� ���� (�ְ�ȸ�� ��¥�� ȭ������)
		 if(date_of_week != 3){
    		 if(date_of_week>3){  //ȭ������ ������ ��
    			 cal.add(Calendar.DATE, 10-date_of_week); //������ ȭ����
    		 }
    		 else if(date_of_week<3){ //ȭ���� ���� ��
    			 cal.add(Calendar.DATE, 3-date_of_week);;
    		 }
    		 SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    		 String date = format.format(cal.getTime());
    		 String year = date.substring(0,4);
    		 String month = date.substring(4,6);
    		 String day = date.substring(6,8);
    		 
    		// param.setValue("meetingYear",year);
    		// param.setValue("meetingMonth",month);
    		// param.setValue("meetingDay",day);
    		// param.setValue("meetingTitle", year+"�� " + month + "�� " + day + "�� ȸ���ڷ�");
    		 System.out.println(year+":"+month+":"+day+":");
    		// List list = WeekendMettingList(param);
    		// if(list.size() == 0){
    	//		 sqlMap.insert("report.WeekendMeetingInsert", param);	     		
    		 }
	}
}
