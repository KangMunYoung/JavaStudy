
//	�߻�޼ҵ带 1�� �̻� �����ϴ� Ŭ������ �߻�Ŭ����
//	�߻�Ŭ������ class Ű���� ���ʿ� abstract�� ǥ���Ͽ��� �Ѵ�.
//	�߻�Ŭ������ �ݵ�� ��ӹ޾� �߻�޼ҵ带 ��� �������̵� �Ͽ��� �Ѵ�.
public abstract class AbstractTest {
	int num = 100;
	String name = "ȫ�浿";
	public AbstractTest() {
		
	}
	public void numOutput() {
		System.out.println("num="+num);
	}
	
	//����ΰ����� �޼ҵ�� �߻�޼ҵ��̴�.
	//�߻�޼ҵ�� ��ȯ�� ���ʿ� abstract Ű���带 ǥ���Ͽ��� �Ѵ�.
	public abstract void print();
	public abstract void setData(int num, String name);
}
