package __PlayGround__;

public class BackTracking_nQueen1 {
	static int[] pos = new int[8];

	static void print() {
		for (int n = 0; n < 8; n++)
			System.out.printf("%2d", pos[n]);
		System.out.println();
	}

	static void set(int x) {
		for (int j = 0; j < 8; j++) {
			pos[x] = j;
			if (x == 7)
				print();
			else
				set(x + 1);
		}
	}

	public static void main(String[] args) {
		set(0);
	}
}
