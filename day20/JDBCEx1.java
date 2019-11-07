package day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;	//JDBC�� �� �������̽�, �ֳ�? ȸ�縶�� �ٸ��� ���ϱ�
import java.sql.SQLException;

// ���� �� ���Ƥˤ�
public class JDBCEx1 {
	public static void main(String[] args) {
		// 1. ���� ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		// jdbc���� ����Ŭ�����ϴµ� thin�������ٰ�. ������ ����ip ��Ʈ dbname
		// thin �淮 ����̹� fat ���ſ� ����̹� ���
		String user = "scott";
		String password = "tiger";

		Connection conn = null; // �� �� ��ġ��? �ؿ��� �������
		try {
			// 2. JDBC ����̹� �ε� �Ǿ� �ִ��� üũ
			Class.forName(driver);
			// 3. ����(Connection)
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("conn :" + conn);
			// uri : uniform resource locator
		} catch (ClassNotFoundException e) {
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
		}

		// 4. sql�� �ۼ�
		// �ִ��� ���⼭ �ɷ����� ��Ʈ��ũ Ʈ������ ������.
		String sql = "SELECT empno, ename, sal FROM emp WHERE sal >= 3000";
	
		// 5. ���� ��ü ����(������ ��ü�ϱ�)
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			// 6. ����(select ==> ResultSet)
			rs = pstmt.executeQuery(); // ������ �� ã�ƿ� �� : ����Ʈ��
			System.out.println(rs);
			// 7. ���ڵ庰 ó��
			rs.next(); // ����(ù��°) ���ڵ�� �̵���
			// �ش� �÷� ������ ��������
			int empno = rs.getInt("EMPNO");
			int sal = rs.getInt("sal");

			System.out.print("    ���            �̸�      �޿�\n");
			System.out.println("----------------");
			String ename = rs.getString("ename");
			System.out.printf("%5s %8s %5s \n", empno, ename, sal);
			// ������ohohohohoo
			while (rs.next() == true) {
				empno = rs.getInt("EMPNO");
				ename = rs.getString("ename");
				sal = rs.getInt("sal");
				System.out.printf("%5s %8s %5s \n", empno, ename, sal);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			// 8. �ڿ� �ݳ�
				try {
					if(rs!=null) 
						rs.close();
					if(pstmt != null)
						pstmt.close();
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
}
