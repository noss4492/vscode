package day05;

public class ArrayEx3 {

	static void d5ArrInit() { // static int[][][][][] d5ArrInit() {
		int[][][][][] d5Arr = new int [2][3][4][2][5];
		
		int num = 1;
		System.out.println("d5arr 내 참조값 - - - - - -  " + d5Arr);
		for(int i = 0; i < d5Arr.length; i++) {
			System.out.printf("********* i:%2d *********\n", i);
			System.out.print("{");
			for(int j = 0; j < d5Arr[0].length; j++) {
				//System.out.println("d5arr[0][0] 내 참조값 - - - - - -  " + d5Arr[0][0]);
				System.out.printf("****** i:%2d, j:%2d ******\n", i, j);
				System.out.print("{");
				for(int k = 0; k < d5Arr[0][0].length; k++) {
					//System.out.println("d5arr[0][0][0] 내 참조값 - - - - - -  " + d5Arr[0][0][0]);
					//System.out.printf("*** i:%2d, j:%2d, k:%2d ***\n", i, j, k);
					System.out.print("{");
					for(int n = 0; n < d5Arr[0][0][0].length; n++) {
						//System.out.println("d5arr[0][0][0][0] 내 참조값 - - - - - -  " + d5Arr[0][0][0][0]);
						//System.out.printf("* i:%2d, j:%2d, k:%2d, n:%2d *\n", i, j, k, n);
						System.out.print("{");
						for(int m = 0; m < d5Arr[0][0][0][0].length; m++) {
							System.out.printf(" %3d ",num++);
							d5Arr[i][j][k][n][m] = num;
						}
						System.out.print(" }");
						System.out.println();
					}
					System.out.print(" }");
					System.out.println();
				}
				System.out.print("}");
				System.out.println();
			}
			System.out.print("}");
			System.out.println();
		}
		//return d5Arr;	
	}
		
	
	static void d5ArrPrint() {
		
	}
	
	static void d3ArrInit() {
		int[][][] d3Array = new int[4][3][2];	//1 to 24, 
		//(2*3)*4
		int num = 1;
		System.out.println("d3Array 내 참조값 :" + d3Array);
		for(int i = 0; i < d3Array.length; i++) {
			//System.out.println("d3Array[0] 내 참조값 :" + d3Array[0]);
			System.out.print("{");
			for(int j = 0; j < d3Array[0].length; j++) {
				//System.out.println("d3Array 내 참조값 :" + d3Array[0][0]);
				System.out.print("{");
				for(int k = 0; k < d3Array[0][0].length; k++) {
					System.out.printf(" %3d ",num);
					d3Array[i][j][k] = num++;
				}
				System.out.print(" }");
			}
			System.out.print("}");
			System.out.println("\n\n");
		}
	}
	
	
	public static void main(String[] args) {
		d3ArrInit();
		d5ArrInit();
		//cArrInit
		//d5ArrPrint();
		//int[][][][][] D5Arr = d5ArrInit(); // recur 되나? 인자 받을때 걸려서 x임.
		// 정규표현식으로 변수를 작성해야만 가능할듯.
		int [][] m= {
				{0, 0, 0}, {0,1,2,3}, {1}};
		
		for(int i=0; i<m.length; i++)
			for(int j=0; j<m[i].length; j++)
				System.out.println("i:"+i+"j:"+j+"  "+m[i][j]);
		
		/* 확장 for문 안댐 -_- 얜 되는게 머임 대체
		 * for(int tmp : m) System.out.println(tmp);
		 */
	}
}



		
		
		
//		for(tmp : d3Array)				// 3차원은 확장 for문으로 안되네~
//			System.out.print(tmp);	
		
		
		// 아마 배열의 메모리 할당은 힙영역에서 연속적이게 이뤄지지 않는다는 것을 나타내기 위함일 것.
		
		
//		System.out.println("mm -------------------------"+3dArray);
//		for(int i = 0; i < 4; i++) {
//			for(int j = 0; j < 3; j ++) {
//				System.out.println("mm[i]  (가지고 있는 참조값)     --- "+3dArray[i]);
//				System.out.println("mm[i][j] (실제 힙영역에 할당된 값) - "+3dArray[i][j]);
//				for(int k = 0; k < 2; k++)
//					System.out.println("mm[i][j][k] (실제 힙영역에 할당된 값) "+3dArray[i][j][k]);
//			}
//		}
//		System.out.println("mm의 length는 :"+ mm.length);
		
		
		
		
		//mm     [[I@15db9742
		//mm[0]  [I@6d06d69c
		//mm[1]  [I@7852e922
		//mm[2]  [I@4e25154f
		//mm[3]  [I@70dea4e

