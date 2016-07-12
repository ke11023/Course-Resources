package Action;

import java.util.*;
import org.apache.struts2.interceptor.SessionAware;
import com.opensymphony.xwork2.ActionSupport;
import bean.*;
import dao.*;

public class loginAction extends ActionSupport implements SessionAware {
	private String login_name, login_pwd;
	private userDao userdao;
	private Map session;

	public void setSession(Map session) {
		this.session = session;
	}

	public void setUserdao(userDao userdao) {
		this.userdao = userdao;
	}

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}

	public String getLogin_pwd() {
		return login_pwd;
	}

	public void setLogin_pwd(String login_pwd) {
		this.login_pwd = login_pwd;
	}

	public String Login() {
		String flag = INPUT;
		try {
			Manager mana = new Manager();
			mana.setMid(this.getLogin_name());
			mana.setMpwd(this.getLogin_pwd());
			if (userdao.ManagerLogin(mana))
				flag = ManagerLogin();
			else {
				Teacher tea = new Teacher();
				tea.setTid(Integer.valueOf(this.getLogin_name()));
				tea.setTpwd(this.getLogin_pwd());
				flag = TeacherLogin(tea);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// System.out.println(flag);
		return flag;
	}

	public String ManagerLogin() {
		String flag = INPUT;
		try {
			/*
			 * Manager mana = new Manager(); mana.setMid(this.getLogin_name());
			 * mana.setMpwd(this.getLogin_pwd()); if
			 * (userdao.ManagerLogin(mana)) {
			 */
			String hql = "from Student u where u.status=0";
			List list = userdao.queryMessage(hql);
			if (list != null) {
				session.put("message", list);
				session.put("message_count", list.size());
			} else {
				session.put("message", null);
				session.put("message_count", null);
			}
			session.put("admin", this.getLogin_name());
			flag = SUCCESS;
			// }
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public String TeacherLogin(Teacher tea) {
		String flag = INPUT;
		try {
			/*
			 * Teacher tea = new Teacher();
			 * tea.setTid(Integer.valueOf(this.getLogin_name()));
			 * tea.setTpwd(this.getLogin_pwd());
			 */
			String name = userdao.TeacherrLogin(tea);
			if (name != null) {
				session.put("username", name);
				session.put("teacher_id", this.getLogin_name());
				flag = "teacher";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public String execute() {
		String flag = INPUT;
		int sid = Integer.valueOf(this.getLogin_name());
		try {
			Student stu = userdao.QueryStudentByID(sid);
			if (stu.getSpwd().replaceAll(" ", "").equals(this.getLogin_pwd())
					&& stu.getStatus() == 1) {
				/*
				 * String hql="from Message u where u.student.sid='"+sid+
				 * "' and u.messtatus=0"; List<Message>
				 * homework=userdao.queryMessage(hql); session.put("homework",
				 * homework); session.put("message_count", homework.size());
				 * 
				 * hql="from Message u where u.student.sid='"+sid+
				 * "' and u.messtatus=1"; List<Message>
				 * history=userdao.queryMessage(hql); session.put("history",
				 * history);
				 */

				session.put("studentname", stu.getSname());
				session.put("student_id", this.getLogin_name());
				flag = SUCCESS;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
		// return SUCCESS;
	}

	
	public String singout(){
		session.remove("admin");
		session.remove("teacher-id");
		session.remove("student_id");
		return SUCCESS;
	}
}
