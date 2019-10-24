package day04;

public class arrayEx4 {
	// 일반적인 프리미티브 타입의 변수는 스택에 할당됨.
	// 레퍼런스 타입의 변수는 힙에 할당됨(동적할당시라고 알고 있었는데 흠)
	// *힙에 할당된 주소를 스택의 변수(int type)가 가지고 있음.
	// *스택에서 할당된 레퍼런스 타입의 변수에 대한  주소(참조값)을 가지고 있음
	
	// primitive type : 8개 ㅇ
	// reference type : array, ....
	
	// [4][4] 배열이라 가정하고 [0][3]뒤에 오는 메모리 주소는 [1][0]과 연속되지 않을 수 있음.
	// 초기화시 {1,2,3,4,} 이런 식으로 추가 쉼표로 

	public static void main(String[] args) {
		int [] m;
		// 자료형[] 변수명;
		// 자료형 변수명 [];
		
		//참조값 확인. 스택영역 할당된 m은 힙영역에 할당된 레퍼런스타입 변수의 주소(참조값)을 가지고 있다.
		System.out.println("------첫번째, 배열이 지시하고 있는 참조값의 확인------");
		m = new int[3];
		for(int i=0; i<3; i++)
			System.out.println(m);	
		
		System.out.println("------두번째------");
		int[] mm = {5, 10, 15, 20, 25};
		for(int i=0; i<5; i++) {
			System.out.println(mm[i]);
		}
		//System.out.println("스택에서 참조하고 있는 주소(참조값) :"+mm);
		
		System.out.println("------세번째------");
		int[] c;
		c = new int[5];
		for(int i=0; i<c.length; i++) {
			c[i] = (i+1)*5;
			System.out.println("c["+i+"] : "+c[i]);	
		}
		///////////////////////////////////////////////////////
		System.out.println("------세번째(확장for문)------");
		for(int i : mm)
			System.out.println(i);
		///////////////////////////////////////////////////////
		System.out.println("------네번째------");
		int[] cc = {1,3,5,7,9,11,13};
		for(int ixi : cc)				// 확장 for문 방식
			System.out.print(ixi+"\t");
		System.out.println("||");
		
										// 초기값 지정
		for(int i = 0; i < cc.length; i++)
			System.out.print(cc[i]+"\t");
		System.out.println("||");
		
		
		int [] dd = new int[7];		// for문에서 배열에 대입하여 채움
		for(int i=0; i<dd.length; i++) {
			dd[i] = 1+i*2;
			System.out.print(dd[i]+"\t");
		}
		System.out.println("||");
		///////////////////////////////////////////////////////
		//int[] ed;						
		//ed = new int[7];
		//int [] = new int[7]; 일케 붙여 쓸 수 이슴
	}
}
