package day02;
import java.util.Scanner;
// ��ü�˻� �����Ϳ� Ŭ���� �迭���� ��� Ű�� �÷��� ������ ����

class will_delete {

	static final int VMAX = 21;		// �÷� ����(0.0���� 0.1 ������ 21����

	static class PhyscData {
		String name;				// �̸�
		int    height;				// Ű
		double vision;				// �÷�

		// ������
		PhyscData(String name, int height, double vision) {
			this.name 	= name;
			this.height = height;
			this.vision = vision;
		}
	}

	// Ű�� ��հ��� ����
	static double aveHeight(PhyscData[] dat) {
		double sum = 0;

		for (int i = 0; i < dat.length; i++)
			sum += dat[i].height;

		return sum / dat.length;
	}

	// �÷� ������ ����
	static void distVision(PhyscData[] dat,
								  int[] dist) {
		int i = 0;

		dist[i] = 0;
		for (i = 0; i < dat.length; i++)
			if (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
				dist[(int)(dat[i].vision * 10)]++;
	}

	public static void main(String[] args) {
		Scanner stdIn = new Scanner(System.in);

		PhyscData[] x = {
			new PhyscData("������", 162, 0.3),
			new PhyscData("������", 173, 0.7),
			new PhyscData("������", 175, 2.0),
			new PhyscData("ȫ����", 171, 1.5),
			new PhyscData("�̼���", 168, 0.4),
			new PhyscData("�迵��", 174, 1.2),
			new PhyscData("�ڿ��", 169, 0.8),
		};
		int[] vdist = new int[VMAX];					// �÷� ����

		System.out.println("�� ��ü�˻� ����Ʈ ��");
		System.out.println(" �̸�         Ű       �÷�");
		System.out.println("---------------");
		for (int i = 0; i < x.length; i++)
			System.out.printf("%-8s%3d%5.1f\n",
												  x[i].name, x[i].height, x[i].vision);

		System.out.printf("\n��� Ű��%5.1fcm\n", aveHeight(x));

		distVision(x, vdist);							// �÷� ������ ����

		System.out.println("\n�÷� ����");
		for (int i = 0; i < VMAX; i++)
			System.out.printf("%3.1f~��%2d��\n", i / 10.0, vdist[i]);
	}
}




/*
 * package day02; import java.util.Scanner; //package chap02;
 * 
 * 
 * 
 * Ŭ���� ���� ������.
 * 
 * ��� ��
 * 
 * �̸� Ű �÷�
 * 
 * 
 * �÷º��� 0.0~:0�� 0.1~:0�� 0.2~:0�� ... 0.5:~0�� --------
 * 
 * 
 * //��ü�˻� �����Ϳ� Ŭ���� �迭 ���� //��� Ű�� �÷� ������ ����
 * 
 * class will_delete{
 * 
 * static final int VMAX = 21; // distribution of vision 21 level 0.0 ~ 2.0
 * 
 * static class PhyscData{ // student data format String name; int height;
 * double vision;
 * 
 * // Generator PhyscData(String name, int height, double vision){ this.name =
 * name; this.height = height; this.vision = vision; } }
 * 
 * // avg height of all student static double avgHight(PhyscData[] dat){ double
 * sum = 0;
 * 
 * for( int i=0; i<dat.length; i++) // Ȯ�� for�� ����غ� �� sum += dat[i].height;
 * 
 * return sum / dat.length; }
 * 
 * // distribution of vision static void distVision(PhyscData[] dat, int[]
 * dist){ int i =0; dist[i] = 0; for (i = 0; i<dat.length; i++) if
 * (dat[i].vision >= 0.0 && dat[i].vision <= VMAX / 10.0)
 * dist[(int)(dat[i].vision*10)]++; }
 * 
 * 
 * // main method public static void main(String[] args){ Scanner stdIn = new
 * Scanner(System.in);
 * 
 * PhyscData[] x = { new PhyscData("������", 162, 0.3), new PhyscData("������", 173,
 * 0.7), new PhyscData("������", 175, 2.0), new PhyscData("ȫ����", 171, 1.5), new
 * PhyscData("�̼���", 168, 0.4), new PhyscData("�迵��", 174, 1.2), new
 * PhyscData("�ڿ��", 169, 0.8), }; int[] vdist = new int[VMAX];
 * 
 * System.out.println("--��ü�˻� �л� ����Ʈ--");
 * System.out.println("�̸�          Ű          �÷�");
 * System.out.println("---------------");
 * 
 * for(int i = 0; i<x.length; i++) //Ȯ�� for������ ������ ��
 * System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
 * 
 * System.out.printf("\n��� Ű : %5.1fcm\n", avgHight(x));
 * 
 * distVision(x, vdist);
 * 
 * System.out.println("\n�÷� ����"); for(int i=0; i<VMAX; i++)
 * System.out.printf("%3.1f~ :%2d��\n", i/10.0, vdist[i]);
 * 
 * } }
 * 
 * 
 * 
 * // �ڹ� ��Ÿ�� ������ // ���� �̸� ����ΰ� ���� �籸���غ��� // ���̺� �÷� name, height, vision // dist
 * vision // VMAX �� distribution of vision
 * 
 * "������", 162, 0.3 "������", 173, 0.7 "������", 175, 2.0 "ȫ����", 171, 1.5 "�̼���", 168,
 * 0.4 "�迵��", 174, 1.2 "�ڿ��", 169, 0.8
 * 
 * //
 * 
 * 
 * 
 * // Q. // ��ü�˻� �����Ϳ� Ŭ���� �迭 ���� // ��� Ű�� �÷� ������ ���϶� // ������ ���� ����� ������
 * 
 * 
 * // ������ �ʿ��ұ�? �����غ��� �ۼ��ϵ��� ����. // Ŭ������ ������ // Ŭ���� ���� // 1. �ʵ� // 1. �ʵ�� ���� //
 * ���� ��� ���� // ������ ���� // �����ڷ� Ŭ����, �ν��Ͻ� �ʱ�ȭ // 2-1. �ż��� // 2-2. ����(���θ޼���)
 * 
 * public class will_delete{
 * 
 * 
 * 
 * // ���� ��� static final int VmaxLv = 21; // �÷� 0.0 ~ 2.0 21 Lv�� ����ȭ, �ʺ�:0.1
 * 
 * // ������ ���� ����, �ֳ�? ���̺� ��� �ڷ����� �ϳ� ���� row���� �����ϱ� ���ؼ��� public static
 * PhysicalData() { String name; int height; float vision;
 * 
 * // ������, Ŭ���� �� �ν��Ͻ� �ʱ�ȭ PhysicalData(String name, int height, float vision){
 * this.name = name; this height = height; this vision = vision; } }
 * 
 * public static void main(String[] args) { Scanner stdIn = new
 * Scanner(System.in);
 * 
 * PhysicalData[] pd = { "������", 162, 0.3 "������", 173, 0.7 "������", 175, 2.0 "ȫ����",
 * 171, 1.5 "�̼���", 168, 0.4 "�迵��", 174, 1.2 "�ڿ��", 169, 0.8 }; int[] vdist = new
 * int[VMAX];
 * 
 * System.out.println("�� ��ü�˻� ����Ʈ ��");
 * System.out.println(" �̸�         Ű       �÷�");
 * System.out.println("---------------"); for (int i = 0; i < pd.length; i++)
 * System.out.printf("%-8s%3d%5.1f\n", pd[i].name, pd[i].height, pd[i].vision);
 * 
 * System.out.printf("\n��� Ű��%5.1fcm\n", aveHeight(VmaxLv));
 * 
 * distVision(VmaxLv, vdist); // �÷� ������ ����
 * 
 * System.out.println("\n�÷� ����"); for (int i = 0; i < VmaxLv; i++)
 * System.out.printf("%3.1f~��%2d��\n", i / 10.0, vdist[i]); } }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */