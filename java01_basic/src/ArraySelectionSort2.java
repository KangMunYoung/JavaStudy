import java.util.Random;
public class ArraySelectionSort2 {

	public static void main(String[] args) {
		// 1~100������ ������ 10�� �����Ͽ� �迭�� ������ ������������ �����Ͽ� �߷��϶�
		// Selection Sort
		
		Random ran = new Random();
		
		int ranInt[] = new int[10];
		
		for(int i=0; i<ranInt.length; i++) {
			ranInt[i] = ran.nextInt(100)+1; //0~99���� ������ �Ϳ� +1�Ͽ� 1~100������ ����
		}
		
		//����(Selection sort)
		for(int point=0; point<ranInt.length-1;point++) {//0,1,2,3,4,5,6,7,8
			//���Ͽ� ��ȯ
			for(int i=point+1; i<ranInt.length; i++) {	// 0->1,2,3,4,5,6,7,8,9
														//1->2,3,4,5,6,7,8,9
				if(ranInt[point] > ranInt[i]) {
					int temp = ranInt[point];
					ranInt[point] = ranInt[i];
					ranInt[i] = temp;
				}
			}
		}
		//���
		for(int data : ranInt) {
			System.out.print(data+"\t");
		}
		System.out.println();

	}

}
