
public class WrapperTest {

	public WrapperTest() {
		//WrapperŬ������ �⺻ ���������� ������ ��ü�� �����Ű�� Ŭ�����̴�.
		//Byte, Short, Integer, Long
		//Float, Double
		//Boolean
		//Character
		
		int a =1234;
		Integer i= Integer.valueOf(a);//new Integer(a); //��üȭ
		
		System.out.println(a);//��ü���ƴ�
		System.out.println(i);//��ü
		
		Object obj = a;	//����ڽ� 1.5���� ����������ϸ������
		Object obj2 = i;
		System.out.println(obj);
		System.out.println(obj2);
		
//		1.1, 1.2 , 1.3, 1.4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16
	
		int x = i;//�����ڽ�
		System.out.println(x);
	}

	public static void main(String[] args) {
		new WrapperTest();
		
	}

}
