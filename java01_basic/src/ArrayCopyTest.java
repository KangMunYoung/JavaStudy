
public class ArrayCopyTest {

	public static void main(String[] args) {
		//�迭�� ����
		int num[]= {1,2,3,4,5,6,7,8,9,0};
		//			�����迭��		�������index	�����Ұ��� �迭��	������ġindex		������ �������� ����
		//arraycopy(Object src, int srcPos, Object dest,	 int destPos, int length)
		//			num			num[2]		target			target[5]		3				
		//num�迭���� index 2�������� 3���� ���縦 �Ͽ� ���ο� �迭�� �����ϰڴ�.
		int target[]=new int[10];
		
		System.arraycopy(num, 2, target, 5, 3);
		
		for(int i=0; i <target.length; i++ ) {
			System.out.println("target["+i+"]"+target[i]);
		}
		

	}

}
