package makePainter25c;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CatchMindDAO {
	// ������� DB����
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@orcl.ckyvzseloumz." + "ap-northeast-2.rds.amazonaws.com:1521:orcl";
	String user = "admin";
	String password = "tigertiger";

	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	StringBuffer sb = new StringBuffer();
	CatchMindVO vo;

	// DB������ �����ڿ� �ֱ�
	public CatchMindDAO() {
		// 2. ����
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
//			System.out.println("Connection : " + conn);
//			System.out.println("DB ���� ����");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver ���� ����");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
		}

	}

	// �α��� DB �� �޼���
	public boolean isExists(String userId, String password) {
		// sql��
		sb.setLength(0);
		sb.append("SELECT userId, password ");
		sb.append("FROM catchmind ");
		sb.append("WHERE userId = ? AND password = ? ");

		boolean isOk = false;
		// ���� ��ü ����
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, password);
			// ����
			rs = pstmt.executeQuery();

			// next() �ڷᰡ ������ true �ڷ� ������ false
			isOk = rs.next();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;

	}

	// ȸ������ �ߺ� �� �޼���
	public boolean isExists1(String userId) {
		// sql��
		sb.setLength(0);
		sb.append("SELECT userId ");
		sb.append("From catchmind ");
		sb.append("WHERE userId = ? ");

		boolean isOk = false;
		// ���尴ü ����

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			// ����
			rs = pstmt.executeQuery();

			isOk = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;
	}
	// �г��� �˻�
	public boolean isExists2(String nickName) {
		// sql��
		sb.setLength(0);
		sb.append("SELECT nickName ");
		sb.append("From catchmind ");
		sb.append("WHERE nickName = ? ");

		boolean isOk = false;
		// ���尴ü ����

		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, nickName);
			// ����
			rs = pstmt.executeQuery();

			isOk = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return isOk;
	}
	
	// �г��� �޾ƿ���
		public String selectOneNickname(String userId) {
			String nickname=null;
			// sql��
			sb.setLength(0);
			sb.append("SELECT nickName ");
			sb.append("From catchmind ");
			sb.append("WHERE userid = ? ");
			

			// ���尴ü ����
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, userId);
				// ����
				rs = pstmt.executeQuery();

				rs.next();
				nickname = rs.getString("nickName");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return nickname;
		}
		// ������ ĳ���� Ÿ�� ��������
		public String selectOneMonsterType(String userId) {
			String monsterType = null;
			// sql��
			sb.setLength(0);
			sb.append("SELECT charImage ");
			sb.append("From catchmind ");
			sb.append("WHERE userid = ? ");
			
			
			// ���尴ü ����
			try {
				pstmt = conn.prepareStatement(sb.toString());
				pstmt.setString(1, userId);
				// ����
				rs = pstmt.executeQuery();
				
				rs.next();
				monsterType = rs.getString("charImage");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return monsterType;
		}
	
	// �ܾ� ��ü ��ȸ
	public ArrayList<CatchMindVO> wordSelectAll() {
		ArrayList<CatchMindVO> list = new ArrayList<CatchMindVO>();
		// sql��
		sb.append("SELECT * ");
		sb.append("FROM wordcollection ");
		
		try {
			// ���尴ü ����
			pstmt = conn.prepareStatement(sb.toString());
			
			// ���ఴü ���� 
			rs = pstmt.executeQuery();
			
			// ���ڵ� ó��
			while(rs.next()) {
				String word = rs.getString("word");
//				System.out.println(word);
				// vo�� ��ü ���� �� word ���
				// arraylist�� vo ���� �� ����
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
			

	// ��ü ��ȸ
	public ArrayList<CatchMindVO> selectAll() {

		ArrayList<CatchMindVO> list = new ArrayList<CatchMindVO>();
		CatchMindVO vo = null;
		// sql��
		sb.append("SELECT * ");
		sb.append("FROM catchmind ");

		// ���� ��ü
		try {
			pstmt = conn.prepareStatement(sb.toString());
			// ���๮ ��� resultset�� ���
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int cmNo = rs.getInt("cmNo");
				String userId = rs.getString("userId");
				String password = rs.getString("password");
				String nickName = rs.getString("nickName");
				String charImage = rs.getString("charImage");
				
				// vo��ü ���� ������ ���, ==> list�� ����
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

	// 1ȸ ��ȸ
	public CatchMindVO selectOne(int cmNo) {
		// sql��
		sb.append("SELECT cmNo, userid, password, nickname, charimage ");
		sb.append("FROM catchmind ");
		sb.append("WHERE cmno = ? ");

		// ���尴ü ����
		try {
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, cmNo);
			rs = pstmt.executeQuery();

			// ���ڵ� Ȯ��
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

			// VO��ü ����
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

	// �Է�
	public void insertOne(String userId, String passWord, String nickName, String charImage) {
		// sql��
		sb.setLength(0);
		sb.append("INSERT INTO catchmind ");
		sb.append("VALUES (CATCHMIND_CMNO.NEXTVAL, ?,?,?,?) ");
		try {
			// ���尴ü ����
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, passWord);
			pstmt.setString(3, nickName);
			pstmt.setString(4, charImage);
			System.out.println("DB �Է� ����");
			// ���ఴü ����
			pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // insertOne end
		// ����

	public void updateOne(int cmNo, String userId, String passWord, String nickName, String charImage) {

		// sql��
		sb.setLength(0);
		sb.append("UPDATE catchmind ");
		sb.append("SET userId = ?, passWord = ?, " + "nickName = ? , charImage = ? ");
		sb.append("WHERE cmNo = ? ");

		try {
			// ���� ��ü ����
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, userId);
			pstmt.setString(2, passWord);
			pstmt.setString(3, nickName);
			pstmt.setString(4, charImage);
			pstmt.setInt(5, cmNo);

			// ����
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // updateOne end

	// ����
	public void deleteOne(int cmNo) {
		// sql��
		sb.setLength(0);
		sb.append("DELETE catchmind ");
		sb.append("where cmNo = ? ");

		try {
			// ���尴ü ����
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, cmNo);

			// ����
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	} // deleteone end

} // class end
