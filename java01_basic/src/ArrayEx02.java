
public class ArrayEx02 {

	public static void main(String[] args) {
		// 난수 1~1000사이의 값을 100개 만들어 배열에 저장하고
		//난수중 생성된 난수중 제일 큰값과 제일 작은값, 평균을 구하여 출력하라.
		
		//100개 정수를 저장할 배열
		int data[]=new int[100];
		
		for(int i=0; i<data.length; i++) {
			data[i] = (int)(Math.random()*1000)+1;
			System.out.println(data[i]);
		}
		//z큰값 작은값 평균
		int max=data[0];
		int min=data[0];
		int sum=0;
		for(int i=0; i<data.length; i++) {
			sum+=data[i];//합
			if(max<data[i]) {
				max = data[i];
			}
			if(min>data[i]) {
				min=data[i];
			}
		}
		int ave = sum/data.length;
		System.out.println("합="+sum);
		System.out.println("평균="+ave);
		System.out.println("최대값="+max);
		System.out.println("c최소="+min);

	}

}
