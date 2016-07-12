package Action;

import java.io.File;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import util.copyHelper;
import util.jacobHelper;

import com.opensymphony.xwork2.ActionSupport;

import dao.teacherDao;
import bean.*;

public class teacherAction extends ActionSupport implements SessionAware {
	private File upload;
	private String savepath,uploadFileName,uploadContentType;
	private String cid,rname,rtype,cbrief,route,rid,age,name,pwd,sex,phone;
	private teacherDao teacherdao;
	private Map session;
	static final int wdFormatPDF = 17;// word转PDF 格式
	
	public void setTeacherdao(teacherDao teacherdao) {
		this.teacherdao = teacherdao;
	}

	public Map getSession() {
		return session;
	}

	public void setSession(Map session) {
		this.session = session;
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

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRtype() {
		return rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	public String getCbrief() {
		return cbrief;
	}

	public void setCbrief(String cbrief) {
		this.cbrief = cbrief;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void QueryCourse(){
		try{
			int tid=Integer.valueOf((String) session.get("teacher_id"));
			String hql="from Course u where u.teacher.tid='"+tid+"'";
			List<Course> cou=teacherdao.QueryCourse(hql);
			if (cou!=null) 
				session.put("info",cou);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public String resourceUpload(){
		this.QueryCourse();
		return SUCCESS;
	}
	
	public String homework(){
		this.QueryCourse();
		return SUCCESS;
	}
	
	public String InfoQuery(){
		int tid=Integer.valueOf((String) session.get("teacher_id"));
		try{
			Teacher tea = teacherdao.QueryTeacherByID(tid);
			session.put("teacher", tea.getTid());
			session.put("pwd", tea.getTpwd());
			session.put("name", tea.getTname());
			session.put("sex", tea.getTsex());
			session.put("age", tea.getTage());
			session.put("phone", tea.getTphone());
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String InfoEdit(){
		int tid=Integer.valueOf((String) session.get("teacher_id"));
		try{
			Teacher tea = teacherdao.QueryTeacherByID(tid);
			tea.setTage(this.getAge());
			tea.setTname(this.getName());
			tea.setTphone(this.getPhone());
			tea.setTpwd(this.getPwd());
			tea.setTsex(this.getSex());
			teacherdao.editTeacher(tea);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	public String resourceInfo(){
		String flag=INPUT;
		try{
			int tid=Integer.valueOf((String) session.get("teacher_id"));
			String hql="from Course u where u.teacher.tid='"+tid+"'";
			//System.out.println(hql);
			List<Course> cou=teacherdao.QueryCourse(hql);
			if(cou!=null){
				hql="from Resource u where u.course.cid='"+cou.get(0).getCid()+"'";
				//System.out.println(hql);
				List<Resource> res=teacherdao.QueryResource(hql);
				//System.out.println(res);
				if(res!=null)
					session.put("resource", res);
				flag=SUCCESS;
			}
			
		/*	//测试用 输出全部资源
			String hql="from Resource";
			List<Resource> list=teacherdao.QueryResource(hql);
			Resource resource=list.get(0);
			System.out.println(resource.getRname()+" "+resource.getCourse());
			if(list!=null){
				session.put("resource", list);
				flag=SUCCESS;
			}*/
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
	
	public String resourceDetail(){
		String flag=INPUT;
		try{		
			String  path=this.getRoute();
			//System.out.println(this.getRoute());
			int splitIndex = path.lastIndexOf("/");
			String suffix = path.substring(splitIndex + 1);
			session.put("pdfroute", "upload/"+suffix);
			flag=SUCCESS;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return flag;
	}
	
	public String deleteResource(){
		try{
			Resource res=teacherdao.QueryByID(Integer.valueOf(this.getRid()));
			//System.out.println(res.getRroute());
			String hql="from Message u where u.mesroute='"+res.getRroute()+"'";
			List<Message> mes=teacherdao.QueryMessage(hql);
			if(mes!=null)
			for(int i=0;i<mes.size();i++)
				teacherdao.deleteMessage(mes.get(i));
			teacherdao.deleteResource(res);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
		
	public String homeworkSetting(){
		try{
			String hql="from Course u where u.cid='"+this.getCid()+"'";
			List<Course> list=teacherdao.QueryCourse(hql);
			Date now = new Date(); 
			String name=list.get(0).getCname().replace(" ", "");
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd ");//可以方便地修改日期格式
			String date=dateFormat.format(now).replace(" ","");
			//设置路径
			String wordpath="D:/eclipse/workspace/.metadata/.me_tcat/webapps/JEE_pro/upload/"+name+"_"+date+".txt";
			String pdfpath="D:/eclipse/workspace/.metadata/.me_tcat/webapps/JEE_pro/upload/"+name+"_"+date+".pdf";
			//转换pdf
			jacobHelper.homework(wordpath, pdfpath, this.getCbrief());
			//作业置入数据库
			Resource res=new Resource();
			res.setCourse(list.get(0));
			res.setRdescription(this.getCbrief());
			if(this.getRname()!="")
				res.setRname(this.getRname());
			else res.setRname(list.get(0).getCname()+"_"+dateFormat.format(now));
			res.setRtype(this.getRtype());
			res.setRtime(new Timestamp(System.currentTimeMillis()));
			res.setRroute(pdfpath);
			teacherdao.addResource(res);
			//添加对应的作业消息
			hql="from Schedule u where u.course.cid='"+list.get(0).getCid()+"'";
			List<Schedule> schedule=teacherdao.QueryStudent(hql);
			for(int i=0;i<schedule.size();i++){
				Message mes=new Message();
				mes.setCourse(list.get(0));
				mes.setMesdescription(this.getCbrief());
				mes.setMesroute(pdfpath);
				mes.setMesstatus(0);
				//System.out.println(teacherdao.QueryStudentByID(schedule.get(i).getStudent().getSid()).getSid());
				mes.setStudent(teacherdao.QueryStudentByID(schedule.get(i).getStudent().getSid()));
				//mes.setMesid(123);
				teacherdao.addMessage(mes);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return SUCCESS;
	}
	
	@Override
	public String execute() {
		String flag=INPUT;
		try {
			String dstpath=ServletActionContext.getServletContext().getRealPath(this.getSavepath())+"/"+this.getUploadFileName();
			File dstfile=new File(dstpath);
			copyHelper.copy(this.upload,dstfile);			
			String pdfpath=ServletActionContext.getServletContext().getRealPath(this.getSavepath())+"/"+this.getRname()+"_"+this.getRtype()+".pdf";
			/*System.out.println(dstfile);
			System.out.println("类型"+this.getUploadContentType());
			System.out.println(dstpath);
			System.out.println(pdfpath);*/
			jacobHelper.change(dstpath, pdfpath);
			String hql="from Course u where u.cid='"+this.getCid()+"'";
			List<Course> list=teacherdao.QueryCourse(hql);
			Resource res=new Resource();
			res.setCourse(list.get(0));
			res.setRdescription(this.getCbrief());
			res.setRname(this.getRname());
			res.setRtype(this.getRtype());
			res.setRtime(new Timestamp(System.currentTimeMillis()));
			res.setRroute(pdfpath);
			teacherdao.addResource(res);
			flag=SUCCESS; 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	

}
