
public class MethodTest {
	//public - ����������
	//�������
	int num = 12;
	String name="ȫ�浿";
	String tel;	//	null
	
	//������ �޼ҵ� :	������ �ڵ� �߰�(JVM)
	//				��۰��谡 �ƴҶ��� �߰� ���ش�.
	//	�Ű������� ���������� �ٸ��ų� �������� ������ ������ �޶���Ѵ�.
	MethodTest(){};//�ʿ��ϵ� ���ϵ� ������ �߰����ش�
	MethodTest(String tel){
		System.out.println("����ó"+tel);
	}
	//MethodTest(String name){	
	//}
	MethodTest(int num){
		
	}
	
	MethodTest(int num, String name){
//		this : ���簴ü(����۷���)
		this.num = num;
		this.name = name;
		String tel = "1234";
		this.tel = "02-1234-1234";
	}
	MethodTest(String name, int num){
		//������ �޼ҵ忡�� �ٸ� ������ �޼ҵ� ȣ���ϱ�
		//������ �޼ҵ忡�� �ٸ� �����ڸ� ȣ���Ҷ��� �޼ҵ���� ����ǥ���Ҽ� ����
		//		this()
//		MethodTest(num,name); ��� �Ұ�
//		this()�� �̿��ؼ� �ٸ� ������ �޼ҵ带 ȣ���Ҷ��� �ݵ�� ù��° ���๮�̿��� �Ѵ�.
//		System.out.println();//ù��°�� �ٸ� ������ �޼ҵ带 ȣ���ϸ� �ȵȴ����� �������� �ڵ�
		this(num, name);	//ù��° ���๮�̰�, this�� �ҷ��´�
	}
}
