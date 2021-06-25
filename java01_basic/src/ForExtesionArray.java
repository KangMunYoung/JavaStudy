
public class ForExtesionArray {

	public static void main(String[] args) {

		// 확장된 for문
		int arr[] = {1,2,3,4,5,6,};
		
		//배열의 데이터형변수선언 : 배열명
		for(int data : arr) {
			System.out.print(data+"\t");
		}
		System.out.println();
		
		//2차원 배열
		int arr2[][] = {
						{60,80,40,60},
						{56,62,84,79},
						{36,58,78,95}
						};
		
		//	1차원배열변수 : 2차원배열명
		for(int[] data : arr2) {
			//	배열의 데이터형변수 : 1차원 배열명
			for(int z : data) {
				System.out.print(z+"\t");
			}
			System.out.println();
		}
	}
	
}
