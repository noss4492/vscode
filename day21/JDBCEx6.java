package day21;
import java.util.ArrayList;

import dao.DeptDAO;
import vo.DeptVO;

public class JDBCEx6 {
	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
		DeptVO vo = dao.selectOne(20);
//		ArrayList<DeptVO> list = dao.selectAll();
//		for(DeptVO x : list) {
//			System.out.println("부서번호 : "+x.getDeptno());
//			System.out.println("부서명 : "+x.getDname());
//			System.out.println("부서위치 : "+x.getLoc());
//			System.out.println("-----------------------");
//			dao.close();
//		}
		
		
		
//		System.out.printf("[부서번호:%s] [부서명:%s] [부서위치:%s]", vo.getDeptno(), vo.getDname(), vo.getLoc());
		
		
		
//		dao.insertOne("몬가 계속", "늘어남");
		
//		DeptVO tmpVo = dao.selectOne(20);
//		if(tmpVo.getDname().matches("회계*"));//("회계..."));//("^[회계]*$"));
//			dao.deleteOne(cnt);
		
//		dao.deleteOne(182);
		
//		for(int i = 227; i <= 246; i++)
//			dao.deleteOne(i);
		
//		dao.updateOne(659, "삼겹살", "떡볶이");
//		for(int i = 600; i<650; i++)
//			dao.updateOne(i, "점심", "대만족");
		
		//전체 조회
		
		
	}
}
