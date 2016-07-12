package Action;

import java.util.*;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;  

import bean.*;
import dao.*;

public class courseAction extends ActionSupport implements SessionAware{
	private infoDao infodao;
	private Map session;
	private String cid,cname,tid,cbrief,cdepaetment;
	
	public String getCbrief() {
		return cbrief;
	}

	public void setCbrief(String cbrief) {
		this.cbrief = cbrief;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getCdepaetment() {
		return cdepaetment;
	}

	public void setCdepaetment(String cdepaetment) {
		this.cdepaetment = cdepaetment;
	}

	public void setInfodao(infoDao infodao) {
		this.infodao = infodao;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public String courseQuery(){
		String flag = INPUT;
		try {
			String hql="from Course";
			List<Class> list=infodao.Query(hql);
			if (list!=null) {
				session.put("info",list);
				flag = SUCCESS;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
	
	@Override
	public String execute() {
		try {
			Course cou=new Course();
			cou.setCid(this.getCid());
			cou.setCname(this.getCname());
			cou.setCbrief(this.getCbrief());
			cou.setCdepaetment(this.getCdepaetment());
			String hql="from Teacher u where u.tid='"+this.getTid()+"'";
			Teacher tea=(Teacher)infodao.Query(hql).get(0);
			cou.setTeacher(tea);
			infodao.addcourse(cou);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}
}
