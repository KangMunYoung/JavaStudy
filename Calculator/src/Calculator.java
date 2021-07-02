import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JFrame {
	String text = "";
	
	JPanel pane = new JPanel();
	JPanel topPane = new JPanel(new GridLayout(1,3));
	JPanel centerPane = new JPanel(new GridLayout(4,4));
	
	JLabel lbl = new JLabel("0", JLabel.RIGHT);
	
	JButton btn1 = new JButton("1");
	JButton btn2 = new JButton("2");
	JButton btn3 = new JButton("3");
	JButton btn4 = new JButton("4");
	JButton btn5 = new JButton("5");
	JButton btn6 = new JButton("6");
	JButton btn7 = new JButton("7");
	JButton btn8 = new JButton("8");
	JButton btn9 = new JButton("9");
	JButton btn0 = new JButton("0");
	JButton btnPlus = new JButton("+");
	JButton btnMinus = new JButton("-");
	JButton btnMul = new JButton("*");
	JButton btnDiv = new JButton("/");
	JButton btnPoint = new JButton(".");
	JButton btnResult = new JButton("=");
	
	JButton btnBackSpace = new JButton("BackSpace");
	JButton btnClear = new JButton("Clear");
	JButton btnEnd = new JButton("End");
	
	public Calculator() {
		super("계산기");
		lbl.setFont(new Font("굴림체", Font.PLAIN, 40));
		lbl.setPreferredSize(new Dimension(500,40));
		add(lbl, BorderLayout.NORTH);
		
		add( pane);
		pane.add(BorderLayout.NORTH, topPane);
		
		topPane.add(btnBackSpace);
		topPane.add(btnClear);
		topPane.add(btnEnd);
		centerPane.setLayout(new BoderLayout());
		pane.add(centerPane, BorderLayout.CENTER );
		centerPane.add(btn7);
		centerPane.add(btn8);
		centerPane.add(btn9);
		centerPane.add(btnPlus);
		centerPane.add(btn4);
		centerPane.add(btn5);
		centerPane.add(btn6);
		centerPane.add(btnMinus);
		centerPane.add(btn1);
		centerPane.add(btn2);
		centerPane.add(btn3);
		centerPane.add(btnMul);
		centerPane.add(btn0);
		centerPane.add(btnPoint);
		centerPane.add(btnResult);
		centerPane.add(btnDiv);
		
		
		
//		pane.add(layout, BorderLayout.NORTH);
//		setLayout(layout);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	public static void main(String[] args) {
		new Calculator();
	}

}
