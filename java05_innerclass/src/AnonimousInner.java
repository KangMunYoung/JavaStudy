
public class AnonimousInner {

	public AnonimousInner() {
		// TODO Auto-generated constructor stub
	}
	public void innerTest() {
		//�͸��� ���� Ŭ���� : Ŭ�������� �������� �ʴ´�
		//					�ٸ� Ŭ������ ��üȭ�ϴ� �������� Ŭ���� �����Ͽ� ���θ����.
		//					zmffotmauddl whswogkwl dksgdmamfh qustnfmf tjsdjsgkftn djqtek.
		new Student() {
			//�����
			String tel ="010-1234-8888";
			//StudentŬ������ print�޼ҵ带 �������̵�
			public void print() {
				System.out.println("num="+num);
				System.out.println("name="+name);
				System.out.println("age="+age);
				System.out.println("tel="+tel);
				
				
			}
		}.print();
	}
	public static void main(String[] args) {

		new AnonimousInner().innerTest();
	}

}
