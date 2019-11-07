package day20_InMyMind;

import java.awt.Dialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// ���� �� ���� �ϱ⿡�� ������ �ִ�... �ϴٰ� ������ �ּ��� ���� ��������.
//1. ���� ���� ����
//2. JDBC ����̹��� �ε� �Ǿ� �ִ��� üũ�Ѵ� ����
//3. DB�� ������ �Ѵ�.(Connection) ����
//4. SQL���� �ۼ�
//5. ���� ��ü�� �����ϰ�
//6. ����(Select ==> ResultSet)
//7. �� �ߴٸ� ���ڵ庰�� ���� �ϰ���� ó���� �Ѵ�.
//8. �� ��ٸ� �ڿ��� �ݳ�����.

public class UserInsert {
	String uPw;
	String uName;
	String uGender;
	String uMot;
	static String uid;
	static String[] allUsersId = null;
	
	public UserInsert(String uid, String uPw, String uName, String uGender, String uMot) {
		this.uid = uid;
		this.uPw = uPw;
		this.uName = uName;
		this.uGender = uGender;
		this.uMot = uMot;
	}

	public static void main(String[] args) {
		// ���� ����
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		String user = "scott";
		String pw = "tiger";

		Connection conn = null;
		// JDBC API ����̹��� Ŭ������ �ö���ִ��� (JDBC �ε� üũ)
		// DB�� �����ϱ�
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC �ε� ����");
		} catch (SQLException e) {
			System.out.println("DriverManager�� Ŀ�ؼǿ� ������. url,user,pw Ȯ����");
		}
		
		// ó������ ���۵� SQL���� �ϴ� �������̺��� ��ȸ�ؼ� ID�� �о���� ���� �ʿ���.
		// ID �ߺ� ó���Ϸ��� �����͸� �޾ƿ�.
		StringBuffer sbUserIdRead = new StringBuffer();
		sbUserIdRead.append("SELECT * ");
		sbUserIdRead.append("FROM ROOMSIX ");
		
		PreparedStatement pstmtR = null;
		ResultSet rsR = null;
		int cnt = 0;
		
		try {
			pstmtR = conn.prepareStatement(sbUserIdRead.toString());
			rsR = pstmtR.executeQuery();	// ��� ���� ���̵� ������
			while(rsR.next()) {
				allUsersId[cnt++] = rsR.getString("ID");
			}
		} catch (SQLException e1) {
			System.out.println("[����ID��ȸ �õ�],SQL���� �ȹٷ� ���ÿ�.");
		}
		//this.uid�� allUsersId ���ؼ� ��ȸ
		for(int i = 0; i < allUsersId.length; i++) {
			if(uid.equalsIgnoreCase(allUsersId[i])) {
				// ���̾�α׸� ���� �����ư ������ â ��������.
			}
		}
		
		
		
		
		// SQL���� �ۼ��ϰ�
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ROOMSIX ");
		sb.append("VALUE( ? , ? , ? , ? , ? ) ");
		//5. ���� ��ü�� �����ϰ�
		//6. ����(Select ==> ResultSet)
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		String uid = 
		try {
			// (������ �� �ܰ�) preparedStatement�� �غ�
			pstmt = conn.prepareStatement(sb.toString());
			// injection�� �Ұ����ϵ���, junct�� JC������ �б������� ���ԵǴ� �׷� �ǹ̰� ����
			
			// �̸� �޾Ƽ� ������
			
			pstmt.setString(1, "id");
			pstmt.setString(2, "pw");
			pstmt.setString(3, "name");
//			pstmt.setString(4, "��":"��");
			pstmt.setString(5, "mot");
			rs = pstmt.executeQuery();
			
			
			
			// ���� rs.getString("id");�ؼ� ������ id���� ��ȸ�ߴµ�
			// �Ȱ��� ���̵� �ִٸ� �ȵȴٰ� �ϴ� ���̾�α׸� �����Ѵ�.
			
			// ���� ������� 
			// 7. �� �ߴٸ� ���ڵ庰�� ���� �ϰ���� ó���� �Ѵ�.
			// �ٵ� insert�� �ϸ� �����ݾ�? �� ���� ����.
			// �Ѵٰ� �ص� ���̾�α� ���� ���� ?
			
		} catch (SQLException e) {
			System.out.println("SQL�� �ȹٷ� ���ÿ�");
		}
		//8. �� ��ٸ� �ڿ��� �ݳ�����.
//		if
	}
}
