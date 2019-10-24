package day04;

public class BreakContinue {
	// break 		// 가장 가까운 반복문 탈출
	// 가장 가까운 끝점 종료
	// continue 	// 이번만 생략
	// 가장 가까운 블록의 시작점으로 점프
	
	// break 라벨		// 라벨이 붙어있는 반복문에서 탈출
	// 블록의 끝점 종료
	// continue 라벨	// 라벨이 붙어있는 반복문에서 이번만 생략
	// 블록의 시작점으로 점프

	
	public static void main(String[] args) {
		
		//라벨 주기, goto같이 생겼네 흐으으음...
		outer:
		for(int j=1; j<=4; j++) {
			for(int i=1; i<=4; i++) {
				if(i==j) continue outer;
				//if(i==j) break outer; 이러면 차이 알 수 있음
			System.out.println(" i : "+ i +" j : "+j);
			}
		}
	}
}
