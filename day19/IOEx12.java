package day19;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// 회원정보를 저장하고 읽기
public class IOEx12 {
	public static void main(String[] args) throws IOException {
		Member m1 = new Member("id1", "1234", "길동홍", "조선", "hong@gmail.com", 20);
		
		FileOutputStream fos = new FileOutputStream("z:\\_19_member.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(m1);
		
		
		// NotSerializableException 발생. 
		// 잘게 쪼개서 다시 원상태로 만드는 것이 직렬화(라고 불리는 이름으로 쓰임, 태세우스의 배 같은 상황임)
		// 대상 객체를 serializable 상태로 만들면 됨.(시리얼라이저블 임플리먼트)
		
		
	}
}
