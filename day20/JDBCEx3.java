package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// �μ���ȣ 10�� �μ� ����� ���, �̸�, job�� �ֿܼ� ���
public class JDBCEx3 {
	public static void main(String[] args) {
		// 1. ���� ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		String user = "scott";
		String password = "tiger";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 2. JDBC ����̹��� �ε� �Ǿ� �ִ��� üũ�Ѵ�
		// 3. DB�� ������ �Ѵ�.(Connection)
		try {
			Class.forName(driver);
			// Returns the Class object associated
			// with the class or interface with the given string name.
			// ���� �߰ߵ��� �ʴ´ٸ� ClassNotFoundException�߻�.
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("Class.forName(driver) ���� ����");
		} catch (SQLException e) {
			System.out.println("DriverManager�� ���� �޼ҵ忡�� ����.");
		}

		// 4. SQL���� �ۼ�
		String sql = "SELECT empno, ename, job FROM emp WHERE deptno = 10";
		System.out.printf("%-5s %-12s %-12s \n", "���", "�̸�", "�μ���ȣ" );
		// ��Ʈ������ �� ' 3'~ ���߿� ���ڷ� �ٽ� ������ .toString() �ؼ� ��~��~��~ ' '~
//		StringBuffer sql_tmp = new StringBuffer();
//		sql_tmp.append("�ӽñ� ");
//		sql_tmp.append("���ñ� ");
		// sql_tmp.toString()
		
		// 5. ���� ��ü�� �����ϰ�
		// ������ �غ� �ܰ�, �������غ������ �������̽��� ������ pstmt ��ü
		// 6. ����(Select ==> ResultSet)
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery(); // return ResultSet

			// 7. �� �ߴٸ� ���ڵ庰�� ���� �ϰ���� ó���� �Ѵ�.
			// rs�� row select cursor�� �������� ����غ���.
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				System.out.printf("%-5d %-12s %-12s \n", empno, ename, job);
			}
		} catch (SQLException e) {
			System.out.println("SQL���� �̻��ؼ� ����");
			
			// 8. �� ��ٸ� �ڿ��� �ݳ�����.
		} finally {
			if(rs != null) {
					try {
						rs.close();	// to free~
						if(conn != null) conn.close();
						if(pstmt != null) pstmt.close();
						
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		}
	}
}
