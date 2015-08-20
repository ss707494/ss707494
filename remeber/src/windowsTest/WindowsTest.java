package windowsTest;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;

public class WindowsTest {
	JFrame viewJFrame;
	public void creatWindow(){
		viewJFrame=new JFrame("Test");
		viewJFrame.setSize(new Dimension(800, 600));
		viewJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		viewJFrame.setVisible(true);
		viewJFrame.setLayout(new GridLayout(4,4,4,4));
		viewJFrame.setLocationRelativeTo(null);
		viewJFrame.add(new Button("1"));
		viewJFrame.add(new Button("1"));
		viewJFrame.add(new Button("1"));
		viewJFrame.add(new Button("1"));
		viewJFrame.add(new Button("1"));
		viewJFrame.add(new Button("1"));
		viewJFrame.add(new Button("1"));
	}
	public static void main(String[] args) {
		new WindowsTest().creatWindow();
		
	}

}
