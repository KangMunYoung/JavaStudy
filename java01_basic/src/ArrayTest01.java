
public class ArrayTest01 {

	public static void main(String[] args) {
		// �迭�� ���� ���������� ������ ������ ������ �� �ʿ��ϴ�.
		
		//�迭�� ����(1�����迭)
		int[] data;//�޸� �Ҵ� x
		int num[] = new int[5];//����:0 �Ǽ�:0,0 ����:false
		
		String name[] = new String [5]; //null
		
		num[2] = 100;
		name[1] = "ȫ�浿";
		
		System.out.println("num[1]=>"+ num[1]);
		System.out.println("name[1]=>" + name[1]);
		
		//num�迭�� ��簪�� ����϶�
		// 	num[*], num[*], num[*], num[*], num[*]
		// �迭��.length -> �迭�� ������ ���Ͽ� �ش�.
		for(int i=0; i<num.length; i++) {
			System.out.println("num["+i+"]="+	num[i]);
		}
		
		//�迭 ���̼� �ʱⰪ �����ϴ� ��� 1
		int[] data2 = new int[] {20, 65, 74, 5, 87,2};
		for(int i=0; i<data2.length; i++) {
			System.out.println("data2["+i+"]="+data2[i]);
		}
		
		//�迭 ������ �ʱⰪ �����ϴ� ��� 2
		int data3[]= {8,7,65,4,3};
		for(int i=0; i<data3.length; i++) {
			System.out.println("data3["+i+"]="+data3[i]);
		}
	}

}
