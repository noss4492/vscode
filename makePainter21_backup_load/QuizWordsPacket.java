package makePainter21_backup_load;

import java.io.Serializable;

public class QuizWordsPacket implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 17892204L;
	String ansWord;

	public QuizWordsPacket(String ansWord) {
		super();
		this.ansWord = ansWord;
	}

	public String getAnsWord() {
		return ansWord;
	}

	public void setAnsWord(String ansWord) {
		this.ansWord = ansWord;
	}

}
