package bean;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ScheduleId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class ScheduleId implements java.io.Serializable {

	// Fields

	private Integer sid;
	private String cid;

	// Constructors

	/** default constructor */
	public ScheduleId() {
	}

	/** full constructor */
	public ScheduleId(Integer sid, String cid) {
		this.sid = sid;
		this.cid = cid;
	}

	// Property accessors

	@Column(name = "Sid", nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "Cid", nullable = false)
	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ScheduleId))
			return false;
		ScheduleId castOther = (ScheduleId) other;

		return ((this.getSid() == castOther.getSid()) || (this.getSid() != null
				&& castOther.getSid() != null && this.getSid().equals(
				castOther.getSid())))
				&& ((this.getCid() == castOther.getCid()) || (this.getCid() != null
						&& castOther.getCid() != null && this.getCid().equals(
						castOther.getCid())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSid() == null ? 0 : this.getSid().hashCode());
		result = 37 * result
				+ (getCid() == null ? 0 : this.getCid().hashCode());
		return result;
	}

}