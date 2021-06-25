
public class ArrayEx04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[][] = new int[10][10];
		
		int temp = 0;
		
		for(int i=1; i<arr.length; i++) {
			for(int j=1; j<arr.length; j++) {
				arr[i-1][j-1]=i*j;
				arr[i-1][9] += arr[i-1][j-1];	
			}
			arr[9][i-1]=arr[i-1][9];
			
		}
			
		for(int[] data : arr) {
			//	배열의 데이터형변수 : 1차원 배열명
			for(int z : data) {
				System.out.print(z+"\t");
			}
			System.out.println();
		}
	}

}
