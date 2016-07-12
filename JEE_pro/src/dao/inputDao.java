package dao;

import java.util.*;

import bean.*;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
@Transactional 
public class inputDao extends HibernateDaoSupport{
	public void StudentInput(List<Student> list){
		for(int i=0;i<list.size();i++){
			Student stu=list.get(i);
			this.getHibernateTemplate().saveOrUpdate(stu);
		}
	}

	public void TeacherInput(List<Teacher> list) {
		for(int i=0;i<list.size();i++){
			Teacher tea=list.get(i);
			this.getHibernateTemplate().saveOrUpdate(tea);
		}
	}
}
