package vo;

public class DeptVO {
	int deptno;
	String dname;
	String loc;
	// java bin, DTO, VO
	
	
	
	public DeptVO() {	// ��ü�� �����ؼ� �������� �����͸� �����ϱ� ���� ����
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
