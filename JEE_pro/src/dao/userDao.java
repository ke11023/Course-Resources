package dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import bean.*;

public class userDao  extends HibernateDaoSupport {
	public boolean checkRegister(String id) {
		boolean flag = false;
		try {
			String hql = "from Student u where u.sid='"+id+"'";			
			//System.out.println(hql);
			List t=this.getHibernateTemplate().find(hql);
			if (t.size()>0)
				flag = true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	@Transactional 
	public void addStudent(Student stu) {
		try {
			this.getHibernateTemplate().save(stu);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public boolean ManagerLogin(Manager mana) {
		boolean flag=false;
		try {
			String mana_pwd=mana.getMpwd();
			String hql = "from Manager u where u.mid='"+mana.getMid()+"' and u.mpwd='"+mana.getMpwd()+"'";	
			List<Manager> t=this.getHibernateTemplate().find(hql);
			if(t.size()>0)				
				flag=true;				
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}

	public String TeacherrLogin(Teacher tea) {
		String name=null;
		Teacher teacher=null;
		try {
			String hql = "from Teacher u where u.tid='"+tea.getTid()+"' and u.tpwd='"+tea.getTpwd()+"'";			
			List<Teacher> t=this.getHibernateTemplate().find(hql);
			if(t.size()>0)				
				teacher=t.get(0);
			name=teacher.getTname();			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return name;
	}

/*	public boolean StudentLgoin(Student stu) {
		boolean flag=false;
		try {
			String hql = "from Student u where u.sid='"+stu.getSid()+"' and u.spwd='"+stu.getSpwd()+"'";	
			System.out.println(hql);
			if(this.getHibernateTemplate().find(hql)!=null)
				flag=true;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return flag;
	}*/


	public List queryMessage(String hql) {
		List list=this.getHibernateTemplate().find(hql);
		return list;
		
	}

	public Student QueryStudentByID(Integer integer) {
		return this.getHibernateTemplate().get(Student.class, integer);
	}
	
	
}
