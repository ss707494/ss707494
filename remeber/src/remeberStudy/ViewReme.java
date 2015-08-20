package remeberStudy;

import remeberStudy.panel.Panel1;
import remeberStudy.panel.PanelEdit;
import remeberStudy.panel.PanelMain;
import remeberStudy.panel.PanelTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 主窗口容器 
 * @author tarena
 *
 */

public class ViewReme extends JFrame implements ActionListener{
	private JFrame winEdit;
	private Panel1 panel1;
	private PanelTest panelTest;
	private PanelMain pMain;
	private PanelEdit pEdit;
	private ConsoleRemeber con;
	public static  Font font;

	public ViewReme(ConsoleRemeber con) {
		super();
//		winEdit=new JFrame("Modify");
		this.con = con;
//		System.out.println(con.config.get("font"));
//		font=new Font(con.config.get("font"), Font.PLAIN, 20);
//		UIManager.put("jbutton.font", font);
//		UIManager.put("jpanel.font", font);
//		UIManager.put("jframe.font", font);
//		UIManager.put("textarea.font", font);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension(800, 600));
		this.setLocationRelativeTo(null);
		panel1=new Panel1(this);
		panelTest=new PanelTest(this);
		pEdit=new PanelEdit(this);
		pMain=new PanelMain(this);
		pEdit.setVisible(false);
		pMain.setVisible(true);
		panel1.setVisible(false);
		panelTest.setVisible(false);
		this.setVisible(true);
	}
	public void onMain(){
		pEdit.setVisible(false);
		panel1.setVisible(false);
		panelTest.setVisible(false);
		pMain.setVisible(true);
		
	}
	public void onpanelAdd(){
		pEdit.setVisible(false);
		pMain.setVisible(false);
		panelTest.setVisible(false);
		panel1.setVisible(true);
	}
	public void onpanelTest(){
		pEdit.setVisible(false);
		pMain.setVisible(false);
		panel1.setVisible(false);
		panelTest.setVisible(true);
	}
	public void onpanelEdit(){
		pMain.setVisible(false);
		panel1.setVisible(false);
		panelTest.setVisible(false);
		pEdit.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	public static void main(String[] args) {
		new ViewReme(new ConsoleRemeber());
		
	}
	public ConsoleRemeber getCon() {
		return con;
	}
	
}
