package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Message entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Message", schema = "dbo", catalog = "JEE")
public class Message implements java.io.Serializable {

	// Fields

	private Integer mesid;
	private Student student;
	private Course course;
	private String mesdescription;
	private String mesroute;
	private Integer messtatus;

	// Constructors

	/** default constructor */
	public Message() {
	}

	/** minimal constructor */
	public Message(Integer mesid) {
		this.mesid = mesid;
	}

	/** full constructor */
	public Message(Integer mesid, Student student, Course course,
			String mesdescription, String mesroute, Integer messtatus) {
		this.mesid = mesid;
		this.student = student;
		this.course = course;
		this.mesdescription = mesdescription;
		this.mesroute = mesroute;
		this.messtatus = messtatus;
	}

	// Property accessors
	@Id
	@Column(name = "Mesid", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getMesid() {
		return this.mesid;
	}

	public void setMesid(Integer mesid) {
		this.mesid = mesid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Sid")
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cid")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "Mesdescription")
	public String getMesdescription() {
		return this.mesdescription;
	}

	public void setMesdescription(String mesdescription) {
		this.mesdescription = mesdescription;
	}

	@Column(name = "Mesroute")
	public String getMesroute() {
		return this.mesroute;
	}

	public void setMesroute(String mesroute) {
		this.mesroute = mesroute;
	}

	@Column(name = "Messtatus")
	public Integer getMesstatus() {
		return this.messtatus;
	}

	public void setMesstatus(Integer messtatus) {
		this.messtatus = messtatus;
	}

}