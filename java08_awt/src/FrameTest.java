import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;

// 컨테이너 Frame 상속받아 구현하기

public class FrameTest extends Frame{

	Point xy = new Point(500,300);
	Dimension wh = new Dimension(500, 300);
	Rectangle rect = new Rectangle(100, 100, 400, 400);
	public FrameTest() {
		//창의 제목
		//setTitle("프레임생성연습중");	//메소드 사용하는 방법
		super("하위에서 제목설정");// Frame(하위에서 제목설정) 생성자 메소드사용
		//창의 크기
		//setSize(500, 400);
//		setSize(wh);
		// 			x	y	w	h
		//setBounds(200, 200, 500, 400);//	->Rectangle	x좌표, y좌표, 폭과 높이
		setBounds(rect);
		//setSize(500,500);//w,h	->Dimension		폭과 높이
		//setLocation(300,300);//x,y	->Point		x좌표와 y좌표
		//창을 보여주기
		
		//타이틀바에 이미지 아이콘 추가하기
//		Toolkit tk = Toolkit.getDefaultToolkit();
//		Image icon = tk.getImage("img/test_img.jpg");
		Image icon = Toolkit.getDefaultToolkit().getImage("img/test_img.jpg");
		setIconImage(icon);
		
		//Button 추가
		Button btn = new Button("버튼");
		add(btn);
		
		Button btn1 = new Button("11111");
		Button btn2 = new Button("22222");
		Button btn3 = new Button("33333");
		Button btn4 = new Button("44444");
		//	"North"
		add(BorderLayout.NORTH, btn1);
		add("South", btn2);
		add(BorderLayout.EAST, btn3);
		add(BorderLayout.WEST, btn4);
		
		
		setVisible(true);//true 보여줌, false 안보여줌
		
		
	}

	public static void main(String[] args) {
		new FrameTest();
	}

}
