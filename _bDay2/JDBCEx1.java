package _bDay2;

import java.util.ArrayList;

import dao.DeptDAO;
import vo.DeptVO;

public class JDBCEx1 {
	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
//		DeptVO vo = new DeptVO();
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		
		list = dao.selectAll();
		
		for(DeptVO x : list) {
			System.out.printf("%-3d%10s%10s\r\n",x.getDeptno(), x.getDname(), x.getLoc());
		}
		
		dao.insertOne("SALES", "SEOUL");
		
		
	}
}
