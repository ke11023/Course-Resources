package Action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import dao.editDao;
import bean.*;

public class editAction extends ActionSupport implements SessionAware {
	private editDao editdao;
	private String id, name, pwd, sex, age, phone, tid, brief, cdepaetment;
	private Map session;

	public void setSession(Map session) {
		this.session = session;
	}

	public void setEditdao(editDao editdao) {
		this.editdao = editdao;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTid() {
		return tid;
	}

	public void setTid(String tid) {
		this.tid = tid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public String getCdepaetment() {
		return cdepaetment;
	}

	public void setCdepaetment(String cdepaetment) {
		this.cdepaetment = cdepaetment;
	}

	public String managerGoto() {
		try {
			String hql = "from Manager u where u.mid='" + this.getId() + "'";
			List<Manager> list = editdao.Query(hql);
			// if (list!=null)
			Manager mana = list.get(0);
			session.put("id", mana.getMid());
			session.put("pwd", mana.getMpwd());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public String teacherGoto() {
		try {
			String hql = "from Teacher u where u.tid='" + this.getId() + "'";
			List<Teacher> list = editdao.Query(hql);
			Teacher tea = list.get(0);
			session.put("id", tea.getTid());
			session.put("pwd", tea.getTpwd());
			session.put("name", tea.getTname());
			session.put("sex", tea.getTsex());
			session.put("age", tea.getTage());
			session.put("phone", tea.getTphone());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public String studentGoto() {
		try {
			String hql = "from Student u where u.sid='" + this.getId() + "'";
			List<Student> list = editdao.Query(hql);
			Student stu = list.get(0);
			session.put("id", stu.getSid());
			session.put("student_pwd", stu.getSpwd());
			session.put("student_name", stu.getSname());
			session.put("student_sex", stu.getSsex());
			session.put("student_age", stu.getSage());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public String courseGoto() {
		try {
			String hql = "from Course u where u.cid='" + this.getId() + "'";
			List<Course> list = editdao.Query(hql);
			Course cou = list.get(0);
			session.put("id", cou.getCid());
			session.put("course_name", cou.getCname());
			session.put("brief", cou.getCbrief());
			session.put("tid", cou.getTeacher().getTid());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public void deleteDemo(Course cou) {
		try {
			String hql = "from Schedule u where u.course.cid='" + cou.getCid() + "'";
			List<Schedule> sch = editdao.Query(hql);
			for(int i=0;i<sch.size();i++){
				editdao.deleteSchedule(sch.get(i));
			}
			hql = "from Message u where u.course.cid='" + cou.getCid() + "'";
			List<Message> mes = editdao.Query(hql);
			for(int i=0;i<mes.size();i++){
				editdao.deleteMessage(mes.get(i));
			}
			hql = "from Resource u where u.course.cid='" + cou.getCid() + "'";
			List<Resource> res = editdao.Query(hql);
			for(int i=0;i<res.size();i++){
				editdao.deleteResource(res.get(i));
			}
			editdao.deleteCourse(cou);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public String deleteCourse(){
		try {
			String hql = "from Course u where u.cid='" + this.getId() + "'";
			List<Course> cou = editdao.Query(hql);
			for(int i=0;i<cou.size();i++){
				this.deleteDemo(cou.get(i));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String deleteTeacher(){
		try {
			int tid=Integer.valueOf(this.getId());
			String hql = "from Course u where u.teacher.tid='" + tid+ "'";
			List<Course> cou = editdao.Query(hql);
			for(int i=0;i<cou.size();i++){
				this.deleteDemo(cou.get(i));
			}
			editdao.deleteTeacher(tid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String deleteStudent(){
		try {
			int sid=Integer.valueOf(this.getId());
			String hql = "from Schedule u where u.student.sid='" + sid+ "'";
			List<Schedule> sch = editdao.Query(hql);
			for(int i=0;i<sch.size();i++){
				editdao.deleteSchedule(sch.get(i));
			}
			hql = "from Message u where u.student.sid='" + this.getId() + "'";
			List<Message> mes = editdao.Query(hql);
			for(int i=0;i<mes.size();i++){
				editdao.deleteMessage(mes.get(i));
			}
			editdao.deleteStudent(sid);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public String examin() {
		String flag = INPUT;
		try {
			String hql = "from Student u where u.sid='" + this.getId() + "'";
			List<Student> list = editdao.Query(hql);
			Student stu = list.get(0);
			stu.setStatus(1);
			editdao.editStudent(stu);
			hql = "from Student u where u.status=0";
			List message = editdao.Query(hql);
			if (message != null) {
				session.put("message", message);
				session.put("message_count", message.size());
			} else {
				session.put("message", null);
				session.put("message_count", null);
			}
			flag = SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public String managerEdit() {
		String flag = INPUT;
		try {
			Manager mana = new Manager();
			mana.setMid(this.getId());
			mana.setMpwd(this.getPwd());
			editdao.editManager(mana);
			flag = SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public String teacherEdit() {
		String flag = SUCCESS;
		try {
			Teacher tea = new Teacher();
			tea.setTid(Integer.valueOf(this.getId()));
			tea.setTname(this.getName());
			tea.setTpwd(this.getPwd());
			tea.setTsex(this.getSex());
			tea.setTage(this.getAge());
			tea.setTphone(this.getPhone());
			editdao.editTeacher(tea);
			flag = SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public String courseEdit() {
		String flag = SUCCESS;
		try {
			Course cou = new Course();
			cou.setCid(this.getId());
			cou.setCname(this.getName());
			cou.setCbrief(this.getBrief());
			cou.setCdepaetment(this.getCdepaetment());
			Teacher tea = (Teacher) editdao.Query(
					"from Teacher u where u.tid='" + this.getTid() + "'")
					.get(0);
			cou.setTeacher(tea);
			editdao.editCourse(cou);
			flag = SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Override
	public String execute() {
		String flag = SUCCESS;
		try {
			Student stu = new Student();
			stu.setSid(Integer.valueOf(this.getId()));
			stu.setSname(this.getName());
			stu.setSpwd(this.getPwd());
			stu.setSsex(this.getSex());
			stu.setSage(this.getAge());
			stu.setStatus(1);
			editdao.editStudent(stu);
			flag = SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}
}
