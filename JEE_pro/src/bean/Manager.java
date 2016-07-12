package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Manager entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "Manager", schema = "dbo", catalog = "JEE")
public class Manager implements java.io.Serializable {

	// Fields

	private String mid;
	private String mpwd;

	// Constructors

	/** default constructor */
	public Manager() {
	}

	/** full constructor */
	public Manager(String mid, String mpwd) {
		this.mid = mid;
		this.mpwd = mpwd;
	}

	// Property accessors
	@Id
	@Column(name = "Mid", unique = true, nullable = false)
	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Column(name = "Mpwd", nullable = false)
	public String getMpwd() {
		return this.mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

}