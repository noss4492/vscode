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
//			System.out.println("�μ���ȣ : "+x.getDeptno());
//			System.out.println("�μ��� : "+x.getDname());
//			System.out.println("�μ���ġ : "+x.getLoc());
//			System.out.println("-----------------------");
//			dao.close();
//		}
		
		
		
//		System.out.printf("[�μ���ȣ:%s] [�μ���:%s] [�μ���ġ:%s]", vo.getDeptno(), vo.getDname(), vo.getLoc());
		
		
		
//		dao.insertOne("�� ���", "�þ");
		
//		DeptVO tmpVo = dao.selectOne(20);
//		if(tmpVo.getDname().matches("ȸ��*"));//("ȸ��..."));//("^[ȸ��]*$"));
//			dao.deleteOne(cnt);
		
//		dao.deleteOne(182);
		
//		for(int i = 227; i <= 246; i++)
//			dao.deleteOne(i);
		
//		dao.updateOne(659, "����", "������");
//		for(int i = 600; i<650; i++)
//			dao.updateOne(i, "����", "�븸��");
		
		//��ü ��ȸ
		
		
	}
}
