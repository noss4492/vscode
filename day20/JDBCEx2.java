package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// �μ� ���̺� ������ �����ͼ� ȭ�鿡 ���
public class JDBCEx2 {
	public static void main(String[] args) {
		// 1. ���� ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		String user = "scott";
		String password = "tiger";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM dept";
		// 2. JDBC ����̹��� �ε� �Ǿ� �ִ��� üũ�Ѵ�
		// 3. DB�� ������ �Ѵ�.(Connection)
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn : " + conn);
		} catch (ClassNotFoundException e) {
			System.out.println("����̹��� ã�� �� ����, ����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("�� �ȸ���, DB ���� ������");
		}
		// 4. SQL���� �ۼ�
		// 5. ���� ��ü�� �����ϰ�

		// Creates a PreparedStatement object
		// for sending parameterized SQL statements to the DB
		try {
			pstmt = conn.prepareStatement(sql);
			// 6. ����(Select ==> ResultSet)
			rs = pstmt.executeQuery();
			// 7. �� �ߴٸ� ���ڵ庰�� ���� �ϰ���� ó���� �Ѵ�.
			while (rs.next()) {
				int deptno = rs.getInt("deptno");// �̸��ᵵ �ǰ� �ε��� �ᵵ �ǰ�
				String dname = rs.getString(2); // ���뼺 ����~ ' 3'
				String loc = rs.getString("loc");
				System.out.printf("%2d %12s %12s \n", deptno, dname, loc);
			}
		} catch (SQLException e) {
			System.out.println("SQL���� �̻���;;");
		} finally {
			// 8. �� ��ٸ� �ڿ��� �ݳ�����.
			if (rs != null)
				try {
					rs.close();
					if (pstmt != null)
						pstmt.close();
					if (conn != null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
