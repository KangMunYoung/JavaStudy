
public class ArrayTest01 {

	public static void main(String[] args) {
		// 배열은 같은 데이터형의 변수를 여러개 선언할 때 필요하다.
		
		//배열의 선언(1차원배열)
		int[] data;//메모리 할당 x
		int num[] = new int[5];//정수:0 실수:0,0 논리형:false
		
		String name[] = new String [5]; //null
		
		num[2] = 100;
		name[1] = "홍길동";
		
		System.out.println("num[1]=>"+ num[1]);
		System.out.println("name[1]=>" + name[1]);
		
		//num배열의 모든값을 출력하라
		// 	num[*], num[*], num[*], num[*], num[*]
		// 배열명.length -> 배열의 개수를 구하여 준다.
		for(int i=0; i<num.length; i++) {
			System.out.println("num["+i+"]="+	num[i]);
		}
		
		//배열 생싱서 초기값 설정하는 방법 1
		int[] data2 = new int[] {20, 65, 74, 5, 87,2};
		for(int i=0; i<data2.length; i++) {
			System.out.println("data2["+i+"]="+data2[i]);
		}
		
		//배열 생성시 초기값 설정하는 방법 2
		int data3[]= {8,7,65,4,3};
		for(int i=0; i<data3.length; i++) {
			System.out.println("data3["+i+"]="+data3[i]);
		}
	}

}
