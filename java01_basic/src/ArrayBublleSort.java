
public class ArrayBublleSort {

	public static void main(String[] args) {
		
		int num[] = new int[10];
		
		//난수 생성
		for(int i=0; i<num.length; i++) {
			int random = (int)(Math.random()*100)+1;
			num[i]=random;
		}
		System.out.println();
		
		System.out.println("========================");
		
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i]+", ");
		}
		System.out.println();
		
		for(int j=0; j<num.length-1; j++) {
			for(int i=0; i<num.length-1; i++) {
				if(num[i]>num[i+1]) {
					// 교환하기
					int temp = num[i];
					num[i] = num[i+1];
					num[i+1] = temp;
				}
			}
		}
		
		for(int i=0; i<num.length; i++) {
			System.out.print(num[i]+", ");
		}
		System.out.println();
	}

}
