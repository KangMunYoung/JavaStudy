import java.util.Scanner;
class IfElseIf 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		/*
			�޿��� �Է¹޾� �޿���		10000 ~ 20000�̸� ���ʽ�	20%����
								20000 ~ 30000			15%
								30000 ~ 40000			10%
								40000 ~ 50000			5%
								�׿�						0%
		*/
		
		//1. �޿��Է�
		System.out.print("�޿��� �Է��ϼ���?-->");
		int sal = scan.nextInt();
		
		int bonus = 0;

		if(10000<= sal && sal <=20000){
			bonus = (int)(sal * 0.2);
		}else if(20000 < sal && sal <=30000){
			bonus = (int)(sal * 0.15);
		}else if(30000 < sal && sal <= 40000){
			bonus = (int)(sal * 0.1);
		}else if(40000 < sal && sal <= 50000){
			bonus = (int)(sal * 0.05);
		}
		
		System.out.printf("�޿�=%d, ���ʽ�=%d\n", sal, bonus);
	}
}
/*
	if ~ elseif��

	if(���ǽ�){
		 ���๮;
		 ���๮;
	}elseif(���ǽ�){
		 ���๮
		 ���๮
	}elseif(���ǽ�){
		 ���๮
		 ���๮			 
	}elseif(���ǽ�){
		 ���๮
		 ���๮
	}else
*/