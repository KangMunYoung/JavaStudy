
public class AaaBbbMain {

	public AaaBbbMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		BBB b = new BBB();
		b.output();
		//하위클래스로 객체를 생성하고 상위클래스에 대입된다.
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
