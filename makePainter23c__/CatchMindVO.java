package makePainter23c__;

public class CatchMindVO {
	int cmNo;
	String userId;
	String passWord;
	String nickName;
	String charImage;
	String word;
	
	// 기본 생성자
	public CatchMindVO() {
	}

	// 매개변수 생성자
	public CatchMindVO(int cmNo, 
			String userId, String passWord, 
			String nickName, String charImage, 
			String word) {
		
		super();
		this.cmNo = cmNo;
		this.userId = userId;
		this.passWord = passWord;
		this.nickName = nickName;
		this.charImage = charImage;
		this.word = word;
	}

	//setter, getter
	public int getCmNo() {
		return cmNo;
	}

	public void setCmNo(int cmNo) {
		this.cmNo = cmNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getCharImage() {
		return charImage;
	}

	public void setCharImage(String charImage) {
		this.charImage = charImage;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}
	
	
	
	
}
