package kmsUtill;


import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/********************************************************************************************************************
 * 
 * @author KMS
 * Excel ������ ���� Class
 * lib ������ jar���� �߰��ؾߵ�
 * dom4j-1.6.1.jar,poi-3.9-20121203.jar,poi-ooxml-3.9-20121203.jar,poi-ooxml-schemas-3.9-20121203.jar,xmlbeans-2.3.0.jar
 * ���� jar������ �߰��Ѵ�.
 * �� Excel Data ������ xls, xlsx ��� �����Ѵ�.
 * 
 ********************************************************************************************************************/


public class KmsExcel {
	private Workbook workbook; //.xls,.xlsx
	private HSSFSheet xls_sheet;
	private XSSFSheet xlsx_sheet; 
	public Workbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(Workbook workbook) {
		this.workbook = workbook;
	}

	public HSSFSheet getXls_sheet() {
		return xls_sheet;
	}

	public void setXls_sheet(HSSFSheet xls_sheet) {
		this.xls_sheet = xls_sheet;
	}

	public XSSFSheet getXlsx_sheet() {
		return xlsx_sheet;
	}

	public void setXlsx_sheet(XSSFSheet xlsx_sheet) {
		this.xlsx_sheet = xlsx_sheet;
	}

	public String getExcel_division() {
		return Excel_division;
	}

	public void setExcel_division(String excel_division) {
		Excel_division = excel_division;
	}

	public int getSheetnum() {
		return sheetnum;
	}

	public void setSheetnum(int sheetnum) {
		this.sheetnum = sheetnum;
	}

	public int getTotal_row() {
		return total_row;
	}

	public void setTotal_row(int total_row) {
		this.total_row = total_row;
	}

	private String Excel_division; //.xls,.xlsx ������
	private String path;
	
	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	private String file_name;
	private int sheetnum;
	private int total_row;
	
	public KmsExcel(String path, String file_name) throws Exception {
		try{
			this.path = path;
			this.file_name = file_name;
			
			/* xls, xlsx ���� */
			int pos = file_name.lastIndexOf( "." );
			String ext = file_name.substring( pos + 1 ); //Ȯ����
			//System.out.println("file_name : " + file_name + "   ext : " + ext);
			this.Excel_division = ext;
			if("xls".equals(ext)){
				this.workbook = (Workbook) new HSSFWorkbook(new FileInputStream(new File(this.path + this.file_name)));
			}
			else if("xlsx".equals(ext)){
				this.workbook = (Workbook) new XSSFWorkbook(new FileInputStream(new File(this.path + this.file_name)));
			}
			else{
				this.workbook = null;
			}
			if(workbook != null){
				this.sheetnum = workbook.getNumberOfSheets(); //��Ʈ �� ��������
			}
		}
		catch(Exception e){
			System.out.println("�����ڽ��� Excel_ExtractUtil \n" + e.toString());
			throw e;
		}
	}
	
	public void getExcel_ExtractUtil(String path, String file_name) throws Exception {
		try{
			this.path = path;
			this.file_name = file_name;
			
			/* xls, xlsx ���� */
			int pos = file_name.lastIndexOf( "." );
			String ext = file_name.substring( pos + 1 ); //Ȯ����
			//System.out.println("file_name : " + file_name + "   ext : " + ext);
			this.Excel_division = ext;
			if("xls".equals(ext)){
				this.workbook = (Workbook) new HSSFWorkbook(new FileInputStream(new File(this.path + this.file_name)));
			}
			else if("xlsx".equals(ext)){
				this.workbook = (Workbook) new XSSFWorkbook(new FileInputStream(new File(this.path + this.file_name)));
			}
			else{
				this.workbook = null;
			}
			if(workbook != null){
				this.sheetnum = workbook.getNumberOfSheets(); //��Ʈ �� ��������
			}
		}
		catch(Exception e){
			System.out.println("�����ڽ��� Excel_ExtractUtil \n" + e.toString());
			throw e;
		}
	}
	
	public ArrayList<ArrayList<Object[]>> excel_all_extract(){
		try{
			ArrayList<ArrayList<Object[]>> sheet_list = new ArrayList<ArrayList<Object[]>>();
			if(this.workbook == null){
				return null;
			}
			//sheet�� ��ŭ �ݺ�
			for(int k=0; k<this.sheetnum; k++){
				sheet_list.add(sheet_extract(k));
			}
			return sheet_list;
		}
		catch(Exception e){
			System.out.println("Excel_ExtractUtil.class excel_all_extract() error ");
			System.out.println(e.toString());
			return null;
		}
	}
	
	public ArrayList<Object[]> sheet_extract(int sheet_number){
		try{
			if(sheet_number <= this.sheetnum || sheet_number >=0){
				ArrayList<Object[]> list = new ArrayList<Object[]>();
				if(this.workbook == null){
					return null;
				}
				//sheet�� ��ŭ �ݺ�
				if("xls".equals(this.Excel_division)){
					this.xls_sheet = (HSSFSheet)this.workbook.getSheetAt(sheet_number); // Excel sheet�� ������.
					this.total_row = xls_sheet.getPhysicalNumberOfRows(); // Excel sheet�� row�� ������.
					//System.out.println("total: " +this.total_row);
					for(int s=0; s<=this.total_row; s++){
						HSSFRow row = xls_sheet.getRow(s);	//row�� 0���� ����
						if(row != null){
							list.add(row_extract(row));
						}
					}
				}
				else if("xlsx".equals(this.Excel_division)){
					this.xlsx_sheet = (XSSFSheet)workbook.getSheetAt(sheet_number); // Excel sheet�� ������.
					this.total_row = xlsx_sheet.getPhysicalNumberOfRows(); // Excel sheet�� row�� ������.
					//System.out.println("total: " +this.total_row);
					for(int s=0; s<=this.total_row; s++){
						XSSFRow row = xlsx_sheet.getRow(s);
						if(row != null){
							list.add(row_extract(row));
						}
					}					
				}
				else{
					return null;
				}
				return list;
			}
			else{
				return null;
			}
		}
		catch(Exception e){
			System.out.println("excel_all_extract error");
			System.out.println(e.toString());
			return null;
		}
	}
	
	public ArrayList<Object[]> sheet_extract(int sheet_number, int row_number){
		try{
			if(sheet_number <= this.sheetnum && sheet_number >= 0){
				ArrayList<Object[]> list = new ArrayList<Object[]>();
				if(this.workbook == null){
					System.out.println("workbook null");
					return null;
				}
				//sheet�� ��ŭ �ݺ�
				if("xls".equals(this.Excel_division)){
					this.xls_sheet = (HSSFSheet)workbook.getSheetAt(sheet_number); // Excel sheet�� ������.
					this.total_row = xls_sheet.getPhysicalNumberOfRows(); // Excel sheet�� row�� ������.
					for(int s=row_number; s<=this.total_row; s++){
						HSSFRow row = xls_sheet.getRow(s);	//row�� 0���� ����
						if(row != null){
							list.add(row_extract(row));
						}
					}
				}
				else if("xlsx".equals(this.Excel_division)){
					this.xlsx_sheet = (XSSFSheet)workbook.getSheetAt(sheet_number); // Excel sheet�� ������.
					this.total_row = xlsx_sheet.getPhysicalNumberOfRows(); // Excel sheet�� row�� ������.
					for(int s=row_number; s<=this.total_row; s++){
						XSSFRow row = xlsx_sheet.getRow(s);
						if(row != null){
							list.add(row_extract(row));
						}
					}					
				}
				else{
					return null;
				}
				return list;
			}
			else{
				return null;
			}
		}
		catch(Exception e){
			System.out.println("excel_all_extract error");
			System.out.println(e.toString());
			return null;
		}
	}
	
	public Object[] row_extract(HSSFRow row){
		try{
			int cells = row.getLastCellNum();
			Object object[] = new Object[cells];
			for(short k=0; k<cells; k++){
				HSSFCell cell = row.getCell(k);
				object[k] = cell_extract(cell);
				
			}
			return object;
		}
		catch(Exception e){
			return null;
		}
	}
	public Object[] row_extract(XSSFRow row){
		try{
			int cells = row.getLastCellNum();
			Object object[] = new Object[cells];
			for(int k=0; k<cells; k++){
				XSSFCell cell = row.getCell(k);
				object[k] = cell_extract(cell);
			}
			return object;
		}
		catch(Exception e){
			return null;
		}
	}
	
	
	public Object cell_extract(HSSFCell cell){
		if(cell != null){
			//getCellType : 0 -> ���� 1-> ����
			if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
				return cell.getNumericCellValue();
				//System.out.print("���� : " + (int)cell.getNumericCellValue());
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_STRING){
				return cell.getStringCellValue();
				//System.out.print("���� : " + cell.getStringCellValue());
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
				return cell.getBooleanCellValue();
				//System.out.print("���� : " + cell.getStringCellValue());
			}
			else{
				return "";
			}
		}
		else{
			return "";
		}
	}
	
	public Object cell_extract(XSSFCell cell){
		if(cell != null){
			//getCellType : 0 -> ���� 1-> ����
			if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC){
				return cell.getNumericCellValue();
				//System.out.print("���� : " + (int)cell.getNumericCellValue());
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_STRING){
				return cell.getStringCellValue();
				//System.out.print("���� : " + cell.getStringCellValue());
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_BOOLEAN){
				return cell.getBooleanCellValue();
				//System.out.print("���� : " + cell.getStringCellValue());
			}
			else if(cell.getCellType() == Cell.CELL_TYPE_BLANK){
				return "";
			}
			else{
				return "";
			}
		}
		else{
			return "";
		}
	}
}
