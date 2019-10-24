package day03;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Deque;

public class BaseNProcessInStudy {		// 공부 후 정리해서 표현할 예정임.
	public static void BaseN() {	// trans to n-binary number
			//generic
		//
	}
	
	public static void toBaseN(int decNum, int num) {	// should be Recursive
		// # 변경점. 이 클래스는 반환값이 없어야 함을 알게됨 -> 지금 재귀적으로 사용할 목적을 가지고 있음.
		
		ArrayList<Integer> n = new ArrayList<Integer>();
		//ArrayList<Integer> n = new ArrayList<Integer>();
		// int n[] = new int[];		이걸 어떻게 명시를 없애고 동적인 크기로 만들지?
		// # 변경점. 배열 -> 리스트 자료형. 리스트 자료형으로 동적 크기의 배열을 만들 수 있음.
		
		// 역순으로 꺼내보아야함. 스택을 사용한 다음 꺼내면 역순 출력 되기 때문에 이를 이용하도록 함.
		// # 변경점. 리스트 자료형 -> 스택 자료형
		
		
		// 자바에서는 스택 자료형보다는 일관성 유지를 위해 덱 자료형을 사용하는 것을 권장하고 있다고 함.
		// # 변경점. 스택 자료형 -> 덱 자료형
		
		// ArrayDeque<Integer> n =new ArrayDeque<Integer>();
		int i = 0;	// 밑에 두 경우 모두 선언을 알고 있어야 하기 때문에 여기서 선언함.
		
		if(decNum >= num) {
			n.add(decNum%num);							// 계속 배열 뒷열에 추가해야함.
			System.out.println("n"+"i["+n.size()+"] ="+n.get(i));
			// i++;	i++가 정상적으로 동작하고 있지는 않음.
			// #변경점  어차피 리스트로 바꿔서 필요없음.
			toBaseN(decNum/num, num);
		}
		else{
			n.add(decNum%num);
			System.out.println("n"+"i["+i+"] ="+n.get(i));
			for(int j = 0; j < n.size(); j++) {
				System.out.printf("%d", n.get(i));
				System.out.println("\n---|e|n|d|---");	
				System.out.println("[test]"+n.size());
			}
		}
		// decNum을 n으로 나누고 나누고 나누고 나누고 나누고 나누고 하는 과정이니까 
		//
		// 300 -> n진법으로 가능 과정을 생각해본다. 
		// 300 / n -> 나머지
		// 300 / n*n -> 나머지
		// 300 / n*n*n -> 나머지		
	}
	
	public static void main(String[] args) {
		// ArrayList<String> arrN = new ArrayList<String>();	
		// arrN is contained baesN's strings
		
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("변환할 진법을 입력해주세요 : ");
		int baseNum = stdIn.nextInt();
		
		System.out.println();
		
		System.out.print("변환할 수를 입력해주세요    : ");
		int decNum = stdIn.nextInt();
		stdIn.close();

		System.out.println("입력된 10진수 :"+decNum+"   변환할 진법 :"+baseNum);
		toBaseN(decNum, baseNum);
		
		
	}

}
