package kmsUtill;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class KmsProperty {
	private Properties pro;
	private FileInputStream fis;
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public KmsProperty(String path){
		try{
			this.path = path;
			this.fis = new FileInputStream(this.path);
			this.pro.load(fis);
		}
		catch(IOException e){
			e.printStackTrace();
			System.out.println("property �б� ����");
		}
		finally{
			if(fis != null){
				try{
					fis.close();
				}catch (IOException ioe){
					ioe.printStackTrace();
					System.out.println("property �б� ����");
				}
			}
		}
	}
	
	public String getProperty(String property_name) throws IOException {
		if(pro != null){
			return pro.getProperty(property_name, "");
		}
		else{
			return "";
		}
	}
}
