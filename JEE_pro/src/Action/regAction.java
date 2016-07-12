package Action;

import java.io.PrintWriter;
import dao.*;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import bean.Student;
import com.opensymphony.xwork2.ActionSupport;

public class regAction extends ActionSupport {
	private String name, pwd;
	private userDao userdao;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setUserdao(userDao userdao) {
		this.userdao = userdao;
	}

	public String checkRegsiter() throws Exception {
		HttpServletResponse response = ServletActionContext.getResponse();
		JSONObject json = new JSONObject();
		PrintWriter out = response.getWriter();	
		if (this.userdao.checkRegister(this.getName()) == false) {
			json.put("exist", "false");
			out.println(json);
			out.flush();
			out.close();
			return "userAllowRegister";
		}
		json.put("exist", "true");
		out.println(json);
		out.flush();
		out.close();
		return "userNoRegister";
	}
	
	@Override
	public String execute() throws Exception {
		try {
			Student stu = new Student();
			stu.setSid(Integer.valueOf(this.getName()));			
			stu.setSpwd(this.getPwd().replace(" ", ""));
			stu.setStatus(0);
			userdao.addStudent(stu);
		} catch (Exception ex) {
			ex.printStackTrace();
			return INPUT;
		}
		return SUCCESS;
	}

}
