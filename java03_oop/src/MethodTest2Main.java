
public class MethodTest2Main {
	public MethodTest2Main() {
		
	}
	
	public static void main(String[] args) {
		MethodTest2 mt = new MethodTest2();
		
		String gugu = mt.gugudan(8);//�޼ҵ� ȣ��
		System.out.println(gugu);
		
//		��ȯ���� ���� �޼ҵ� ȣ��
		mt.powerStart();

		mt.channelUp();
		mt.channelDown();
		mt.channelUp();
//		static���� �޼ҵ�� �ݵ�� ��ü�� ����� �޼ҵ�� ȣ���ؾ� �Ѵ�.
		mt.sum(20);
//		static�� �޼ҵ��� ��ȯ�� ���ʿ� �ִ� ���� �޼ҵ带 ��ü�������� �ʰ� ȣ���Ҽ� �ִ�.
//		Ŭ������.�޼ҵ��(�Ű�����)
		MethodTest2.sum(50);
	}
	
}
