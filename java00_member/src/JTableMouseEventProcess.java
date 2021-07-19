import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.JTextField;

public class JTableMouseEventProcess extends MouseAdapter{
	
	JTextField[] formTf;
	JTable table;
	
	public JTableMouseEventProcess() {
		
	}
	public JTableMouseEventProcess(JTextField[] fomTf, JTable table) {
		this.formTf = fomTf;
		this.table = table;
	}
	
	public void mouseReleased(MouseEvent me) {
		if(me.getButton()==1) {//���ʹ�ư Ŭ���Ǹ�
			//����Ŭ���� ���� ���Ͽ�
			int row = table.getSelectedRow();
			//                  table.getColumnCount()
			for(int col=0; col<formTf.length; col++) {
				if(col==0) {
					formTf[col].setText(String.valueOf(table.getValueAt(row, col)));
					
				}else {
					formTf[col].setText((String)table.getValueAt(row, col));
				}
			}
		}
	}
}
