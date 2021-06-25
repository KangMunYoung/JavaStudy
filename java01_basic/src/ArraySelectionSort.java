
public class ArraySelectionSort {

	public static void main(String[] args) {
		// 1~100사이의 난수를 10개 생성하여 배열에 대입후 오름차순으로 정렬하여 추력하라
		// Selection Sort

		int data[] = new int[10];
		//난수 배열에 삽입 및 중복 제거
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * 100) + 1;
			for (int j = 0; j < i; j++) {
				if (data[j] == data[i]) {
					i -= 1;
				}
			}
		}
		
		System.out.println();
		//오름차순으로 선택정렬
		for (int i = 0; i < data.length; i++) {
			int temp = data[i];
			int c = 0;
			for (int j = i; j < data.length; j++) {
				if (temp > data[j]) {
					temp = data[j];
					c = j;
				}
			}
			data[c] = data[i];
			data[i] = temp;
			System.out.print(data[i] + ",");
		}
	}
}
