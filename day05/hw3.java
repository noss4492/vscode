package day05;

import java.util.Scanner;

public class hw3 {
	public static void main(String[] args) {
		int[][] a = {{3,2,3},{4,5,6},{1,4,9}};		//hw3
		int[][] b = {{1,8,7},{6,4,4},{3,2,3}};
		int[][] c = new int[a.length][a[0].length];
		
		for(int i = 0; i <a.length; i++)	//a.length*a[0].length elements
			for(int j = 0; j < a[0].length; j++)
				c[i][j] = a[i][j] + b[i][j];
		
		int n = 1;							//hw4
		int[][] d = new int[5][5];
		for(int i = 0; i < d.length; i++) {
			for(int j = 0; j < d[0].length; j++) {
				d[i][j]=n++;
				System.out.printf(" %2d ",d[i][j]);
			}
			System.out.println();
		}
		
		
		//hw5
		Scanner sc = new Scanner(System.in);	// 45, 40, 100.... input
		
		/*
		int[] f = new int[10];
		int sum = 0;
		System.out.println("↓↓↓↓0~100 정수 10개 입력 ↓↓↓↓");
		for(int i = 0; i < 10; i++) {
			f[i] = sc.nextInt();
			sum += f[i];
		}
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+sum/f.length);
		
		n = 1;
		//hw6
		int[] e = new int[100];
		for(int i = 0; i < 100; i++)
			e[i] = n++;
		
		//hw7	Hw06에서 3의 배수는 3333 5의 배수는 5555 3과 5의 공배수는 3535를 대입
		int x = 0;
		for(int i = 0; i < 100; i++) {
			if(e[i]%3==0&&e[i]%5==0)
				e[i]=3535;
			else if(e[i]%3==0)
				e[i]=3333;
			else if(e[i]%5==0)
				e[i]=5555;
		}
		
		int[] g = new int [10];
		//hw8
		for(int i = 0; i < 10; i++) {
			g[i] = sc.nextInt();
			if(g[i]%3==0)
				System.out.println("g["+i+"]"+"3의 배수 : "+g[i]);
		}
		//hw9
		int[] h = {10, 50, 60, 30, 12};
		int idx = 0;
		while(idx<5) {
			if(h[idx] == 50)
				System.out.println(h[idx++]);
		}
		
		//hw10
		int[] bb = new int [10];
		for(int i = 0; i < 10; i++) {
			if(i==7)
				continue;
			bb[i] = twoCip();			
		}
		/*
		//hw11
		// 20 15 30 100 99 21 11
		int[] cc = {20, 15, 30, 100, 99, 21, 11};
		System.out.println("변경 원하는 배열 인덱스 입력 하시오");
		int hoIdx = sc.nextInt();
		cc[hoIdx] = (int)(Math.random()*1000)+1;
		
		for(int i = 0; i < 7; i++)
			System.out.println(cc[i]);
		*/
		
		
		
		
		//hw12
		//10칸짜리 정수형 배열 rnd에 랜덤값 할당. 최대값 최소값 출력
		
		int[] dd = new int[10];
		int max = 0;
		int min = 0;
		
		System.out.println("랜덤으로 10개 생성(1~100)");
		for(int i = 0; i < 10; i++) {
			dd[i] = (int)(Math.random()*100)+1;
			System.out.println(dd[i]);
		}
		
		int tmp3 = dd[0];
		
		for(int i = 0; i < 10; i ++) {	// ㅠ.ㅠ 넘나 비효율적인 것.
			for(int j =0; j < i; j++)
			if(dd[i]>dd[j]) {	//dd[i] swap dd[j]
				tmp3 = dd[i];
				dd[i] = dd[j];
				dd[j] = tmp3;
			}
		}
		System.out.println("----------------");
		for(int i = 0; i < 10; i++) {
			System.out.println(dd[i]);
		}
		max = dd[0];
		min = dd[9];
		System.out.println("max :"+max);
		System.out.println("min :"+min);
		
		//hw13
		int[] ee = new int['Z'-'A'+1];
		
		ee[0]=(int)'A';
		System.out.println(ee[0]);
		
		for(int i = 0; i < 'Z'-'A'+1; i++) {
			ee[i]=ee[0]+i;
		}
		
		for(int tmp : ee)
			System.out.print((char)tmp+"");
		System.out.println();
		System.out.println("---------------");
		
		//hw14
		//'A' is lower than 'Z'
		//bubble bubble, 파도타기 ㄱㄱ
		
		int tmp4 = ee[0];
		for(int i = 25; i>=0; i--) {
			for(int j = 0; j < i; j++) {
				if(ee[i]>ee[j]) {
					tmp4 = ee[i];
					ee[i]=ee[j];
					ee[j]=tmp4;
				}
					
			}
		}
		
		for(int tmp : ee)
			System.out.print((char)tmp+"");
		
		
			// 비교 순서 생각
			// 어느쪽으로 밀 것인가? -> 큰 수가 앞에 오게 해야 문자 내림차순으로 
			//  24 까지 탐색(25 자신은 안 봐도 되니까)
			//			  - - - - > 최소 값 최우측
			//     0 25
			//     1 25
			//     2 25
			//     .....
			//  23 까지  탐색- - - - > 최소에서 두번째 값 최우측에서 두번째로
			//     0 24
			//     1 24
			// .........  완전 검색하는건 결국 똑같네.. hmm..
			
		
		
		
		
		
		
		
	}
	
	static int twoCip() {
		int aa = 0;
		while(true) {
			aa = (int)(Math.random()*100)%100;
			if(aa<100 && aa>9)
				break;
		}
		return aa;
	}
}
