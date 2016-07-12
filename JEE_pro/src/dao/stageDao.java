package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import bean.Course;
import bean.Message;
import bean.Student;
import bean.Teacher;

public class stageDao extends HibernateDaoSupport{

	public Course QueryCourseByID(String cid) {
		return this.getHibernateTemplate().get(Course.class, cid);
	}

	public Teacher QueryTeacherByID(Integer tid) {
		return this.getHibernateTemplate().get(Teacher.class, tid);
	}

	public List QueryResource(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	public List<Message> QueryMessage(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	@Transactional 
	public void editMessage(Message message) {
		try{
			this.getHibernateTemplate().saveOrUpdate(message);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	public Student QueryStudentByID(int sid) {
		return this.getHibernateTemplate().get(Student.class, sid);
	}

	public Message QueryMessageByID(Integer mesid) {
		return this.getHibernateTemplate().get(Message.class, mesid);
	}

	public List<Course> QueryCourse(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	@Transactional 
	public void editStudent(Student stu) {
		try{
			this.getHibernateTemplate().update(stu);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
