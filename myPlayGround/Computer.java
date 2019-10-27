package myPlayGround;

// PC -> MAR   ->�ּҹ���
// PC - ������ġ  ->�������
// IR <- MBR   <-�����͹���
//                �ּҹ��� - �����͹��� - �������        �޸�
public class Computer {
	int addrCpuBetweenReg;
	Computer(){
	}
	public class CPURegister{
	}
	public class CacheMemoryL1{
	}
	
	
	public static void main(String[] args) {
		
		// process - cache - memory, (cache line ������ ������)
		//         |       |
		//       word����    block����(cache line or cache block)
		
		// register mem - cache mem(L1,L2,L3) - main memory - disk(HDD,SSD) - sub
		// ����(bottlenect ����)
		// Locality : Spatial locality Temporal locality
		// Cache hit ratio : Cache hit, miss

		// x[0][0~15] x[0][16~31] ... a[0][m-15~m] ..... a[n]a[m-15~m]
		int n = 10;	//M.M size x[10][10(0~159)]
		int m = 10;
		int x[][] = new int[n][m*16];	
		int y = 0;
		double exeNanoTime = 0.0;
		
		// ���� M.M ��򰡿� hit ������ ���� ����ִٸ� (������ x[2][1] ����)
		for(int i = 16-1; i < 16*2; i++) {
			x[2][i] = (int)(Math.random()*100);
		}
		
		//���κ��� �ܾ�ϱ� ���η� ��� ��
		// block size = 16
		// cache - m.m
		// sum ���α׷� �����
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m*16; j++) {
				long nanoTimeStart = System.nanoTime();
				if(x[i][j]!=0) {
					y += (x[i][j]);
					//System.out.printf("Cache hit! : A[%2d][%2d]:%2d sum:%4d\n", i, j, x[i][j], y);
				}
				long nanoTimeEnd = System.nanoTime();
				exeNanoTime += (double)(nanoTimeEnd-nanoTimeStart);//ms
			}
		}
		System.out.printf("%.6f ms\n",exeNanoTime/Math.pow(10, 6));
		
			for(int j = 0; j < m*16; j++) {
				for(int i = 0; i < n; i++) {
				long nanoTimeStart = System.nanoTime();
				if(x[i][j]!=0) {
					y += (x[i][j]);
					//System.out.printf("Cache hit! : A[%2d][%2d]:%2d sum:%4d\n", i, j, x[i][j], y);
				}
				long nanoTimeEnd = System.nanoTime();
				exeNanoTime += (double)(nanoTimeEnd-nanoTimeStart);//ms
			}
		}
		System.out.printf("%.6f ms",exeNanoTime/Math.pow(10, 6));
	}
	
	
}
