package makePainter25c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CatchMindDAO {
	// 멤버변수 DB연결
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@orcl.ckyvzseloumz." + "ap-northeast-2.rds.amazonaws.com:1521:orcl";
	String user = "admin";
	String password = "tigertiger";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();
	CatchMindVO vo;

	// DB연결을 생성자에 넣기
	public CatchMindDAO() {
		// 2. 연결
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("Connection : " + conn);
//			System.out.println("DB 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver 연결 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB 접속 오류");
		}

	}

	// 로그인 DB 비교 메서드
	public boolean isExists(String userId, String password) {
		// sql문
		sb.setLength(0);
		sb.append("SELECT userId, password ");
		sb.append("FROM catchmind ");
		sb.append("WHERE userId = ? AND password = ? ");

		boolean isOk = false;
		// 문장 객체 생성
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			// 실행
			rs = pstmt.executeQuery();

			// next() 자료가 있을시 true 자료 없을시 false
			isOk = rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;

	}

	// 회원가입 중복 비교 메서드
	public boolean isExists1(String userId) {
		// sql문
		sb.setLength(0);
		sb.append("SELECT userId ");
		sb.append("From catchmind ");
		sb.append("WHERE userId = ? ");

		boolean isOk = false;
		// 문장객체 생성

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			// 실행
			rs = pstmt.executeQuery();

			isOk = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;
	}
	// 닉네임 검사
	public boolean isExists2(String nickName) {
		// sql문
		sb.setLength(0);
		sb.append("SELECT nickName ");
		sb.append("From catchmind ");
		sb.append("WHERE nickName = ? ");

		boolean isOk = false;
		// 문장객체 생성

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, nickName);
			// 실행
			rs = pstmt.executeQuery();

			isOk = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;
	}
	
	// 닉네임 받아오기
		public String selectOneNickname(String userId) {
			String nickname=null;
			// sql문
			sb.setLength(0);
			sb.append("SELECT nickName ");
			sb.append("From catchmind ");
			sb.append("WHERE userid = ? ");
			

			// 문장객체 생성
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, userId);
				// 실행
				rs = pstmt.executeQuery();

				rs.next();
				nickname = rs.getString("nickName");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nickname;
		}
		// 유저의 캐릭터 타입 가져오기
		public String selectOneMonsterType(String userId) {
			String monsterType = null;
			// sql문
			sb.setLength(0);
			sb.append("SELECT charImage ");
			sb.append("From catchmind ");
			sb.append("WHERE userid = ? ");
			
			
			// 문장객체 생성
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, userId);
				// 실행
				rs = pstmt.executeQuery();
				
				rs.next();
				monsterType = rs.getString("charImage");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return monsterType;
		}
	
	// 단어 전체 조회
	public ArrayList<CatchMindVO> wordSelectAll() {
		ArrayList<CatchMindVO> list = new ArrayList<CatchMindVO>();
		// sql문
		sb.append("SELECT * ");
		sb.append("FROM wordcollection ");
		
		try {
			// 문장객체 생성
			pstmt = conn.prepareStatement(sb.toString());
			
			// 실행객체 생성 
			rs = pstmt.executeQuery();
			
			// 레코드 처리
			while(rs.next()) {
				String word = rs.getString("word");
//				System.out.println(word);
				// vo에 객체 생성 후 word 담기
				// arraylist에 vo 담은 후 리턴
				vo = new CatchMindVO();
				vo.setWord(word);
				
				list.add(vo);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return list;
		
	}
			

	// 전체 조회
	public ArrayList<CatchMindVO> selectAll() {

		ArrayList<CatchMindVO> list = new ArrayList<CatchMindVO>();
		CatchMindVO vo = null;
		// sql문
		sb.append("SELECT * ");
		sb.append("FROM catchmind ");

		// 문장 객체
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// 실행문 결과 resultset에 담기
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cmNo = rs.getInt("cmNo");
				String userId = rs.getString("userId");
				String password = rs.getString("password");
				String nickName = rs.getString("nickName");
				String charImage = rs.getString("charImage");
				
				// vo객체 생성 데이터 담기, ==> list에 대입
				vo = new CatchMindVO();
				vo.setCmNo(cmNo);
				vo.setUserId(userId);
				vo.setPassWord(password);
				vo.setNickName(nickName);
				vo.setCharImage(charImage);
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	// 1회 조회
	public CatchMindVO selectOne(int cmNo) {
		// sql문
		sb.append("SELECT cmNo, userid, password, nickname, charimage ");
		sb.append("FROM catchmind ");
		sb.append("WHERE cmno = ? ");

		// 문장객체 생성
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, cmNo);
			rs = pstmt.executeQuery();

			// 레코드 확인
			rs.next();
			String userId = rs.getString("userid");
			String password = rs.getString("password");
			String nickName = rs.getString("nickname");
			String charImage = rs.getString("charimage");
			System.out.println(cmNo);
			System.out.println(userId);
			System.out.println(password);
			System.out.println(nickName);
			System.out.println(charImage);

			// VO객체 생성
			vo = new CatchMindVO();
			vo.setCmNo(cmNo);
			vo.setUserId(userId);
			vo.setPassWord(password);
			vo.setNickName(nickName);
			vo.setCharImage(charImage);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

	// 입력
	public void insertOne(String userId, String passWord, String nickName, String charImage) {
		// sql문
		sb.setLength(0);
		sb.append("INSERT INTO catchmind ");
		sb.append("VALUES (CATCHMIND_CMNO.NEXTVAL, ?,?,?,?) ");
		try {
			// 문장객체 생성
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, passWord);
			pstmt.setString(3, nickName);
			pstmt.setString(4, charImage);
			System.out.println("DB 입력 성공");
			// 실행객체 생성
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // insertOne end
		// 변경

	public void updateOne(int cmNo, String userId, String passWord, String nickName, String charImage) {

		// sql문
		sb.setLength(0);
		sb.append("UPDATE catchmind ");
		sb.append("SET userId = ?, passWord = ?, " + "nickName = ? , charImage = ? ");
		sb.append("WHERE cmNo = ? ");

		try {
			// 문장 객체 생성
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, passWord);
			pstmt.setString(3, nickName);
			pstmt.setString(4, charImage);
			pstmt.setInt(5, cmNo);

			// 실행
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // updateOne end

	// 삭제
	public void deleteOne(int cmNo) {
		// sql문
		sb.setLength(0);
		sb.append("DELETE catchmind ");
		sb.append("where cmNo = ? ");

		try {
			// 문장객체 생성
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, cmNo);

			// 실행
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // deleteone end

} // class end
