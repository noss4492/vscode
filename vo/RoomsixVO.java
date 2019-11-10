package vo;

public class RoomsixVO {
	String id;
	String ename;
	String pwd;
	String gender;
	String cause;
	
	public RoomsixVO() {
	}

	public RoomsixVO(String id, String ename, String pwd, String gender, String cause) {
		super();
		this.id = id;
		this.ename = ename;
		this.pwd = pwd;
		this.gender = gender;
		this.cause = cause;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

}
