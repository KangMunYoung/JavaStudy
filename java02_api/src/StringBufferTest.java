
public class StringBufferTest {

	public StringBufferTest() {
		start();
	}

	
	public void start() {
		StringBuffer sb1 = new StringBuffer();//16byte
		StringBuffer sb2 = new StringBuffer(100);//100byte
		
		//append(): ���ڿ��߰�
		sb1.append("buffer append Test..");
		sb1.append(123456);
		
		//insert(): index��ġ ���� ����
		sb1.insert(5, "(��Ʈ������)");
		sb1.insert(15, 23236.21542554);
		//
		//buffe(��Ʈ������)r a23236.21542554ppend Test..123456
		//delete(): 
		//deleteCharAt():
		sb1.deleteCharAt(6);
		//buffe(Ʈ������)r a23236.21542554ppend Test..123456
		
		sb1.delete(1, 4);// index 1���� 4���� �����
		//be(Ʈ������)r a23236.21542554ppend Test..123456
		
		sb1.replace(1, 3, "(�ڹ�)");//index 1���� 3�ձ��� "(�ڹ�)"�� ġȯ
		//b(�ڹ�)Ʈ������)r a23236.21542554ppend Test..123456
		
		sb1.reverse();
		
		//Ȯ���� ���� Ȯ��
		System.out.println("sb1.capacity="+ sb1.capacity());
		System.out.println("sb2.capacity="+ sb2.capacity());
		System.out.println(sb1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new StringBufferTest();
	}

}
