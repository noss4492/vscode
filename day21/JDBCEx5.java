package day21;
//1. ���� ����
//2. JDBC ����̹��� �ε� �Ǿ� �ִ��� üũ�Ѵ�
//3. DB�� ������ �Ѵ�.(Connection)
//4. SQL���� �ۼ�
//5. ���� ��ü�� �����ϰ�
//6. ����(Select ==> ResultSet)
//7. �� �ߴٸ� ���ڵ庰�� ���� �ϰ���� ó���� �Ѵ�.
//8. �� ��ٸ� �ڿ��� �ݳ�����.

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx5 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		String user="scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println(conn);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 7788�� ����� �޿��� 1000���� ����
		
//		sb.append("UPDATE EMP ");
//		sb.append("SET SAL = ? ");
//		sb.append("WHERE EMPNO = ? ");
		
//		sb.append("INSERT INTO EMP (EMPNO, ENAME, SAL)");
//		sb.append("VALUES (1111, 'HONG', 3000");
//		sb.append("VALUES (1111, 'HONG', 3000)");
//		sb.append("DELETE FROM ZEMP");
//		sb.append("WHERE EMPNO = 1111");
		
//		sb.append("INSERT INTO EMP (EMPNO, ENAME, SAL)");
//		sb.append("VALUES (?,?,?)");
		
		sb.append("DELETE FROM EMP ");
		sb.append("WHERE EMPNO = ?");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
//			pstmt.setInt(1, 1004);
//			pstmt.setString(2, "�ɽ���");
//			pstmt.setInt(3, 87788);
			
			pstmt.setInt(1, 1004);
			
//			pstmt.executeUpdate();	// �����ϸ� ��.
			int result = pstmt.executeUpdate();
			System.out.println("result : "+result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn !=null)conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
