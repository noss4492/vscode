package day09_02;

public class GuguDan {
	int dan;
	
	GuguDan(){
		dan = 2;
	}
	GuguDan(int dan){
		this();// ��� ������ �ȵǴ� ������ ������ ä������ �ϴ� ���̴ϱ�
		this.dan = dan;
		//dan = a  // parameter(int a)�� �����ϸ� this ��� ���ص�
	}
	
	void print() {
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%2d*%2d=%2d\n", dan, i, i);
		}
	}

}
