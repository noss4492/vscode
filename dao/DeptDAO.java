package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.DeptVO;

// Ÿ�� ġ�� �������ϱ� ~ ��ü�����̴ϱ�~

public class DeptDAO {
	// ������� DB����
//	String driver = "oracle.jdbc.driver.OracleDriver";
//	String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
//	String user = "scott";
//	String password = "tiger";

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@orcl.ckyvzseloumz." + "ap-northeast-2.rds.amazonaws.com:1521:orcl";
	String user = "admin";
	String password = "tigertiger";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	StringBuffer sb = new StringBuffer();
	ResultSet rs = null;

	public DeptDAO() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("����̹��Ŵ����� DB���� ������");
		}

	}// Construct end

	// ��ü ��ȸ
	// 1�� ��ȸ(10�� �μ� ���� ��������)
	public DeptVO selectOne(int deptno) { // �׳� �׸�ä�� �����ؼ� �Ѱ��ܤ�
		// 4. SQL���� �ۼ�
		sb.setLength(0);// ���� ���� ���� ����(�� �ű��� �����̳�)
		sb.append("SELECT deptno, dname, loc ");
		sb.append("FROM dept ");
		sb.append("WHERE deptno = ? ");

		DeptVO vo = null;
		// 5. ���� ��ü�� �����ϰ�
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, deptno);

			// 6. ����(Select ==> ResultSet)
			rs = pstmt.executeQuery();

			// 7. �� �ߴٸ� ���ڵ庰�� ���� �ϰ���� ó���� �Ѵ�.
			rs.next();
			String dname = rs.getString("dname");
			String loc = rs.getString("loc");

			vo = new DeptVO(deptno, dname, loc);
//			vo = new DeptVO();
//			vo.setDeptno(deptno);
//			vo.setDname(dname);`
//			vo.setLoc(loc);
		} catch (SQLException e) {
			System.out.println("SQL�� �߸���");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// 8. �� ��ٸ� �ڿ��� �ݳ�����.

		return vo;
	}// select end

	public void insertOne(String dname, String loc) {
		// 4. SQL���� �ۼ�
		// 5. ���� ��ü�� �����ϰ�
		// 6. ����(Select ==> ResultSet)
		// 7. �� �ߴٸ� ���ڵ庰�� ���� �ϰ���� ó���� �Ѵ�.
		// 8. �� ��ٸ� �ڿ��� �ݳ�����.
		sb.setLength(0);// ���� ���� ���� ����(�� �ű��� �����̳�)
		sb.append("INSERT INTO dept ");
		sb.append("VALUES (DEPT_DEPTNO.NEXTVAL, ?, ?)");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, dname);
			pstmt.setString(2, loc);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL�� miss");
			e.printStackTrace();
		}
	}

	public void deleteOne(int deptno) {
		sb.setLength(0);
		sb.append("DELETE FROM DEPT ");
		sb.append("WHERE DEPTNO = ? ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, deptno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateOne(int deptno, String dname, String loc) {
		sb.setLength(0);
		sb.append("UPDATE DEPT ");
		sb.append("SET DNAME = ?, LOC = ? ");
		sb.append("WHERE DEPTNO = ?");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(2, loc);
			pstmt.setString(1, dname);
			pstmt.setInt(3, deptno);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public ArrayList<DeptVO> selectAll() {
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		sb.setLength(0);
		sb.append("SELECT deptno, dname ,loc ");
		sb.append("FROM dept ");

		try {
			pstmt = conn.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int deptno = rs.getInt("deptno");
				String dname = rs.getString("dname");
				String loc = rs.getString("loc");
				DeptVO vo = new DeptVO(deptno, dname, loc);
				list.add(vo);
			}
		} catch (SQLException e) {
			System.out.println("������ �� ����Ŷ�~");
		}
		return list;
	}
	
	public void close() {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				System.out.println("�ڿ��ݳ� ����");
			}
	}
}
