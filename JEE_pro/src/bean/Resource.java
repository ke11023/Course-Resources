package bean;

import java.sql.Timestamp;

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
 * Resource entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Resource", schema = "dbo", catalog = "JEE")
public class Resource implements java.io.Serializable {

	// Fields

	private Integer rid;
	private Course course;
	private String rname;
	private String rtype;
	private String rdescription;
	private Timestamp rtime;
	private String rroute;
	private String rnum;

	// Constructors

	/** default constructor */
	public Resource() {
	}

	/** minimal constructor */
	public Resource(Integer rid) {
		this.rid = rid;
	}

	/** full constructor */
	public Resource(Integer rid, Course course, String rname, String rtype,
			String rdescription, Timestamp rtime, String rroute, String rnum) {
		this.rid = rid;
		this.course = course;
		this.rname = rname;
		this.rtype = rtype;
		this.rdescription = rdescription;
		this.rtime = rtime;
		this.rroute = rroute;
		this.rnum = rnum;
	}

	// Property accessors
	@Id
	@Column(name = "Rid", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cid")
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "Rname")
	public String getRname() {
		return this.rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	@Column(name = "Rtype")
	public String getRtype() {
		return this.rtype;
	}

	public void setRtype(String rtype) {
		this.rtype = rtype;
	}

	@Column(name = "Rdescription")
	public String getRdescription() {
		return this.rdescription;
	}

	public void setRdescription(String rdescription) {
		this.rdescription = rdescription;
	}

	@Column(name = "Rtime", length = 23)
	public Timestamp getRtime() {
		return this.rtime;
	}

	public void setRtime(Timestamp rtime) {
		this.rtime = rtime;
	}

	@Column(name = "Rroute")
	public String getRroute() {
		return this.rroute;
	}

	public void setRroute(String rroute) {
		this.rroute = rroute;
	}

	@Column(name = "Rnum")
	public String getRnum() {
		return this.rnum;
	}

	public void setRnum(String rnum) {
		this.rnum = rnum;
	}

}