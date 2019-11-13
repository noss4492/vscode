package day23;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaEx11 {
	public static void main(String[] args) {
		
		// Supplier<T>
		// 인자는 받지 않으며 리턴타입만 존재하는 메서드
		// 순수함수에서 결과를 바꾸는 것 오직 input 뿐이다.
		
		Supplier<String> s = () -> "Hello Supplier";
		String result = s.get();
		System.out.println("Supplier"+result);
		
		// Consumer<T>
		// 리턴을 하지 않고(void), 인자를 받는 메서드를 갖고 있다.
		// 인자를 받아 소모한다는 뜻.
		Consumer<String> c = str -> System.out.println(str);
		c.accept("Hello Consumer");
		
		// Function<T, R>
		// 전형적인 함수를 지원
		// 하나의 인자와 리턴 타입을 갖는다.
		
		Function <String, Integer> f = str -> Integer.parseInt(str);
		
		Integer result2 = f.apply("1");
		System.out.println(result2);
		
		// Predicate<T>
		// 하나의 인자와 리턴 타입을 갖는다.
		// 리턴타입을 지정하는 타입 파라미터가 안보인다.
		// 반환값이 boolean
		// Fuction<T, Boolean> 형태
		
		Predicate<String>p = str -> str.isEmpty();
		boolean result3 = p.test("Hello");
		System.out.println(result3);
		
		
		
	}

}
