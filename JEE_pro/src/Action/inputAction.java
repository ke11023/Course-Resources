package Action;

import com.opensymphony.xwork2.ActionSupport;

import java.io.*;
import java.util.*;

import util.*;
import bean.*;
import dao.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.struts2.ServletActionContext;

public class inputAction extends ActionSupport {
	private static final int BUFFER_SIZE=16*1024;
	private inputDao inputdao;
	private File upload;
	private String savepath,uploadFileName,uploadContentType;

	public void setInputdao(inputDao inputdao) {
		this.inputdao = inputdao;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getSavepath() {
		return savepath;
	}

	public void setSavepath(String savepath) {
		this.savepath = savepath;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public String teacherInput()  {
		String flag=INPUT;
		try {
			String dstpath=ServletActionContext.getServletContext().getRealPath(this.getSavepath())+"/"+this.getUploadFileName();
			File dstfile=new File(dstpath);
			copyHelper helper=new copyHelper();
			copyHelper.copy(this.upload,dstfile);
			List<Teacher> list = helper.readExcel_Teacher(dstpath);
			inputdao.TeacherInput(list);
			flag=SUCCESS; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public String execute() {
		String flag=INPUT;
		try {
			String dstpath=ServletActionContext.getServletContext().getRealPath(this.getSavepath())+"/"+this.getUploadFileName();
			File dstfile=new File(dstpath);
			//System.out.println(dstfile);
			//System.out.println("¿‡–Õ"+this.getUploadContentType());
			copyHelper helper=new copyHelper();
			copyHelper.copy(this.upload,dstfile);
			List<Student> list=helper.readExcel(dstpath);
			inputdao.StudentInput(list);
			flag=SUCCESS; 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
