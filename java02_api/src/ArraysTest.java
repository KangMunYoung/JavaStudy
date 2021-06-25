import java.util.Arrays;

public class ArraysTest {

	public ArraysTest() {
		// Arrays : 배열관련 처리 클래스
		int[] data = {15,90,45,75,26,9,48,95,12,40};
		//Arrays.sort(data);//모두정렬
		Arrays.sort(data, 2, 5);//부분정렬
		
		System.out.println(Arrays.toString(data));
		
	}

	public static void main(String[] args) {
		new ArraysTest();
	}

}
