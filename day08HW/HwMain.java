package day08HW;

public class HwMain {

	public static void main(String[] args) {
		//hw1
		Man Hong = new Man("홍길동", 2, "남", 2, 20, "도적", "스틸");
		Hong.steal();
		Hong.run();
		Hong.fastrun();
		Hong.chookJiBubb();
		
		//hw2
		MulTable MulAtoB = new MulTable(1, 9);	//1단부터 9단
		System.out.println();
		MulTable MulN = new MulTable(5);		//5단만
		//문제 좀 대충 읽지 말고 다시 읽고 다시 풀자. ;;ㅅ;;...
		System.out.println();
		
		MulTable g1 = new MulTable();	//요게 숙제에서 원한 것
		g1.dan = 5;
		g1.mulPrint();
		System.out.println();
		
		/*
		hw3
		 class는 실체화 되지 않은 개념으로 볼 수 있고 (설계도)
		 object는 실체화 된(인스턴스화 된, 메모리에 실제로 할당이 된) 
		                    것으로 볼 수 있다.(설계도로 만든 것)
		
		hw4 
		 class를 구성하는 3 요소는 
		 멤버(힙같은거나 자식노드단에서 멤버 따질때의 멤버와 같은 개념일듯)
		 member Field(member variable + ...)
		 constructor(최소1, 없으면 자동 gen)
		 member method
		
		
		hw5
		Method Overloading이란?
		자바에서는 프로그램을 실행하면서 메소드를 호출해야할 때 어떤 메소드를 호출할 지를 정해야한다.
		그 때 같은 메소드명(다중정의)을 허용함으로써 같은 메소드명일시 구분하는 시그니쳐로는
		시그니쳐(같은 메소드명일때 매개변수(parameter)의 갯수, 순서, 형(type))로 판단한다.
		
		hw6
		call by name (파라메타 없이 호출)
		call by value (값을 넣어 호출)
		call by reference (참조값을 받아서 호출)
		
		*/
		
		//hw7
		int a = 20;
		int[] b = {10, 20, 50, 30};
		float f = 240.3f;
		
		FormatData fd = new FormatData();
		fd.print(a);
		fd.print(b);
		fd.print(f);
		
		//hw8
		//marin - atk -> ghost
		//medic - heal -> ghost
		//ghost -> 마린,메딕,고스트
		//nuclear
		
		//hw9
		//siegeMode()
		
	}
	
	public static class MulTable{
		int dan;
		MulTable(){				//이것이 문제에서 원한 조건이었음
		}
		MulTable(int a, int b){	// 그냥 a단부터 b단까지
			for(int j = 1; j <= 9; j++) {
				for(int i = a; i <= b; i++)
					System.out.printf("[%1d]*[%1d]=[%2d] ", i, j, i*j);
				System.out.println();
			}
		}
		MulTable(int c){		// c단 출력
			for(int j = 1; j <= 9; j++)
				System.out.printf("[%1d]*[%1d]=[%2d]\n", c, j, c*j);
		}		
		void mulPrint() {
			for(int i = 1; i <= 9; i++)
				System.out.printf("[%1d]*[%1d]=[%2d]\n", dan, i, this.dan*i);
		}
	}
}
