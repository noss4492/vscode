package day04;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Deque;

public class baseN {// trans to n-binary number
	static int i = 0;
	static ArrayList<Integer> n = new ArrayList<Integer>();
	//ArrayList�� Dequeue�� �ٲ㼭 �ٽ� ������.
	
	public static ArrayList<Integer> toBaseN(int decNum, int num) {	// should be Recursive
	
		if(decNum >= num) {
			n.add(decNum%num);							// ��� �迭 �޿��� �߰��ؾ���.
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
		return n;	//������ ����. ��� ���ֹ��� �� ������?
	}
	
	public static void main(String[] args) {
		
		Scanner stdIn = new Scanner(System.in);
		
		System.out.print("��ȯ�� ������ �Է����ּ��� : ");
		int baseNum = stdIn.nextInt();
		
		System.out.println();
		
		System.out.print("��ȯ�� ���� �Է����ּ���    : ");
		int decNum = stdIn.nextInt();
		stdIn.close();

		System.out.println("�Էµ� 10���� :"+decNum+"   ��ȯ�� ���� :"+baseNum);
		//System.out.println(toBaseN(decNum, baseNum));
		toBaseN(decNum, baseNum);
		
		for(int i = n.size()-1; i >= 0; i--) {
			System.out.print(n.get(i));
		}
		System.out.print("("+baseNum+")");
		
		
	}
}
