package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.Course;

public class infoDao extends HibernateDaoSupport{  
	public List Query(String hql) {
		return this.getHibernateTemplate().find(hql);
	}

	@Transactional 
	public void addcourse(Course cou) {
		try {
			
			this.getHibernateTemplate().save(cou);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}	
	

}
