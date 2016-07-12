package bean;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Schedule entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Schedule", schema = "dbo", catalog = "JEE")
public class Schedule implements java.io.Serializable {

	// Fields

	private ScheduleId id;
	private Student student;
	private Course course;
	private Integer tid;

	// Constructors

	/** default constructor */
	public Schedule() {
	}

	/** minimal constructor */
	public Schedule(ScheduleId id, Student student, Course course) {
		this.id = id;
		this.student = student;
		this.course = course;
	}

	/** full constructor */
	public Schedule(ScheduleId id, Student student, Course course, Integer tid) {
		this.id = id;
		this.student = student;
		this.course = course;
		this.tid = tid;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "sid", column = @Column(name = "Sid", nullable = false)),
			@AttributeOverride(name = "cid", column = @Column(name = "Cid", nullable = false)) })
	public ScheduleId getId() {
		return this.id;
	}

	public void setId(ScheduleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Sid", nullable = false, insertable = false, updatable = false)
	public Student getStudent() {
		return this.student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Cid", nullable = false, insertable = false, updatable = false)
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Column(name = "Tid")
	public Integer getTid() {
		return this.tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}

}