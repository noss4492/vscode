package day09_02;

public class GuguDan {
	int dan;
	
	GuguDan(){
		dan = 2;
	}
	GuguDan(int dan){
		this();// 비어 있으면 안되는 무조건 적으로 채워져야 하는 곳이니까
		this.dan = dan;
		//dan = a  // parameter(int a)로 지정하면 this 명시 안해도
	}
	
	void print() {
		for(int i = 1; i <= 9; i++) {
			System.out.printf("%2d*%2d=%2d\n", dan, i, i);
		}
	}

}
