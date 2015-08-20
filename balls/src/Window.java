import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Window extends JPanel implements ActionListener{
	static String s;
	static JTextField txt3;
	public Window() {
		JFrame win=new JFrame();
		win.setSize(800,600);
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setLocationRelativeTo(null);
		win.add(this);
		this.setBackground(Color.white);
		this.repaint();
	}
	public static void main(String[] args) {
		Window w=new Window();
		txt3=new JTextField("",40);
		JButton bu=new JButton("an");
		bu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				s=txt3.getSelectedText();
				System.out.println(s);
			}
		});
		w.add(bu);
		w.add(txt3);
		System.out.println(Arrays.toString("sdfsasdfaljkaaa".split("a")));
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

}
