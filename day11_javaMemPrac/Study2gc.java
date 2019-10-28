package day11_javaMemPrac;

public class Study2gc {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime + "ns");
	}	// jvm 옵션에 -verbose:gc
}		// -XX:+PrintCommandLineFlags
        // System.gc 미호출시 100ns
        // System.gc 호출시 + 약 6,959,106ns 더 걸림