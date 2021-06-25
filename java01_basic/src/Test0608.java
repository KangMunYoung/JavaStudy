/*
import java.util.Scanner;
class ForDiamondTest 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//입력
		System.out.print("임의의 홀수입력(1~49)=");
		int max = scan.nextInt();
		
		
		
		if(max%2==0){//홀수확인 짝수라면 +1
			max+=1;
		}
		char txt = 'A';
		int step = 2;
		for(int row=1; row>0; row+=step){// 1,3,5,7,9, 11,..... max
			
			for(int s=1; s<=(max-row)/2; s++){//공백처리
				System.out.print(" ");
			}
			for(int cnt=1; cnt<=row; cnt++){//1줄문자 출력
				System.out.print(txt++);
				if(txt > 'Z'){//	'Z'를 출력하고 나면 'A'를 출력한다.
					txt = 'A';
				}
			}
			System.out.println();
			if(row>max){
				step=-2;
			}
		}
	}
}
*/