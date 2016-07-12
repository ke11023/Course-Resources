package util;

import java.io.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import bean.*;

public class copyHelper {
	private static final int BUFFER_SIZE=16*1024;
	public static void copy(File src,File dst){
		InputStream in=null;
		OutputStream out=null;
		try{
			in=new BufferedInputStream(new FileInputStream(src),BUFFER_SIZE);
			out=new BufferedOutputStream(new FileOutputStream(dst),BUFFER_SIZE);
			byte[] buffer=new byte[BUFFER_SIZE];
			int len=0;
			while((len=in.read(buffer))>0)
				out.write(buffer,0,len);
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static String getPostfix(String path) {
		if (path == null || Common.EMPTY.equals(path.trim())) {
			return Common.EMPTY;
		}
		if (path.contains(Common.POINT)) {
			return path.substring(path.lastIndexOf(Common.POINT) + 1,
					path.length());
		}
		return Common.EMPTY;
	}

	public List readExcel(String path) throws IOException {
		if (path == null || Common.EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = getPostfix(path);
			if (!Common.EMPTY.equals(postfix)) {
				if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls(path);
				} else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx(path);
				}
			} else {
				System.out.println(path + Common.NOT_EXCEL_FILE);
			}
		}
		return null;
	}

	@SuppressWarnings("static-access")
	private String getValue(XSSFCell xssfRow) {
		if (xssfRow.getCellType() == xssfRow.CELL_TYPE_BOOLEAN) {
			return String.valueOf(xssfRow.getBooleanCellValue());
		} else if (xssfRow.getCellType() == xssfRow.CELL_TYPE_NUMERIC) {
			return String.valueOf((int)xssfRow.getNumericCellValue());
		} else {
			return String.valueOf(xssfRow.getStringCellValue());
		}
	}

	@SuppressWarnings("static-access")
	private String getValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
			return String.valueOf((int)hssfCell.getNumericCellValue());
		} else {
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}
	
	//for student
	/**
	 * Read the Excel 2010
	 * 
	 * @param path
	 *            the path of the excel file
	 * @return
	 * @throws IOException
	 */
	public List readXlsx(String path) throws IOException {
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		Student student = null;
		List<Student> list = new ArrayList<Student>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					student = new Student();
					XSSFCell no = xssfRow.getCell(0);
					XSSFCell name = xssfRow.getCell(1);
					XSSFCell age = xssfRow.getCell(2);
					XSSFCell sex = xssfRow.getCell(3);
					student.setSid(Integer.valueOf(getValue(no)));
					student.setSpwd("1234");
					student.setSname(getValue(name));
					student.setSage(getValue(age));
					student.setSsex(getValue(sex));
					student.setStatus(1);
					list.add(student);
				}
			}
		}
		return list;
	}

	/**
	 * Read the Excel 2003-2007
	 * 
	 * @param path
	 *            the path of the Excel
	 * @return
	 * @throws IOException
	 */
	public List readXls(String path) throws IOException {
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		Student student = null;
		List<Student> list = new ArrayList<Student>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					student = new Student();
					HSSFCell no = hssfRow.getCell(0);
					HSSFCell name = hssfRow.getCell(1);
					HSSFCell age = hssfRow.getCell(2);
					HSSFCell sex = hssfRow.getCell(3);
					student.setSid(Integer.valueOf(getValue(no)));
					student.setSpwd("1234");
					student.setSname(getValue(name));
					student.setSage(getValue(age));
					student.setSsex(getValue(sex));
					student.setStatus(1);
					list.add(student);
				}
			}
		}
		return list;
	}



	
	//for teacher
	public List readExcel_Teacher(String path) throws IOException {
		if (path == null || Common.EMPTY.equals(path)) {
			return null;
		} else {
			String postfix = getPostfix(path);
			if (!Common.EMPTY.equals(postfix)) {
				if (Common.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)) {
					return readXls_Teacher(path);
				} else if (Common.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)) {
					return readXlsx_Teacher(path);
				}
			} else {
				System.out.println(path + Common.NOT_EXCEL_FILE);
			}
		}
		return null;
	}
	
	public List readXlsx_Teacher(String path) throws IOException {
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		XSSFWorkbook xssfWorkbook = new XSSFWorkbook(is);
		Teacher tea = null;
		List<Teacher> list = new ArrayList<Teacher>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < xssfWorkbook.getNumberOfSheets(); numSheet++) {
			XSSFSheet xssfSheet = xssfWorkbook.getSheetAt(numSheet);
			if (xssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= xssfSheet.getLastRowNum(); rowNum++) {
				XSSFRow xssfRow = xssfSheet.getRow(rowNum);
				if (xssfRow != null) {
					tea= new Teacher();
					XSSFCell no = xssfRow.getCell(0);
					XSSFCell name = xssfRow.getCell(1);
					XSSFCell age = xssfRow.getCell(2);
					XSSFCell sex = xssfRow.getCell(3);
					XSSFCell phone = xssfRow.getCell(4);
					tea.setTid(Integer.valueOf(getValue(no)));
					tea.setTpwd("1234");
					tea.setTname(getValue(name));
					tea.setTage(getValue(age));
					tea.setTsex(getValue(sex));
					tea.setTphone(getValue(phone));
					list.add(tea);
				}
			}
		}
		return list;
	}

	/**
	 * Read the Excel 2003-2007
	 * 
	 * @param path
	 *            the path of the Excel
	 * @return
	 * @throws IOException
	 */
	public List readXls_Teacher(String path) throws IOException {
		System.out.println(Common.PROCESSING + path);
		InputStream is = new FileInputStream(path);
		HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
		Teacher tea = null;
		List<Teacher> list = new ArrayList<Teacher>();
		// Read the Sheet
		for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
			HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
			if (hssfSheet == null) {
				continue;
			}
			// Read the Row
			for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
				HSSFRow hssfRow = hssfSheet.getRow(rowNum);
				if (hssfRow != null) {
					tea= new Teacher();
					HSSFCell no = hssfRow.getCell(0);
					HSSFCell name = hssfRow.getCell(1);
					HSSFCell age = hssfRow.getCell(2);
					HSSFCell sex = hssfRow.getCell(3);
					HSSFCell phone=hssfRow.getCell(4);
					tea.setTid(Integer.valueOf(getValue(no)));
					tea.setTpwd("1234");
					tea.setTname(getValue(name));
					tea.setTage(getValue(age));
					tea.setTsex(getValue(sex));
					tea.setTphone(getValue(phone));
					list.add(tea);
				}
			}
		}
		return list;
	}
}
