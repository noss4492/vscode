package day11_javaMemPrac;

public class Study1gc {
	public static void main(String[] args) {
		String url = "https://";
		url += "nosshome.co.kr:4489";
		System.out.println(url);
	}
}

// s		 |		 h
// url            #a  (String) https://

//                #c  (String) https://nosshome.co.kr:4489



// url은 #a를 갖다가

// url은 #c를 갖게 되면 #a는 도달할 수 없어지므로 
// (Unreachable Object가 됨), (stack에서 도달할 수 없는 Heap영역의 객체)

// Mark and Sweep 과정이라고도 함.
// Marking : JVM의 G.C가 stack의 모든 변수를 스캔하면서 각각 어떤 Object를 reference하고 있는지 찾는 과정
// 첫 단계인 marking 작업을 위해 모든 쓰레드가 중단되는데 이를 stop the world
// (생각 없이 System.gc()를 호출하면 안되는 이유임.

// Sweeping : 그러고 나서 mark되어있지 않은 모든 Object들을 힙에서 제거하는 과정이 sweep

// 정리 : garbage가 아닌 것을 mark하고 그 외의 모든 것은 지우는 것.