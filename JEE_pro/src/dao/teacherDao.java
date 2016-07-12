package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.*;

public class teacherDao extends HibernateDaoSupport{
	
	public List<Course> QueryCourse(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<Teacher> QueryTeacher(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	
	public List<Resource> QueryResource(String hql){
		return this.getHibernateTemplate().find(hql);
	}

	public List<Schedule> QueryStudent(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	public List<Message> QueryMessage(String hql) {
		return this.getHibernateTemplate().find(hql);
	}
	
	public Student QueryStudentByID(Integer sid) {
		return this.getHibernateTemplate().get(Student.class, sid);
	}

	public Teacher QueryTeacherByID(int id){
		return (Teacher)this.getHibernateTemplate().get(Teacher.class, id);
	}
	
	public Resource QueryByID(int id) {
		return (Resource)this.getHibernateTemplate().get(Resource.class, id);
	}

	@Transactional 
	public void addResource(Resource res) {
		try{
			this.getHibernateTemplate().save(res);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Transactional
	public void deleteResource(Resource res) {
		try{
			this.getHibernateTemplate().delete(res);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Transactional
	public void addMessage(Message mes) {
		try{
			this.getHibernateTemplate().save(mes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Transactional
	public void deleteMessage(Message mes) {
		try{
			this.getHibernateTemplate().delete(mes);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	@Transactional
	public void editTeacher(Teacher tea) {
		try{
			this.getHibernateTemplate().saveOrUpdate(tea);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}


}
