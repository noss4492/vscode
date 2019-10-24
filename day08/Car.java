package day08;
// 객체의 설계도
// 구성요소
// 1. Member 변수(variable), 필드(field)
// 2. Method
public class Car {
	// 속성, 특징
	int 핸들, 바퀴, 엔진, 문, 속도;
	String 차종, 제조사;
	
	
//	 Car(int num){
//		 this.바퀴 = num;
//	 }
	 
	
//	Car(int 핸들, int 바퀴, int 엔진, int 문, int 속도, 
//			String 차종, String 제조사){
//	}
	
	// 동작, 행위
	void 전진() {
		System.out.println("전진 : ㄱㄱ");
	}
	void 후진() {
		System.out.println("후진 : ㅂㅂ");
	}
	void 정지() {
		System.out.println("정지 : 끾ㄲ");
	}
	void 가속() {
		System.out.println("가속 : 부릉");
	}
	void 감속() {
		System.out.println("감속 : 슈웅");
	}	
}
