package day09;

//import day08preImplements.Marin;
//import day08preImplements.*;

// reference type : Array, Class (����� ������ Ÿ��)
// �⺻������ Ŭ���� Ž�� ������ ���� ��Ű�� �������� Ž��.

// ���
// ������� ����ʵ� < ��������
// �Ű����� < ��������

// �ڹٴ� ���� ����� ������ ����Ű�� Ư���� �־
// Marine(int hp, int x, int y){
// hp = hp    // ���� hp�� ���� ����� ���� int hp�� hp�� ����Ŵ
// this�� ���� ������ְų� �ٸ� �Ű����������� ���� ��.

public class TestMain1 {
	public static void main(String[] args) {
		// ���� ���� Marin Ŭ������ day08 ������ ����� Ŭ������ ����
		Marin m1 = new Marin();
		// hp, x, y
		Marin m2 = new Marin(500, 100, 200);
		// hp atk, atkspd, spd
		Marin m3 = new Marin(200, 20, 20, 8);
		
		
		int[][] unitsCorrdinate = new int[128][128];
		
		// ��� Ŭ������ ���� ��Ű�� ������ Ž��
		// �׷��� �䷸�Ե� �� �� �ֳ�
		//day08preImplements.Main m1 = new Marin();
		//java.util.Scanner sc = new java.util.Scanner(System.in);
		
	}
}
