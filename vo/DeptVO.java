package vo;

public class DeptVO {
	int deptno;
	String dname;
	String loc;
	// java bin, DTO, VO
	
	
	
	public DeptVO() {	// 객체로 리턴해서 여러개의 데이터를 전달하기 위한 목적
	}
	
	public int getDeptno() {
		return deptno;
	}
	public DeptVO(int deptno, String dname, String loc) {
		super();
		this.deptno = deptno;
		this.dname = dname;
		this.loc = loc;
	}
	// setter getter
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	
	
}
