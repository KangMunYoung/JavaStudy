
class ClassA{
	public int getValue() {
		int value = 0;
		boolean setting = true;
		String title ="Hello";
		int result=0;
		if(value == 0 || (setting && title =="Hello")) { result=1;}
		if(value == 1 & title.equals("Hello")) { result = 2;}
		return result;
	}
}
public class ClassB  {
	public static void main(String[] args) {
		ClassA a = new ClassA();
		System.out.println(a.getValue());
	}
}
