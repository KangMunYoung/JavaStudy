import java.util.Random;
public class ArraySelectionSort2 {

	public static void main(String[] args) {
		// 1~100사이의 난수를 10개 생성하여 배열에 대입후 오름차순으로 정렬하여 추력하라
		// Selection Sort
		
		Random ran = new Random();
		
		int ranInt[] = new int[10];
		
		for(int i=0; i<ranInt.length; i++) {
			ranInt[i] = ran.nextInt(100)+1; //0~99까지 생성된 것에 +1하여 1~100까지로 변경
		}
		
		//정렬(Selection sort)
		for(int point=0; point<ranInt.length-1;point++) {//0,1,2,3,4,5,6,7,8
			//비교하여 교환
			for(int i=point+1; i<ranInt.length; i++) {	// 0->1,2,3,4,5,6,7,8,9
														//1->2,3,4,5,6,7,8,9
				if(ranInt[point] > ranInt[i]) {
					int temp = ranInt[point];
					ranInt[point] = ranInt[i];
					ranInt[i] = temp;
				}
			}
		}
		//출력
		for(int data : ranInt) {
			System.out.print(data+"\t");
		}
		System.out.println();

	}

}
