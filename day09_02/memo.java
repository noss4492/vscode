package day09_02;

public class memo {
/*
 *객체지향언어의 특즹
 
1. 캡슐화 => 정보의 은닉
접근지정자(4가지 ㅇㅇ)
변수private int
getter setter

2. 상속(extends)
자식클래스 생성자에 부모 클래스의 기본생성자는 기본으로 호출되는 거 ㅇㅇ



Class hp = new Class(파라메타 머시기 저시기);
이때의 hp는 참조값을 전달하는 참조변수임. <<용어 자꾸 까먹음
 * 
 * 상 당 히 많 이 사 용 되 는 키 워 드 임.
Access Modifier
접근 지정자(혹은 접근 수정자 접근 한정자...)
private   : 현재 클래스에서만 접근 가능 (#내생각 visible함, visibility를 가짐)
default   : 현재 클래스랑 같은 패키지에 있는 애들은 접근 가능
protected : 동일 패키지랑 상속관계에 있는 애들만 접근 가능
public    : 어디에서나 접근 가능

주로 클래스는 public (가아아아아끔 default)
변수는 public을 주로 쓰지 않는듯. default로 자주 쓰이고 있는데


···-----=========>>> [ 변 수 명 명 법 ] <<<=========-----···

# 기본적으로 지켜야함.
1. A~Z, a~z, 0~9, _, #
2. 첫글자는 영문자 (숫자x)
3. 예약어 X                      (if, for 이런 키워드들은 안되지요)
4. 길이 제한 x
5. 의미있게 

# 프로젝트 환경에서의 지켜야할 사항.
정부에서 내려온 명명법 규칙서 있음 -> 플젝하다보니 정형화된 관습

클래스명( ex. Marine )
1. 첫글자는 대문자, 나머지는 소문자.
2. 공백x (C는 _로 공백 구분) (Java는 뒷 단어의 첫 글자를 대문자로)

변수명( ex. sumOfA )
1. 첫 글자는 소문자
2. 두개 이상의 합성어라면 뒷 단어의 첫 글자는 대문자로

메서드명( ex. atkAll() )
1. 첫 글자는 소문자
2. 뒷 단어의 첫 글자는 대문자
3. ~~~~~~~~~()

생성자명( ex. Marin() )
1. 클래스명과 동일해요
2. ~~~~~~~~~()

상수( ex. MAX_VALUE )
1. 모든 글자가 대문자
2. 공백은 _로 

패키지
1. 소문자로


## 안전하게 객체를 만드는 방법 // 캡.슐.화
변수에 직접 접근하지 못하도록 하게 하자
로직 사용이 가능한 메서드를 통해서 작업하게 하자.

// 안전하게 객체를 만드는 방법
		// 변수에 직접 접근하지 못하게
		// 로직 사용이 가능한 메서드를 만들어서
		// 값을 얻어오는 메서드
		// 값을 지정하는 메서드
		// 이것이 캡슐화(encapsulation)
		// private한 변수, setter method, getter method


상속받으면
// 자식의 생성자에서 부모의 기본 생성자 호출. 내가 쓰지 않더라도


 */
}
