package day11_javaMemPrac;

public class Study2gc {
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime + "ns");
	}	// jvm �ɼǿ� -verbose:gc
}		// -XX:+PrintCommandLineFlags
        // System.gc ��ȣ��� 100ns
        // System.gc ȣ��� + �� 6,959,106ns �� �ɸ�