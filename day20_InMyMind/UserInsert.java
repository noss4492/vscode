package day20_InMyMind;

import java.awt.Dialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// 아직 안 보고 하기에는 무리가 있다... 하다가 막히면 주석을 보고 참고하자.
//1. 변수 선언 ㅇㅋ
//2. JDBC 드라이버가 로딩 되어 있는지 체크한다 ㅇㅋ
//3. DB에 연결을 한다.(Connection) ㅇㅋ
//4. SQL문을 작성
//5. 문장 객체를 생성하고
//6. 실행(Select ==> ResultSet)
//7. 다 했다면 레코드별로 내가 하고싶은 처리를 한다.
//8. 다 썼다면 자원을 반납하자.

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
		// 변수 선언
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.35:1521:orcl";
		String user = "scott";
		String pw = "tiger";

		Connection conn = null;
		// JDBC API 드라이버가 클래스로 올라와있는지 (JDBC 로딩 체크)
		// DB에 연결하기
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DriverManager가 커넥션에 실패함. url,user,pw 확인좀");
		}
		
		// 처음으로 동작될 SQL문은 일단 유저테이블을 조회해서 ID를 읽어오는 것이 필요함.
		// ID 중복 처리하려고 데이터를 받아옴.
		StringBuffer sbUserIdRead = new StringBuffer();
		sbUserIdRead.append("SELECT * ");
		sbUserIdRead.append("FROM ROOMSIX ");
		
		PreparedStatement pstmtR = null;
		ResultSet rsR = null;
		int cnt = 0;
		
		try {
			pstmtR = conn.prepareStatement(sbUserIdRead.toString());
			rsR = pstmtR.executeQuery();	// 모든 유저 아이디 가져옴
			while(rsR.next()) {
				allUsersId[cnt++] = rsR.getString("ID");
			}
		} catch (SQLException e1) {
			System.out.println("[유저ID조회 시도],SQL문을 똑바로 쓰시오.");
		}
		//this.uid와 allUsersId 비교해서 조회
		for(int i = 0; i < allUsersId.length; i++) {
			if(uid.equalsIgnoreCase(allUsersId[i])) {
				// 다이얼로그를 띄우고 종료버튼 누르면 창 종료해줌.
			}
		}
		
		
		
		
		// SQL문을 작성하고
		StringBuffer sb = new StringBuffer();
		sb.append("INSERT INTO ROOMSIX ");
		sb.append("VALUE( ? , ? , ? , ? , ? ) ");
		//5. 문장 객체를 생성하고
		//6. 실행(Select ==> ResultSet)
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
//		String uid = 
		try {
			// (컴파일 전 단계) preparedStatement를 준비
			pstmt = conn.prepareStatement(sb.toString());
			// injection이 불가능하도록, junct는 JC에서의 분기점에서 삽입되는 그런 의미가 있음
			
			// 미리 받아서 만들자
			
			pstmt.setString(1, "id");
			pstmt.setString(2, "pw");
			pstmt.setString(3, "name");
//			pstmt.setString(4, "남":"여");
			pstmt.setString(5, "mot");
			rs = pstmt.executeQuery();
			
			
			
			// 만약 rs.getString("id");해서 가져온 id값을 조회했는데
			// 똑같은 아이디가 있다면 안된다고 하는 다이얼로그를 생성한다.
			
			// 이제 내맘대로 
			// 7. 다 했다면 레코드별로 내가 하고싶은 처리를 한다.
			// 근데 insert만 하면 끝이잖아? 할 일이 없다.
			// 한다고 해도 다이얼로그 생성 정도 ?
			
		} catch (SQLException e) {
			System.out.println("SQL을 똑바로 쓰시오");
		}
		//8. 다 썼다면 자원을 반납하자.
//		if
	}
}
