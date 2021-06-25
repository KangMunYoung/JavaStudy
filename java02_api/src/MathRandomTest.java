
public class MathRandomTest {

	public static void main(String[] args) {
		// 난수 : 컴퓨터가 실행되는 시점에 0.0과 1.0사이의 값이 생성된다.
		
		//	100 -> 0~99,		50-> 0~49
		//		->50~100		공식 => 큰값-작은값+1
		for(int i=1; i<=1000; i++) {
			double ran = Math.random();
			//			(정수화)(난수*(큰값-작은값+1))+작은값
			int ranInt=(int)(ran*(100-50+1))+50;
			
			System.out.print(ranInt+"\t");
			if(i%10 == 0)System.out.println();
		}

	}

}
