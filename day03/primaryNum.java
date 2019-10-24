package day03;

import java.util.Scanner;

/*
public class primaryNum {
	public class checkPriNum(int pnum) {
	}
	public static boolean JudgePri() {
	}
	public static void main(String[] args) {
	}
}

*/
/*
public class checkPriNum(int pnum) {
	public static boolean JudgePri() {
		static boolean checkPrime(int n) {
			if(n == 2)
				return true;
			if(n=3; n * n <= n; n+=2) {
				return 
			}
			return true;
		}
		
		static long soultion(int n, )
		
		
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		int pnum;
		do{		//1937777 it is prime number
			System.out.print("검사할 수를 입력해주세요 :");
			Scanner stdIn = new Scanner(System.in);
			pnum = stdIn.nextInt();
		}while(pnum >= 2);
		
		checkPriNum(pnum);
		

	}

}
*/
// from C++
/*

long long solution(int N) {     // N <=  10,000,000
	long long answer = 2;
	bool *p = new bool[N];
	bool a;

	for (int i = 0; i < N; i++) { //占쏙옙占쏙옙占썼열 占십깍옙화 , 占쏙옙占쏙옙占쏙옙 占쏙옙 占써도 占실놂옙
		if (i % 2 == 0) {
			p[i] == false;
		}
		p[i] = true;
	}

	if (N == 2) {           // 2 특占쏙옙占쏙옙占싱쏙옙
		answer = 2;
	}

	for (int i = 3; i < N + 1; i += 2) {
		if (p[i] == false) {		//占쌀쇽옙占쏙옙 占싣니몌옙 占쏙옙占쏙옙
			continue;
		}
		else {										  //占쌀쇽옙占싹곤옙占심쇽옙
			if (check_prime(i) == true) {             // 占쏙옙짜 占쌀쇽옙占쏙옙
				answer += i;
				for (int j = 2; j<int(N / i); j++) {  //占쌀쇽옙占쏙옙 占쏙옙占쏙옙占� flag off
					p[i * j] = false;
					if (j * j > N)
						break;
				}
			}
			else                                      //占싣니몌옙 占쏙옙占쏙옙占싹깍옙占쏙옙占쏙옙 flag off
				p[i] = false;
		}
	}
	delete[] p;
	return answer;
}

for(int i = 2; i < Math.sqrt(pnum); i++) {
			if(pnum % i == 0) {
				System.out.println("占싣아아억옙");
			}
		}
		
*/
		
		
		



// 占쏙옙占쏙옙占썰스占쌓네쏙옙占쏙옙 체占쏙옙 占쏙옙占쏙옙 占실깍옙 占쏙옙
		// 占쌓뤄옙占쏙옙 占쏙옙占쏙옙 占쌨몌옙占쏙옙 占싹는곤옙 占쌔븝옙占쏙옙 占쏙옙占쏙옙
		// 占싹댐옙占쏙옙 占쏙옙..
		/*
		public static boolean IsPrimeStack() {
			//static vector<int> p(0);
		    //for(int i=2; i*i<num+1; i++){	
		    // 占쏙옙占쌓몌옙 占쏙옙占쏙옙	ArrayList<String> aList = new ArrayList<String>();
			ArrayList<Integer> PriStack = new ArrayList<Integer>();
			
			
		}
		*/
		
