package kmsUtill;

//��� �޼ҵ�� ���⿡ ��� ��������

public class KmsMethod {
	public KmsMethod() {}
	//���� �޸� ���
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
	
	// ���� �޸� ����
	public String commaRemove(Object num){
		return String.valueOf(num).replaceAll(",", "");
	}
}
