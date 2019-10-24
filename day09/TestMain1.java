package day09;

//import day08preImplements.Marin;
//import day08preImplements.*;

// reference type : Array, Class (사용자 정의형 타입)
// 기본적으로 클래스 탐색 범위는 현재 패키지 내에서만 탐색.

// 용어
// 멤버변수 멤버필드 < 전역변수
// 매개변수 < 지역변수

// 자바는 가장 가까운 변수를 가르키는 특성이 있어서
// Marine(int hp, int x, int y){
// hp = hp    // 앞의 hp는 가장 가까운 위에 int hp의 hp를 가르킴
// this로 직접 명시해주거나 다른 매개변수명으로 받을 것.

public class TestMain1 {
	public static void main(String[] args) {
		// 여기 사용된 Marin 클래스는 day08 수업때 사용한 클래스와 동일
		Marin m1 = new Marin();
		// hp, x, y
		Marin m2 = new Marin(500, 100, 200);
		// hp atk, atkspd, spd
		Marin m3 = new Marin(200, 20, 20, 8);
		
		
		int[][] unitsCorrdinate = new int[128][128];
		
		// 모든 클래스는 현재 패키지 내에서 탐색
		// 그래서 요렇게도 쓸 수 있네
		//day08preImplements.Main m1 = new Marin();
		//java.util.Scanner sc = new java.util.Scanner(System.in);
		
	}
}
