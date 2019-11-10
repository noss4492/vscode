package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.RoomsixVO;

public class RoomsixDAO {
	//1. ���� ����
	//2. JDBC ����̹��� �ε� �Ǿ� �ִ��� üũ�Ѵ�
	//3. DB�� ������ �Ѵ�.(Connection)
	//4. SQL���� �ۼ�
	//5. ���� ��ü�� �����ϰ�
	//6. ����(Select ==> ResultSet)
	//7. �� �ߴٸ� ���ڵ庰�� ���� �ϰ���� ó���� �Ѵ�.
	//8. �� ��ٸ� �ڿ��� �ݳ�����.

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
	String user = "scott";
	String password = "tiger";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();

	public RoomsixDAO(){
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			System.out.println("driver �ε� ����");
		} catch (SQLException e) {
			System.out.println("drivermanager�� ���ῡ ��������");
		}
	}
	public boolean isExists(String id, String pw) {
		boolean isOK = false;
//		sb = new StringBuffer();
//		System.out.println("aaaaaaaaaaaa");
		sb.setLength(0);
		sb.append("SELECT id, ename, pwd ");
		sb.append("FROM roomsix ");
		sb.append("WHERE id = ? and pwd = ? ");
		// �α��ν� �ʿ��� ���� ����
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			isOK = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		return false;
		return isOK;
	}
	
	public void insertOne(String id, String name, String pwd, String gender, String cause){
		sb.setLength(0);
		sb.append("INSERT INTO ROOMSIX ");
		sb.append("VALUES ( ? , ? , ? , ? , ? )");
		
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, pwd);
			pstmt.setString(4, gender);
			pstmt.setString(5, cause);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL���� �߸� �Ǿ���");
		}
	}
	
	public void close() {
		try {
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
