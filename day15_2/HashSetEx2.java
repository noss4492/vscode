package day15_2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
// 해쉬셋 사용해보기. ex)로또

// 장점. 중복값 제거,

// 1. int 6칸짜리 배열 m 선언
// 2. HashSet 객체 생성
// 3. 랜덤하게 1부터 45사이의 값 뽑기
// 4. HashSet에 담기
// 5. HashSet의 요소 갯수가 6개라면 중단
// 6. 아니면 3번으로 돌아가기
// 7. HashSet에서 1개씩 값을 꺼내 배열에 담기
// 8. 정렬하기
// 9. 배열 요소를 1개씩 꺼내 화면에 출력
public class HashSetEx2 {
	public static void main(String[] args) {
		int[] m = new int[6];
		
		HashSet hs1 = new HashSet();
		Random rnd = new Random();
		
		while(hs1.size() < 6) {	
			int r = rnd.nextInt(45)+1;
			hs1.add(r);
		}
		
		int cnt = 0;
		Iterator it = hs1.iterator();
//		Iterator it = new Iterator(); << X 인터페이스라서 생성 안되는뎅
//		HashSet hs1의 Iterator()메서드의 참조값을 부모 인터페이스인 it의 참조값으로 넘겨준 것.
		
		while(it.hasNext())				// 다음 하나를 안 꺼내고 본 것
			m[cnt++] = (int) it.next();	// 하나씩 꺼내서 본것. return Object
		// Object obj = it.next();
		// m[0] = (int)obj;
		// 그냥 for문으로 쓸걸 가독성 떨어졌네
		
		Arrays.sort(m);
		
		for(int x : m)
			System.out.println(x);
	}
}


// 이전에 만든 로또에서 6개 받아 오는것도 좋은 방법인듯 ' 3';;

//		좋은 방법인듯
//		Lotto lt = new Lotto();
//		int[] k = it.get();
		
		
//		while(it.hasNext())
//			System.out.println("|"+it.next());
		
		
//		while(cnt < 6)
//			m[cnt++] = (int) it.next();
		
		
//		while(true){
//			if(hs1.size() == 6)
//				break;
//		}
		
		
		
		
		
