import java.util.Scanner;
class DoWhileEx 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);

		int yesNo=1;
			
		do
		{
			int m5=0, m1=0, c5=0, c1=0, b5=0, b1=0, w5=0, w1=0, w=0 ;
			
			System.out.print("�ݾ��� �Է��ϼ���.?");
			int don = scan.nextInt();			
				
			while(don/50000 > 0){
				don=don-50000;
				m5++;			
			}
			while(don/10000>0){
				don=don-10000;
				m1++;
			}
			while(don/5000>0){
				don=don-5000;
				c5++;
			}
			while(don/1000>0){
				don=don-1000;
				c1++;
			}
			while(don/500>0){
				don=don-500;
				b5++;
			}
			while(don/100>0){
				don=don-100;
				b1++;
			}
			while(don/50>0){
				don=don-50;
				w5++;
			}
			while(don/10>0){
				don=don-10;
				w1++;
			}
			while(don/5>0){
				don=don-5;
				w++;
			}
				
			if(m5 != 0){
				System.out.printf("50000��=%d��\n", m5);
			}
			if(m1 != 0){
				System.out.printf("10000��=%d��\n", m1);
			}
			if(c5 != 0){
				System.out.printf("5000��=%d��\n", c5);
			}
			if(c1 != 0){
				System.out.printf("1000��=%d��\n", c1);
			}
			if(b5 != 0){
				System.out.printf("500��=%d��\n", b5);
			}
			if(b1 != 0){
				System.out.printf("100��=%d��\n", b1);
			}
			if(w5 != 0){
				System.out.printf("50��=%d��\n", w5);
			}
			if(w1 != 0){
				System.out.printf("10��=%d��\n", w1);
			}
			if(w != 0){
				System.out.printf("5��=%d��\n", w);
			}
			if(don != 0){
				System.out.printf("1��=%d��\n", don);
			}

			System.out.print("�ٽ��Ͻðڽ��ϱ�?(1.�� 2.�ƴϿ�)?");
			yesNo = scan.nextInt();
		}
		while (yesNo==1);



	}

}

/*

50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1
����
�ݾ��� �Է��ϼ���.? 123300
50000��=2��
10000��=2��
1000��=3��
100��=3��
�ٽ��Ͻðڽ��ϱ�(1.�� 2.�ƴϿ�)?

�ݾ��� �Է��ϼ���.? 5435
5000��=1��
100��=4��
10��=3��
1��=5��
�ٽ��Ͻðڽ��ϱ�(1.�� 2.�ƴϿ�)?2

*/