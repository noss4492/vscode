package day04;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Deque;

public class baseN {// trans to n-binary number
	static int i = 0;
	static ArrayList<Integer> n = new ArrayList<Integer>();
	//ArrayList를 Dequeue로 바꿔서 다시 만들어보기.
	
	public static ArrayList<Integer> toBaseN(int decNum, int num) {	// should be Recursive
	
		if(decNum >= num) {
			n.add(decNum%num);							// 계속 배열 뒷열에 추가해야함.
			// System.out.println(" ni["+n.size()+"] ="+n.get(i));
			toBaseN(decNum/num, num);
		}
		else{
			n.add(decNum);
			// System.out.println("n"+"i["+i+"] ="+n.get(i));
			for(int i = 0; i < n.size(); i++) {
				//System.out.printf(" %d ", n.get(i));
				return n;
			}
		}
		return n;	//쓰이지 않음. 어떻게 없애버릴 수 없을까?
	}
	
	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("변환할 진법을 입력해주세요 : ");
		int baseNum = stdIn.nextInt();
		
		System.out.println();
		
		System.out.print("변환할 수를 입력해주세요    : ");
		int decNum = stdIn.nextInt();
		stdIn.close();

		System.out.println("입력된 10진수 :"+decNum+"   변환할 진법 :"+baseNum);
		//System.out.println(toBaseN(decNum, baseNum));
		toBaseN(decNum, baseNum);
		
		for(int i = n.size()-1; i >= 0; i--) {
			System.out.print(n.get(i));
		}
		System.out.print("("+baseNum+")");
		
		
	}
}
