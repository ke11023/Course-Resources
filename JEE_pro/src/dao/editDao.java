package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.*;
@Transactional 
public class editDao extends HibernateDaoSupport{
	public void editManager(Manager mana) {
		try {
			this.getHibernateTemplate().saveOrUpdate(mana);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void editTeacher(Teacher tea) {
		try {
			this.getHibernateTemplate().saveOrUpdate(tea);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void editStudent(Student stu) {
		try {
			this.getHibernateTemplate().saveOrUpdate(stu);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void editCourse(Course cou){
		try{
			this.getHibernateTemplate().saveOrUpdate(cou);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	@Transactional(readOnly=true,propagation=Propagation.NEVER)  
	public List Query(String hql){
		return this.getHibernateTemplate().find(hql);
	}

	public void deleteSchedule(Schedule schedule) {
		try{
			this.getHibernateTemplate().delete(schedule);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteMessage(Message message) {
		try{
			this.getHibernateTemplate().delete(message);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteResource(Resource resource) {
		try{
			this.getHibernateTemplate().delete(resource);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteCourse(Course cou) {
		try{
			this.getHibernateTemplate().delete(cou);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteTeacher(int tid) {
		try{
			Teacher tea=this.getHibernateTemplate().get(Teacher.class, tid);
			this.getHibernateTemplate().delete(tea);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void deleteStudent(int id) {
		try{
			Student stu=this.getHibernateTemplate().get(Student.class, id);
			this.getHibernateTemplate().delete(stu);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
