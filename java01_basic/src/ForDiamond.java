import java.util.Scanner;
class ForDiamond
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		//입력
		System.out.print("임의의 홀수입력(1~49)=");
		int num = scan.nextInt();
		
		char text = 'A';
		//홀수확인 짝수라면 +1
		if(num%2==0){
			num+=1;
		}
		
		//계산 시작
		for(int i=1; i<=num; i+=2){
			for(int s=1; s<=(num-i)/2; s++){
				System.out.print(" ");
			}
			for(int t=1; t<=i; t++){
				System.out.printf("%c",text);
				text+=1;
				if(text>'Z'){
					text='A';
				}
			}
			System.out.println();
		}
		
		for(int j=num-2; j>=1; j-=2){
			for(int s=1 ; s<=(num-j)/2; s++){
				System.out.print(" ");
			}
			for(int t=1; t<=j; t++){
				System.out.printf("%c",text);
				text+=1;
				if(text>'Z'){
					text='A';
				}
			}
			System.out.println();
		}
		
	}
}







/*
		for(int i=11; i>=0; i-=2){
			for(int s=11; s>=(0+i)/2; s--){
				System.out.print(" ");
			}
			for(int x=1; x<=i; x++){
				System.out.print("*");
			}
			System.out.println();
		}
/*
		1234567	1
		123A	2
		12BCD	3
		1EFGHI	4
		JKLMNOP	5
		 QRSTU	6
		  VWX	7
		   Y	8



*/
