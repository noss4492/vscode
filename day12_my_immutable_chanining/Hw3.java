package day12_my_immutable_chanining;

public class Hw3 {
}

/*
AWT
(Abstract Wndow Toolkit)

Component
	Container
		Window
			Frame
 */
/*
3. 모든 클래스의 최상위 클래스는?
Object

4. 이 클래스의 메서드는 모두 몇개있는가?  11
clone(), equals(Object obj), finalize(), getClass(), hashCode(), notify()
notifyAll(), toString() : Returns a string representation of the object
wait(), wait(long timeout), wait(long timeout, int nanos)

5.  equals(), toString()를 예를 들어 출력해보고
어떤 내용이 들어있는지 정리하시오.

equals(Object obj)
The equals method implements an equivalence relation on non-null object references
이 equals 메소드는 도구 쓰인다(도구로) 동등한 관계를 판단하는 null이 아닌 오브젝트의 참조값을
참조값으로 비교함.

toString()
Returns a string representation of the object
객체가 대표하고 있는 string( getClass().getName() + '@' + Integer.toHexString(hashCode()) )
를 반환한다.

String Class의 경우 내용 비교를 equals로 해야 객체 내부의 내용을 비교할 수 있다.
String Class를 할당연산자(new)없이 일반 primitive type variable처럼 사용하면 
같은 객체를 나타낼 경우 생성되지 않고 같은 객체 지점을 가르키게 된다.

6. String 클래스의 equals() , toString()은
Object클래스와 어떤 차이가 있으며, 왜 차이가 생기는가? 

String Class의 equals()은 참조값을 가지고 가서 비교하는 것이 아니라
내부 인자를 비교하여 내용이 같은지를 비교하게 됨.

String Class의 toString()은 

String Class
	toString()
		This object (which is already a string!) is itself returned.
Overrides:
	toString in class Object
 자기 객체를 반환해줌.



7. String 클래스의 자주 사용되는 메서드를 정리하고
이 메세드가 어떤 결과를 주는지 정리하시오.
String 생성자
	String(byte[] bytes)
charAt(int idx)
	해당 인덱스 지점 값 반환
concat(String str)
	이어붙이기
equals(Object anObject)
	내부 객체가 지닌 값이 같은지
equalsIgnoreCase(String anotherString)
	문자열 비교(대문자 무시)
indexOf(int ch)
	해당 문자 들어있는 문자열의 인덱스 반환
length()
	문자열 길이 반환
replace(char oldChar, char newChar)
toCharArray()
	char배열로 쪼갬
toString()
	자기 객체 값 반환

*/