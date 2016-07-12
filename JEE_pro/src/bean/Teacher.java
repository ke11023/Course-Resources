package bean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Teacher entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Teacher", schema = "dbo", catalog = "JEE")
public class Teacher implements java.io.Serializable {

	// Fields

	private Integer tid;
	private String tpwd;
	private String tname;
	private String tsex;
	private String tage;
	private String tphone;
	private Set<Course> courses = new HashSet<Course>(0);

	// Constructors

	/** default constructor */
	public Teacher() {
	}

	/** minimal constructor */
	public Teacher(Integer tid, String tpwd) {
		this.tid = tid;
		this.tpwd = tpwd;
	}

	/** full constructor */
	public Teacher(Integer tid, String tpwd, String tname, String tsex,
			String tage, String tphone, Set<Course> courses) {
		this.tid = tid;
		this.tpwd = tpwd;
		this.tname = tname;
		this.tsex = tsex;
		this.tage = tage;
		this.tphone = tphone;
		this.courses = courses;
	}

	// Property accessors
	@Id
	@Column(name = "Tid", unique = true, nullable = false)
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

	@Column(name = "Tpwd", nullable = false)
	public String getTpwd() {
		return this.tpwd;
	}

	public void setTpwd(String tpwd) {
		this.tpwd = tpwd;
	}

	@Column(name = "Tname")
	public String getTname() {
		return this.tname;
	}

	public void setTname(String tname) {
		this.tname = tname;
	}

	@Column(name = "Tsex")
	public String getTsex() {
		return this.tsex;
	}

	public void setTsex(String tsex) {
		this.tsex = tsex;
	}

	@Column(name = "Tage")
	public String getTage() {
		return this.tage;
	}

	public void setTage(String tage) {
		this.tage = tage;
	}

	@Column(name = "Tphone")
	public String getTphone() {
		return this.tphone;
	}

	public void setTphone(String tphone) {
		this.tphone = tphone;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "teacher")
	public Set<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

}