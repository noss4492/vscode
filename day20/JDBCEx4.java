package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCEx4 {
	//1. ���� ����
	//2. JDBC ����̹��� �ε� �Ǿ� �ִ��� üũ�Ѵ�
	//3. DB�� ������ �Ѵ�.(Connection)
	//4. SQL���� �ۼ�
	//5. ���� ��ü�� �����ϰ�
	//6. ����(Select ==> ResultSet)
	//7. �� �ߴٸ� ���ڵ庰�� ���� �ϰ���� ó���� �Ѵ�.
	//8. �� ��ٸ� �ڿ��� �ݳ�����.

	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";	//
		String user = "scott";
		String pw = "tiger";
		
		Connection conn = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
			
		} catch (ClassNotFoundException e) {
			// Ŭ���� ������ �ϰ͵� �� ã�ƿԾ�
		} catch (SQLException e) {
			// ����̹��Ŵ������� ���� �����߼�
		}
		
		//�����ϰ�
		//��ü�� ���
		PreparedStatement psmt = null;
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT EMPNO, ENAME, JOB, SAL ");
		sql.append("FROM EMP ");
		sql.append("WHERE SAL >= 2400 ");
		sql.append("AND JOB = 'MANAGER' ");
		
		
		// ���������ܰ� �غ� -> ������ �� ��ü�� ��Ƽ� exe�Ѱ� �޾Ƽ� ������� �丮�ؼ� ���
		ResultSet rs = null;
		try {
			psmt = conn.prepareStatement(sql.toString());
			rs = psmt.executeQuery();
			while(rs.next()) {
				int empno = rs.getInt("EMPNO");
				String ename = rs.getString("ENAME");
				String job = rs.getString("JOB");
				int sal = rs.getInt("SAL");
				System.out.printf("%d\t%s\t%s\t%d\n",empno, ename, job, sal);
			}
		} catch (SQLException e) {
			// �� �̰� SQL���� �� �̻��ϴ�
		} finally {
		// free������ �κ�
			if(rs!=null) {
				try {
					rs.close();
				if(psmt!=null)
						psmt.close();
				if(conn!=null)
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
