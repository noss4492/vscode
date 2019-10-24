package day04;
import java.util.ArrayList;
import java.util.Scanner;

// 이거를 조금 더 조정해서 클래스로 만들어보기.

public class VendingMachine {

	static int won = 0;
	static int cnt2 = 0;
	
	// 조금만 더..
	//System.out.printf("1. n: %-8d, m:%-8d, cnt:%-3d w:%-5d\n",n, m, cnt2, cm.get(cnt));
	//System.out.printf("2. n: %-8d, m:%-8d, cnt:%-3d w:%-5d\n",n, m, cnt2, cm.get(cnt));
	//System.out.printf("3. n: %-8d, m:%-8d, cnt:%-3d w:%-5d\n",n, m, cnt2, cm.get(cnt));
	/*
	static void printTest(int n, int m, int cnt, int a[]) {
		System.out.printf("0. n: %-8d, m:%-8d, cnt:%-3d w:%-5d\n",n, m, cnt2, cm.get(cnt));
	}*/
	
	
	static ArrayList<Integer> cm = new ArrayList<Integer>();
	static ArrayList<Integer> changeMoney(int won, int n, int m, int cnt) {
		if(m<=0) {	// 안에 값을 확인해보려면 주석 해제
			cm.add(won%n);
			//
			return cm;
		}
		if( cnt2 == 0) {		//이게 왜 두번 실행될까?.... -> 1번으로 고정시키는게.. 
			cm.add(won/50000);
						changeMoney(won, n, m, cnt2++);
		}
		else if( cnt2 % 2 == 1) {
			cm.add(won%n/m);
						changeMoney(won, n/5, m/2, cnt2++);
		}
		else{//if( cnt2 % 2 == 0) {
			cm.add(won%n/m);
						changeMoney(won, n/2, m/5, cnt2++);
		}
		return cm;
	}
	
	public static void main(String[] args) {
		System.out.println("--------- 음료 자판기 ---------");
		System.out.printf("--   %2d. %4s : %5d원     --\n", 1, "콜라", 2500);
		System.out.printf("--   %2d. %4s : %5d원     --\n", 2, "사이다", 1800);
		System.out.printf("--   %2d. %4s : %5d원     --\n", 3, "환타", 2200);
		System.out.printf("--   %2d. %4s : %5d원     --\n", 4, "테로", 4000);
		System.out.printf("--   %2d. %4s : %5d원     --\n", 5, "쏘주", 3500);
		System.out.println("---------------------------");
		
		System.out.print("지폐를 넣으세요 : ");
		Scanner sc = new Scanner(System.in);
		int money = sc.nextInt();
		System.out.print("음료 선택 해주세요 : ");
		int choice = sc.nextInt();
		
		System.out.print("수량 선택 해주세요");
		int cnt = sc.nextInt();
		sc.close();
		
		System.out.println(cnt+"개를 선택하셨습니다.");
		
		int price = 0;
		
		if(choice == 1) price = 2500;
		else if(choice == 2) price = 1800;
		else if(choice == 3) price = 2200;
		else if(choice == 4) price = 4000;
		else if(choice == 5) price = 3500;
		
		int expPrice = price*cnt;	//제품가격 합계

		System.out.println("제품 가격       : "+price);
		System.out.println("예상 제품 가격 : "+expPrice);

		if( money >= expPrice) {
			ArrayList<Integer> n = new ArrayList<Integer>();
			n = changeMoney(money-expPrice, 50000, 10000, 0);
			
			System.out.println(choice + "번 상품 " + cnt+"개");
			System.out.println("잔액은 :" + (money-expPrice));
			
			int c1 = 1;
			e:
			for(int i = 10; i >= 1; i--) {	// 볼 수 있게 표시해주기 10 = n.size()-1
				if(i%2==0) {
					if(n.get(i-1)==0) {
						c1 *= 5;
						continue e;
					}
					System.out.print(c1+"원 매수 : "+n.get(i-1)+"\n");	
					c1 = c1*5;
				}
				else {
					if(n.get(i-1)==0) {
						c1 *= 2;
						continue e;
					}
					System.out.print(c1+"원 매수 : "+n.get(i-1)+"\n");	
					c1 = c1*2;				
				}
			}
			
		}
		else {
			System.out.println("잔액 부족");
			System.out.println("반환금"+money);
		}

		
	}
}

/*		클래스를 만들어서 테이블 형식으로 정의 할 수 있을 것임. (나중에 연습)
class menu{
	ArrayList<Integer> menu = new ArrayList<Integer>();
	int num;
	String name;
	int price;
	menu(int num, String name, int price){
		this.num = num;
		this.name = name;
		this.price = price;
	}
}*/

