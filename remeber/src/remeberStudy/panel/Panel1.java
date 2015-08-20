package remeberStudy.panel;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import remeberStudy.ConsoleRemeber;
import remeberStudy.ViewReme;
/**
 * 第一个面板 
 * 用来添加数据
 * @author tarena
 *
 */

public class Panel1 extends JPanel implements ActionListener{
	private TextArea textQue;
	private TextArea textAns;
	private JButton btnAdd,btnSave;
	private CheckboxGroup cbg;
	private Checkbox cb1_4,cb1_1,cb1_2,cb1_3;
	private JPanel jpB;
	private ConsoleRemeber con;
	private ViewReme win;
	
	public Panel1(ViewReme win){
		this.win=win;
		win.add(this);
		this.setLayout(new GridLayout(3,1));
		textQue=new TextArea();
		textAns=new TextArea();
		textQue.setFont(win.font);
		textAns.setFont(win.font);
		this.add(textQue);
		this.add(textAns);
		jpB=new JPanel();
		btnAdd=new JButton("ADD");
		cbg=new CheckboxGroup();
		
		cb1_4=new Checkbox("4",cbg,true);
		cb1_1=new Checkbox("1",cbg,true);
		cb1_2=new Checkbox("2",cbg,false);
		cb1_3=new Checkbox("3",cbg,false);
		jpB.add(cb1_4);
		jpB.add(cb1_1);
		jpB.add(cb1_2);
		jpB.add(cb1_3);
		jpB.add(btnAdd);
		btnSave=new JButton("Save&Exit");
		jpB.add(btnSave);
		btnSave.addActionListener(this);
		this.add(jpB);
		btnAdd.addActionListener(this);
		win.setVisible(true);
		con=win.getCon();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==btnAdd) {
			Calendar calrem=Calendar.getInstance();
			calrem.add(Calendar.DAY_OF_MONTH, 2);
//			System.out.println(cbg.getSelectedCheckbox().getLabel());
			int state=Integer.parseInt(cbg.getSelectedCheckbox().getLabel());
			String s2=textQue.getText();
//			System.out.println(s2.isEmpty());
			String s3=textAns.getText();
			if(s2.isEmpty()||s3.isEmpty()) return;
			if (state==4) {
				int sp=Integer.parseInt(JOptionPane.showInputDialog("Space",1));
                con.addNewData(Calendar.getInstance(), state, sp, 1, calrem, s2, s3);
                textQue.setText("");
    			textAns.setText("");
                return;
			}
//			con.addNewData(s2, s3, state);
			con.addNewData(Calendar.getInstance(), state, 0, 1, calrem, s2, s3);
			textQue.setText("");
			textAns.setText("");
		}	
		if (e.getSource()==btnSave) {
			try {
				con.backUp();
				con.inputData();
				win.onMain();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
