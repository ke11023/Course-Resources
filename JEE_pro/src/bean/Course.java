package bean;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Course entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Course", schema = "dbo", catalog = "JEE")
public class Course implements java.io.Serializable {

	// Fields

	private String cid;
	private Teacher teacher;
	private String cname;
	private String cbrief;
	private String cdepaetment;
	private Set<Message> messages = new HashSet<Message>(0);
	private Set<Schedule> schedules = new HashSet<Schedule>(0);
	private Set<Resource> resources = new HashSet<Resource>(0);

	// Constructors

	/** default constructor */
	public Course() {
	}

	/** minimal constructor */
	public Course(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	/** full constructor */
	public Course(String cid, Teacher teacher, String cname, String cbrief,
			String cdepaetment, Set<Message> messages, Set<Schedule> schedules,
			Set<Resource> resources) {
		this.cid = cid;
		this.teacher = teacher;
		this.cname = cname;
		this.cbrief = cbrief;
		this.cdepaetment = cdepaetment;
		this.messages = messages;
		this.schedules = schedules;
		this.resources = resources;
	}

	// Property accessors
	@Id
	@Column(name = "Cid", unique = true, nullable = false)
	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Tid")
	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	@Column(name = "Cname", nullable = false)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "Cbrief")
	public String getCbrief() {
		return this.cbrief;
	}

	public void setCbrief(String cbrief) {
		this.cbrief = cbrief;
	}

	@Column(name = "Cdepaetment")
	public String getCdepaetment() {
		return this.cdepaetment;
	}

	public void setCdepaetment(String cdepaetment) {
		this.cdepaetment = cdepaetment;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Message> getMessages() {
		return this.messages;
	}

	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Schedule> getSchedules() {
		return this.schedules;
	}

	public void setSchedules(Set<Schedule> schedules) {
		this.schedules = schedules;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "course")
	public Set<Resource> getResources() {
		return this.resources;
	}

	public void setResources(Set<Resource> resources) {
		this.resources = resources;
	}

}