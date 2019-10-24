package day08preImplements;

public class PlayGround {
	
	public static void unitStatusPrint(StarUnits m1, StarUnits d1,
									   StarUnits g1, StarUnits t1) {
		System.out.print("  >>���� m1<< ");
		m1.status();
		System.out.print("  >>�޵� d1<< ");
		d1.status();
		System.out.print("  >>���� g1<< ");
		g1.status();
		System.out.print("  >>��ũ t1<< ");
		t1.status();
	}
	public static void main(String[] args) {
		Marin m1 = new Marin();
		Medic d1 = new Medic();
		Ghost g1 = new Ghost();
		Tank t1 = new Tank();
		
		
		int[][] unitsCorrdinate = new int[256][256];	//x, y
		
		unitStatusPrint(m1, d1, g1, t1);
		
		m1.attack(g1);
		d1.heal(g1);		
		g1.nuclearLaunch(); // �̱��� ��� ��� ��ü���� ����?
		
		t1.seigeMode();
		m1.attack(t1);
		d1.heal(t1); // ���� 
		
		g1.attack(m1);
		g1.attack(d1);
		g1.attack(g1);
		g1.attack(t1);
		
		t1.attack(m1);
		t1.attack(d1);
		
	}

}
