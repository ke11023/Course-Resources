package Action;

import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;  

import bean.*;
import dao.*;

public class infoQueryAction extends ActionSupport implements SessionAware {
	private infoDao infodao;
	private Map session;
	private String sid;
	
	public String getSid(){
		return this.sid;
	}
	
	public void setSession(Map session) {
		this.session = session;
	}
	
	public void setInfodao(infoDao infodao) {
		this.infodao = infodao;
	}
	
	public String managerQuery(){
		String flag = INPUT;
		try {
			String hql="from Manager";
			List<Manager> list=infodao.Query(hql);
			if (list!=null) {
				session.put("manager",list);
				flag = SUCCESS;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	public String teacherQuery(){
		String flag = INPUT;
		try {
			String hql="from Teacher";
			List<Teacher> list=infodao.Query(hql);
			if (list!=null) {
				session.put("teacher",list);
				flag = SUCCESS;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	public String examineStudent(){
		String flag = INPUT;
		try {
			String hql="from Student u where u.status=0";
			List<Student> list=infodao.Query(hql);
			if (list!=null) {
				session.put("examin",list);
				flag = SUCCESS;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public String execute() {
		String flag = INPUT;
		try {
			String hql="from Student u where u.status=1";
			List<Student> list=infodao.Query(hql);
			if (list!=null) {
				session.put("student",list);
				flag = SUCCESS;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}


}
