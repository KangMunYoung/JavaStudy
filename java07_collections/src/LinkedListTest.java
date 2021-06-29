import java.util.LinkedList;

public class LinkedListTest {

	public LinkedListTest() {
		start();
	}
	public void start() {
		//LinkedList :	List, Deque, Queue
		//				Queue 일때 입력순서를 유지 출력 먼저입력된 객체가 출력된다.
		//				출력된 객체는 컬렉션에 지워진다.
		//				Deque일때 양쪽에서 객체를 입력 또는 출력할수 있다.
		
		LinkedList<String> ll = new LinkedList();
		
		//객체추가
		ll.offer("홍길동");
		ll.offer(new String("세종대왕"));
		ll.offer(String.valueOf(1234));
		ll.offer(5678+"");
		System.out.println("size="+ll.size());
		//객체 얻어오기
//		String data = ll.pop();	//제일 앞에있는 객체가 얻어지고 컬렉션에서는 지워진다.
//		System.out.println("data="+data);
//		System.out.println("size="+ll.size());
		// System.out.println(ll.isEmpty());
//		System.out.println("data="+data);
		
		//	true:컬렉션에 객체가 없다. false:컬렉션에 남아있는 객체가 있다.
		while(!ll.isEmpty()){
			String data = ll.pop();
			int cnt = ll.size();
			System.out.println(data + ", 남은객체수="+cnt);
		}
		
	}
	public static void main(String[] args) {
		new LinkedListTest();
	}

}
