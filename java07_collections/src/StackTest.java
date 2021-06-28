import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<String> stack = new Stack<String>();
		
		//stack 은 멈저 입력된 정보가 나중에 출력된다.(FILO : first in last out)
		//queue : FIFO
		//push() 입력, pop: 출력
		
		stack.push("HongKilDong");
		stack.push("munmun");
		stack.push("LeeSunSin");
		stack.push("JangYoungSil");
		
		
		//empty() stack 객체 있으면 false, 객체가 없을 때 true
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		 
	}

	public static void main(String[] args) {
		new StackTest();

	}

}
