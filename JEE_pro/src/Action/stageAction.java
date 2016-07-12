package Action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import bean.*;
import dao.*;

public class stageAction extends ActionSupport implements SessionAware {
	private stageDao stagedao;
	private Map session;
	private String id, route, mesid, Login_name, Login_pwd,name,pwd,sex,age,downFileName;
	private InputStream downloadFile;

	public void setStagedao(stageDao stagedao) {
		this.stagedao = stagedao;
	}

	public void setSession(Map session) {
		this.session = session;
	}

	public void setLogin_name(String login_name) {
		Login_name = login_name;
	}

	public void setLogin_pwd(String login_pwd) {
		Login_pwd = login_pwd;
	}

	public void setDownloadFile(InputStream downloadFile) {
		this.downloadFile = downloadFile;
	}

	public String getDownFileName() {
		return downFileName;
	}

	public void setDownFileName(String downFileName) {
		this.downFileName = downFileName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getMesid() {
		return mesid;
	}

	public void setMesid(String mesid) {
		this.mesid = mesid;
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

	public String QueryCourseforStage(){
		String hql="from Course u where u.cdepaetment='计算机学院'";
		List<Course> computer=stagedao.QueryCourse(hql);
		hql="from Course u where u.cdepaetment='经管学院'";
		List<Course> economy=stagedao.QueryCourse(hql);
		hql="from Course u where u.cdepaetment='电气学院'";
		List<Course> electric=stagedao.QueryCourse(hql);
		hql="from Course u where u.cdepaetment='数理学院'";
		List<Course> math=stagedao.QueryCourse(hql);
	/*	for(int i=0;i<list.size();i++){
			String dep=list.get(i).getCdepaetment();
			System.out.println(dep);
			if(dep.equals("计算机学院"))
				computer.add(list.get(i));
			else if(dep.equals("经管学院"))
				economy.add(list.get(i));
			else if(dep.equals("电气学院"))
				electric.add(list.get(i));
			else if(dep.equals("数理学院"))
				math.add(list.get(i));
		}*/
		session.put("computer", computer);
		session.put("economy", economy);
		session.put("electric", electric);
		session.put("math", math);
		return SUCCESS;
	}

	public String QueryRoute(String cid, String type) {
		String suffix = null;
		String hql = "from Resource u where u.course.cid='" + cid
				+ "' and u.rtype='" + type + "'";
		List<Resource> list = stagedao.QueryResource(hql);
		if (list.size()!=0) {
			Resource res = list.get(0);
			int splitIndex = res.getRroute().lastIndexOf("/");
			suffix = res.getRroute().substring(splitIndex + 1);
		}
		return suffix;
	}

	private List<Resource> QueryResource(String cid, String type) {
		String hql = "from Resource u where u.course.cid='" + cid
				+ "' and u.rtype='" + type + "'";
		// System.out.println(stagedao.QueryResource(hql));
		return stagedao.QueryResource(hql);
	}

	public String resourceDetail() {
		String flag = INPUT;
		try {
			String path = this.getRoute();
			// System.out.println(this.getRoute());
			int splitIndex = path.lastIndexOf("/");
			String suffix = path.substring(splitIndex + 1);
			session.put("pdfroute", "upload/" + suffix);
			flag = SUCCESS;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public String homeworkQuery() {
		int sid = Integer.valueOf((String) session.get("student_id"));
		try {
			Student stu=stagedao.QueryStudentByID(sid);
			session.put("studentInfo", stu);
			String hql = "from Message u where u.student.sid='" + sid
					+ "' and u.messtatus=0";
			List<Message> homework = stagedao.QueryMessage(hql);
			//System.out.println(homework.get(0).getCourse());
			if (homework != null) {
				//System.out.println(session);
				session.put("homework", homework);
				session.put("message_count", homework.size());
				
			}

			hql = "from Message u where u.student.sid='" + sid
					+ "' and u.messtatus=1";
			List<Message> history = stagedao.QueryMessage(hql);
			if (history != null)
				session.put("history", history);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public String StudentInfoEdit(){
		try {
			Student stu = new Student();
			stu.setSid(Integer.valueOf(this.getId()));
			stu.setSname(this.getName());
			stu.setSpwd(this.getPwd());
			stu.setSsex(this.getSex());
			stu.setSage(this.getAge());
			stu.setStatus(1);
			stagedao.editStudent(stu);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String homeworkDetail() {
		try {
			String path = this.getRoute();
			int id = Integer.valueOf((String) session.get("student_id"));
			Message mes = stagedao.QueryMessageByID(Integer.valueOf(this.getMesid()));
			if (mes != null) {
				mes.setMesstatus(1);
				stagedao.editMessage(mes);
			}
			path = path.replace(" ", "");
			// System.out.println(this.getRoute());
			int splitIndex = path.lastIndexOf("/");
			String suffix = path.substring(splitIndex + 1);
			System.out.println(suffix);
			session.put("pdfroute", "upload/" + suffix);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}

	public String download() {		
		return SUCCESS;
	}

	//返回一个输入流，作为一个客户端来说是一个输入流，但对于服务器端是一个 输出流
    public InputStream getDownloadFile() throws Exception {
        downFileName=(route.substring(route.lastIndexOf("/")+1));
        this.downFileName = new String(this.downFileName.getBytes("utf-8"),"ISO-8859-1");
        File file=new File(route);
        FileInputStream fis=null;
        try{
            fis=new FileInputStream(file);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        return fis;
    }
	
	@Override
	public String execute() {
		try {
			Course cou = stagedao.QueryCourseByID(this.getId());
			session.put("course", cou);
			Teacher tea = stagedao.QueryTeacherByID(cou.getTeacher().getTid());
			session.put("teacher", tea);
			session.put("syllabus",
					"upload/" + this.QueryRoute(cou.getCid(), "教学大纲"));
			session.put("progress",
					"upload/" + this.QueryRoute(cou.getCid(), "教学进度表"));
			session.put("experiment",
					"upload/" + this.QueryRoute(cou.getCid(), "实验进度表"));
			session.put("courseware", this.QueryResource(cou.getCid(), "课件"));
			session.put("guide", this.QueryResource(cou.getCid(), "实验指导"));
			session.put("handout", this.QueryResource(cou.getCid(), "讲义"));
			session.put("pro", this.QueryResource(cou.getCid(), "学生作品"));
			session.put("homework", this.QueryResource(cou.getCid(), "作业"));
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return SUCCESS;
	}

}
