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
 * Student entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Student", schema = "dbo", catalog = "JEE")
public class Student implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String spwd;
	private String sname;
	private String ssex;
	private String sage;
	private Integer status;
	private Set<Message> messages = new HashSet<Message>(0);
	private Set<Schedule> schedules = new HashSet<Schedule>(0);

	// Constructors

	/** default constructor */
	public Student() {
	}

	/** minimal constructor */
	public Student(Integer sid, String spwd, Integer status) {
		this.sid = sid;
		this.spwd = spwd;
		this.status = status;
	}

	/** full constructor */
	public Student(Integer sid, String spwd, String sname, String ssex,
			String sage, Integer status, Set<Message> messages,
			Set<Schedule> schedules) {
		this.sid = sid;
		this.spwd = spwd;
		this.sname = sname;
		this.ssex = ssex;
		this.sage = sage;
		this.status = status;
		this.messages = messages;
		this.schedules = schedules;
	}

	// Property accessors
	@Id
	@Column(name = "Sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "Spwd", nullable = false)
	public String getSpwd() {
		return this.spwd;
	}

	public void setSpwd(String spwd) {
		this.spwd = spwd;
	}

	@Column(name = "Sname")
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "Ssex")
	public String getSsex() {
		return this.ssex;
	}

	public void setSsex(String ssex) {
		this.ssex = ssex;
	}

	@Column(name = "Sage")
	public String getSage() {
		return this.sage;
	}

	public void setSage(String sage) {
		this.sage = sage;
	}

	@Column(name = "Status", nullable = false)
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "student")
	public Set<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}

}