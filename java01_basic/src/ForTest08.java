import java.util.Scanner;
class ForTest08 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		for(;;){
			//�޴�
			System.out.print("�޴�[1.�簢���� ����, 2.���� ����, 3.����]?");
			int num = scan.nextInt();
			
			//�Է�
			if(num == 1){
				System.out.print("����=");
				int w = scan.nextInt();
				System.out.print("����=");
				int h = scan.nextInt();
				int rect = w * h;
				System.out.println("�簢���� ����="+ rect);
			}else if(num ==2) {
				System.out.print("������=");
				int r = scan.nextInt();
				double circle = r * r * 3.141592;
				System.out.println("���� ����="+ circle);
			}else if(num ==3){
				System.exit(0);
			}else{
				System.out.println("�޴��� �ٽü����ϼ���...");
			}
		}//for

	}
}
/*
�簢���� ���� = ���� * ����
���� ���� = ������ * ������ * 3.141592

����
�޴�[1.�簢���� ���� 2.���� ����]? 1

����=
����
�簢���� ����=

�޴�[1.�簢���� ���� 2.���� ����]? 2
������=
���� ����=

�޴�[1.�簢���� ���� 2.���� ����]? 3

*/