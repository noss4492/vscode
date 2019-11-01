package day15;

import java.util.Arrays;
import java.util.Random;

public class Lotto {
	int[] m = new int[6];
	int[] num = new int[45];
	
	Lotto() {
		gen();
		shuffle();
		set();
		sort();
//		print();
//		for(int i = 0; i < 45; i++)
//			System.out.println(num[i]);
	}
	
	public void gen() {
		int[] n = new int[45];
		for(int i = 0; i < 45; i++) {
			num[i] = i;
		}
	}
	
	public void shuffle() {
		Random rnd = new Random();
		for(int i = 0; i < 1000; i++) {
			int tmp;
			int r1 = rnd.nextInt(45);
			int r2 = rnd.nextInt(45);
			if( r1 == r2 )
				continue;
			tmp = num[r1];
			num[r1] = num[r2];
			num[r2] = tmp;
		}
	}
	
	public void print() {
		for(int i = 0; i < 6; i ++)
			System.out.printf("[%2d]", m[i]);
	}
	
	public void set() {
		for(int i = 0; i < 6; i++) {
			m[i] = num[i];
		}
	}
	
	public void sort() {
		Arrays.sort(m);
	}
	
	public int[] get() {
		return this.m;
	}
	
	
}
