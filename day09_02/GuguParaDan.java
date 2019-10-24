package day09_02;

public class GuguParaDan {
	int lo, hi;
	GuguParaDan(){
	}
	GuguParaDan(int a, int b){
		this.lo = a;
		this.hi = b;
	}
	
	void print() {
		for(int i = 2; i <= 9; i++) {
			for(int j = this.lo; j<=this.hi; j++)
				System.out.printf("%2d*%2d=%2d",j,i,i*j);
			System.out.println();
		}
	}
}
