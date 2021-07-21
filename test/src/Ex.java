
class Test{}
public class Ex extends Test{
	public static void main(String[] args) {
		Test t1 = new Test();
		Ex e1 = new Ex();
//		try {
//			Ex e2 = (Ex)t1;
//			
//		}catch(Exception e) {
//			System.out.println("Çüº¯È¯");
//			e.printStackTrace();
//		}
		Test t3 = new Ex();
		Ex e2 = (Ex)t3;
		
		
		Object o1 = (Object)t1;
		String s1 = t1.toString();
		Test t2 = (Test)e1;
		System.out.println(t2);
	}
}
