//Ŭ�������� interface�� ��ӹ������ impliements Ű���带 �̿��Ѵ�.
//		  interface�� ������ ��ӹ����� �ִ� ->�������Ѿ���
//		  ��ӹ��� ��� �߻�޼ҵ�� �������̵��� �Ͽ����Ѵ�.
public class InterfaceMain implements InterfaceTest1, InterfaceTest2 {

	public InterfaceMain() {

	}
	//�߻�޼ҵ� �������̵�
	public void output() {}
	public int sum() {
		return 5050;//1~100������
	}
	
	public void oddSum() {
		int sum=0;
		for(int i=1; i<=MAX; i+=2) {
			sum+=i;
		}
		System.out.println("1~"+MAX+"������ ����"+sum);
	}
	
	public int evenSum() {
		int sum=0;
		for(int i=2; i<=MAX; i+=2) {
			sum+=i;
		}
		return sum;
	}
	public void resultPrint(int data) {
		System.out.println("�����="+data);
	}
	
	
	
	public void start() {
		resultPrint(sum());//��1~100 ������� 505
		oddSum();//1~100���� Ȧ���� 2500
		resultPrint(evenSum());// 1~100 ¦����
	}
	public static void main(String[] args) {
		new InterfaceMain().start();
		
	}

}
