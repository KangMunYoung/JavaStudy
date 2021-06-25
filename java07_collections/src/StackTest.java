import java.util.Stack;

public class StackTest {

	public StackTest() {
		Stack<String> stack = new Stack<String>();
		
		//stack �� ���� �Էµ� ������ ���߿� ��µȴ�.(FILO : first in last out)
		//queue : FIFO
		//push() �Է�, pop: ���
		
		stack.push("HongKilDong");
		stack.push("munmun");
		stack.push("LeeSunSin");
		stack.push("JangYoungSil");
		
		
		//empty() stack ��ü ������ false, ��ü�� ���� �� true
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		 
	}

	public static void main(String[] args) {
		new StackTest();

	}

}
