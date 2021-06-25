
public class ArrayCopyTest {

	public static void main(String[] args) {
		//배열의 복사
		int num[]= {1,2,3,4,5,6,7,8,9,0};
		//			원본배열명		복사시작index	복사할곳의 배열명	복사위치index		복사할 데이터의 개수
		//arraycopy(Object src, int srcPos, Object dest,	 int destPos, int length)
		//			num			num[2]		target			target[5]		3				
		//num배열에서 index 2에서부터 3개만 복사를 하여 새로운 배열에 대입하겠다.
		int target[]=new int[10];
		
		System.arraycopy(num, 2, target, 5, 3);
		
		for(int i=0; i <target.length; i++ ) {
			System.out.println("target["+i+"]"+target[i]);
		}
		

	}

}
