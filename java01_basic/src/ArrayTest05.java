
public class ArrayTest05 {

	public static void main(String[] args) {
		// 2차원 배열의 행마다 다른열의 수를 가질때...
		
		int num[][] = new int[5][];
		
		//열의 생성
		num[0] = new int[3];
		num[1] = new int[5];
		num[2] = new int[4];
		num[3] = new int[1];
		num[4] = new int[6];
		
		for(int r=0; r<num.length; r++) { // 0,1,2,3,4
			for(int c=0; c<num[r].length; c++) {
				System.out.print(num[r][c]+"\t");
				
			}
			System.out.println();
		}
		
		

	}

}
