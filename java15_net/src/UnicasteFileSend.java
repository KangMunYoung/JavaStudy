import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class UnicasteFileSend extends JFrame implements ActionListener{
	JButton btn = new JButton("���Ϻ�����");
	public UnicasteFileSend() {
		add(btn);
		setSize(500,500);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		btn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae) {
		JFileChooser fc = new JFileChooser();
		int state = fc.showOpenDialog(this);
		if(state==0) {
			try {
				DatagramSocket ds = new DatagramSocket();
				InetAddress ia = InetAddress.getByName("192.168.0.17");
				
				File f = fc.getSelectedFile();//��� + ���ϸ�
				FileInputStream fis = new FileInputStream(f);
				String fileName = "FN##" + f.getName();//���ϸ�
				
				//���ϸ��� ������
				DatagramPacket dp = new DatagramPacket(fileName.getBytes(), fileName.getBytes().length,ia,16000);
				ds.send(dp);
				
				while(true) {
					//���ϳ��� ������ $%#$
					byte[] fileContent = new byte[1024];
//					byte[] fileContent = new byte[512];
					fileContent[0]='$';
					fileContent[1]='%';
					fileContent[2]='#';
					fileContent[3]='$';
					
					int cnt = fis.read(fileContent, 4, 1020);
					if(cnt<=0)break;
					dp = new DatagramPacket(fileContent, cnt+4, ia, 16000);
					ds.send(dp);
					System.out.println("cnt==>"+cnt+"bytes");
					
				}
				fis.close();
				//������ �޼��� ������
				dp=new DatagramPacket("^%$&".getBytes(), 4, ia, 16000);
				ds.send(dp);
				ds.close();
				System.out.println("�������� �Ϸ�");
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		}
	}
	
	public static void main(String[] args) {
		new UnicasteFileSend();
	}

}

/*
 * public class UnicasteFileRecive {

    DatagramSocket ds;
    DatagramPacket dp;

    public UnicasteFileRecive(){
        receiveStart();
    }

    public void receiveStart(){
    try{
        ds = new DatagramSocket(16000);
        byte[] data = new byte[512];
        dp = new DatagramPacket(data,data.length);
        FileOutputStream fos =null;

        while (true)
        {
            System.out.println("�ޱ� �����");
            ds.receive(dp);

            byte[] receiveDate = dp.getData();
            int len = dp.getLength();

            String part = new String(receiveDate,0,4);
            if(part.equals("FN##")) {
                String filename = new String(receiveDate, 4, len - 4);
                System.out.println("filename-->" + filename);
                fos = new FileOutputStream(new File("C://Users/D-Kwon/Pictures", filename));
                System.out.println("io ��ü ������.");
            }else if(part.equals("$%#$")){
                if(fos!=null)
                {
                    fos.write(receiveDate,4,len-4);
                }
            }else if(part.equals("^%$&")){
                fos.close();
                ds.close();
                System.out.println("���Ϲޱ� �Ϸ��߽��ϴ�.");
            }

        }
            //������ ������ ���ϸ�, ���ϳ���, ������ ǥ������ Ȯ��!

    }catch (Exception e)
    {
     e.printStackTrace();
    }

    }

    public static void main(String[] args) {
        new UnicasteFileRecive();
    }
}

 */




