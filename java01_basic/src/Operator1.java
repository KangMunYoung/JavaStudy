class Operator1 
{
	public static void main(String[] args) 
	{
		//	������	:���������, ����(��)������, ��������, ���׿�����, ���Կ�����, ����Ʈ ������, ���׿�����
		//	1. ���������: +, -, *, /(��, �Ǽ�), %(������)

		
		int num1 = 10;
		int num2 = 3;

		int result = num1 % num2;

		System.out.println("result = " + result);

		//	2. ���׿����� : ++(1����), --(1����)

		int a = 10;
		a = a + 1;	// 1���� �ϴ� ����
		System.out.println("a="+a);
		
		//a++;		//1���� �ϴ� ����
		++a;
		System.out.println("a=" + a);

		//--a;		//	a = a - 1;
		a--;		//1 �����ϴ� ����
		System.out.println("a=" +a);	//	11

		int b = a++;	//	11, 12
		System.out.println("b=" + b + ", a=" + a);
		int c = ++a;	//	13, 13
		System.out.println("c=" + c + ", a=" + a);

		int result2 = b + ++c;
		System.out.println("result2 ="+result2 + ", c="+c);


		//	3. ���Կ�����
		// a = 13	/17
		a += 4;	//	a = a + 4;	a+=1;	a=a+1;

		// b = 11	/8
		b -= 3;	//	b = b - 3;

		// c = 14 /28
		c *= 2;	//	c = c * 2;

		System.out.println("a = " +a + ", b = " +b + ", c = " +c);

		c += a+b;
		System.out.println("c="+c);

		int x = 200;
		int y = 300;
		//	�񱳿����� : >, >=, <, <=, == , !=
		boolean boo = x > y;	//boo = false
		boolean boo2 = x < y;	//boo2 = true
		System.out.println("boo = " +boo);
		System.out.println("boo2 = " +boo2);
	
		//�޿��� 10000�� �̻��϶� ���ʽ� 50%
		//�޿��� 10000�� �̸��϶� ���ʽ� 90% ���� ��� ���ʽ��� ������ ����϶�.
		int sal = 10000;	//�޿�
		//	���= (���ǽ�)? ���϶� : �����϶�
		double bonus = (sal >=10000)? sal*0.5 : sal*0.9;
		System.out.println("sal="+sal + ", bonus ="+bonus);

		//�� ������ : &&(and), ||(or), !(not)
		int ave = 75;
		String grade = (ave>=70 && ave<80)? "c" : "�׿�" ;
		System.out.println("grade = " + grade);


		char ch = 'A'; // char ������ �����ϴ�
		// ch++; ch+=1;
		ch = (char)(ch + 1);
		System.out.println("ch="+ch);
		
		char ch2 = (char)85;
		System.out.println("ch2 = " +ch2);

	}
}
