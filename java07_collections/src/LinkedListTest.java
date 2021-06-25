import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		start();
	}
	public void start() {
		//LinkedList :	List, Deque, Queue
		//				Queue �϶� �Է¼����� ���� ��� �����Էµ� ��ü�� ��µȴ�.
		//				��µ� ��ü�� �÷��ǿ� ��������.
		//				Deque�϶� ���ʿ��� ��ü�� �Է� �Ǵ� ����Ҽ� �ִ�.
		
		LinkedList<String> ll = new LinkedList();
		
		//��ü�߰�
		ll.offer("ȫ�浿");
		ll.offer(new String("�������"));
		ll.offer(String.valueOf(1234));
		ll.offer(5678+"");
		System.out.println("size="+ll.size());
		//��ü ������
//		String data = ll.pop();	//���� �տ��ִ� ��ü�� ������� �÷��ǿ����� ��������.
//		System.out.println("data="+data);
//		System.out.println("size="+ll.size());
//		System.out.println(ll.isEmpty());
//		System.out.println("data="+data);
		
		//	true:�÷��ǿ� ��ü�� ����. false:�÷��ǿ� �����ִ� ��ü�� �ִ�.
		while(!ll.isEmpty()){
			String data = ll.pop();
			int cnt = ll.size();
			System.out.println(data + ", ������ü��="+cnt);
		}
		
	}
	public static void main(String[] args) {
		new LinkedListTest();
	}

}
