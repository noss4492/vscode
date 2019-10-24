package day07;

public class MethodEx3 {
	public static void ex1() {
		int[] m = {23, 53, 22, 11, 66, 77, 88, 29};
		int max = getMaxValue(m);
		System.out.println(m[max]);	//내 방식
		
		int maxValue = getMaxValue2(m);
		System.out.println(maxValue); //수업중
		int maxValuePosition = getMaxValuePosition(m);
		System.out.println(m[maxValuePosition]); //수업중2
		
		// 지역변수는 매서드가 종료할때 같이 소멸되는 변수이지만
		// (호출한 변수에 영향을 미치지는 않지만)
		
		// 하.지.만. (이미 겪어봄.. 배열 복사하면서)
		// 참조값을 전달하면, 참조값을 통해서 변수의 수정이 가능
		
		setMaxValue(m, -100); //이 배열의 최댓값을 -100으로 만들어.
		System.out.println("---------------------");
		maxValue = getMaxValue2(m);
		System.out.println(maxValue);
		
		/*
		 method 호출 방식에 따른 분류
		 call by name      : getMaxValue();
		 call by Value     : getNumber(4);		=> (메인에서의) 값의 수정 불가능
		 call by reference : setMaxValue(m, -100);  => 값의 수정 가능
		 */
	}
	
	public static void setMaxValue(int[] x, int num) {
		// int pos = getMaxValuePosition(x);
		// x[pos] = value;
		x[getMaxValuePosition(x)] = num;	// x[pos] = num;
	}
	public static int getMaxValue2(int[] x) {// 수업 중 방식(개념 이해 때문인듯)
		int maxValue = 0;			
		for(int i = 0; i < x.length; i++) {
			if(maxValue < x[i]) {
				maxValue = x[i];
			}
		}		
		return maxValue;
	}
	public static int getMaxValuePosition(int[] x) {
		//int maxIdx = -1;	//꿀팁 : 0도 배열에 들어있는 애니까 아예 상관없는 값을 써놓자
		int maxValue = 0;
		int pos = -1;
		for(int i = 0; i < x.length; i++) {
			if(maxValue<x[i]) {
				//maxIdx = i; // 내가 썼던 흔적이지.. 
				maxValue=x[i];
				pos = i;
			}
		}
		return pos;
	}
	public static int getMaxValue(int[] m) {// 내가 첨에 만든거임. 일단 배제
		int max = 0;	// max is m[max] : maxValue's index, (수업중 개선점 발견)
		for(int i = 0; i < m.length; i++ ) {
			if(m[max] < m[i])
				max = i;
		}
		return max;
	}
	public static void main(String[] args) {
		ex1();

	}

}
