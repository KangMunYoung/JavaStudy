
public class ForExtesionArray {

	public static void main(String[] args) {

		// Ȯ��� for��
		int arr[] = {1,2,3,4,5,6,};
		
		//�迭�� ���������������� : �迭��
		for(int data : arr) {
			System.out.print(data+"\t");
		}
		System.out.println();
		
		//2���� �迭
		int arr2[][] = {
						{60,80,40,60},
						{56,62,84,79},
						{36,58,78,95}
						};
		
		//	1�����迭���� : 2�����迭��
		for(int[] data : arr2) {
			//	�迭�� ������������ : 1���� �迭��
			for(int z : data) {
				System.out.print(z+"\t");
			}
			System.out.println();
		}
	}
	
}
