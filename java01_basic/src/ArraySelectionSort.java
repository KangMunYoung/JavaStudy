
public class ArraySelectionSort {

	public static void main(String[] args) {
		// 1~100������ ������ 10�� �����Ͽ� �迭�� ������ ������������ �����Ͽ� �߷��϶�
		// Selection Sort

		int data[] = new int[10];
		//���� �迭�� ���� �� �ߺ� ����
		for (int i = 0; i < data.length; i++) {
			data[i] = (int) (Math.random() * 100) + 1;
			for (int j = 0; j < i; j++) {
				if (data[j] == data[i]) {
					i -= 1;
				}
			}
		}
		
		System.out.println();
		//������������ ��������
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
