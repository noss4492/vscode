package day23;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LamdaEx11 {
	public static void main(String[] args) {
		
		// Supplier<T>
		// ���ڴ� ���� ������ ����Ÿ�Ը� �����ϴ� �޼���
		// �����Լ����� ����� �ٲٴ� �� ���� input ���̴�.
		
		Supplier<String> s = () -> "Hello Supplier";
		String result = s.get();
		System.out.println("Supplier"+result);
		
		// Consumer<T>
		// ������ ���� �ʰ�(void), ���ڸ� �޴� �޼��带 ���� �ִ�.
		// ���ڸ� �޾� �Ҹ��Ѵٴ� ��.
		Consumer<String> c = str -> System.out.println(str);
		c.accept("Hello Consumer");
		
		// Function<T, R>
		// �������� �Լ��� ����
		// �ϳ��� ���ڿ� ���� Ÿ���� ���´�.
		
		Function <String, Integer> f = str -> Integer.parseInt(str);
		
		Integer result2 = f.apply("1");
		System.out.println(result2);
		
		// Predicate<T>
		// �ϳ��� ���ڿ� ���� Ÿ���� ���´�.
		// ����Ÿ���� �����ϴ� Ÿ�� �Ķ���Ͱ� �Ⱥ��δ�.
		// ��ȯ���� boolean
		// Fuction<T, Boolean> ����
		
		Predicate<String>p = str -> str.isEmpty();
		boolean result3 = p.test("Hello");
		System.out.println(result3);
		
		
		
	}

}
