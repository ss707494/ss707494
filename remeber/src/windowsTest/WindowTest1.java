package windowsTest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class WindowTest1 extends JFrame implements ActionListener{
	JFrame jf0;
	JP1 jp1;
	
	public WindowTest1()  throws Exception {
		super();
		jf0=new JFrame("TEST");
		jf0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf0.setSize(new Dimension(800, 600));
		jf0.setLocationRelativeTo(null);
		jf0.setVisible(true);
		
	}
	public static void main(String[] args) throws Exception {
		new WindowTest1();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		jp1.jp1_1=null;
		
	}

}
class JP1 extends JPanel{
	JPanel jp1_1;
	JPanel jp1_2;
	JPanel jp1_3;
	JP1(JFrame jf){
		jp1_1=new JPanel();
		jp1_2=new JPanel();
		jp1_3=new JPanel();
		this.setLayout(null);
		jf.add(this);
		this.add(jp1_1);
		this.add(jp1_2);
		this.add(jp1_3);
		jp1_1.setBounds(0, 0, jf.getWidth(), 50);
		jp1_2.setBounds(0, jp1_1.getHeight(), jf.getWidth(), 275);
		jp1_3.setBounds(0, jp1_1.getHeight()+jp1_2.getHeight(), jf.getWidth(), 275);
		jp1_1.setBackground(Color.lightGray);
		jp1_2.setBackground(Color.blue);
		jp1_3.setBackground(Color.orange);
		jp1_1.setLayout(new GridLayout(1,2));
		jp1_1.add(new Button("s"));
		jp1_1.add(new Button("T"));
		new Button().addActionListener((ActionListener)jf);
	}
	
}
