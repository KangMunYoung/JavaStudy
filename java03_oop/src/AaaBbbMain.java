
public class AaaBbbMain {

	public AaaBbbMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BBB b = new BBB();
		b.output();
		//����Ŭ������ ��ü�� �����ϰ� ����Ŭ������ ���Եȴ�.
		AAA a = new BBB();
		a.output();
		
		//System.out.println("b.tel="+b.tel);
		//System.out.println("a.tel="+a.tel);
		//System.out.println("a.tel="+a.name);
		//System.out.println("a.num="+a.num);
		
		BBB c=(BBB)a;
		c.output();
		
		Object obj = new BBB();
		BBB d = (BBB)obj;
		d.output();
	}
	
	

}
