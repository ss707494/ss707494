package remeberStudy.panel;

import remeberStudy.ConsoleRemeber;
import remeberStudy.Data.Data0;
import remeberStudy.ViewReme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelEdit extends JPanel implements ActionListener{

	ConsoleRemeber con;
	ArrayList<Data0> list;
	String[] ss={};
	ViewReme win;
	TextArea textShow;
	JPanel jpB;
	JButton state1,state2,state3,state0,state4,select,exit;
	public PanelEdit(ViewReme win) {
		win.add(this);
		this.win=win;
		this.setLayout(new BorderLayout() );
		con=win.getCon();
		textShow=new TextArea();
		this.add(textShow);
		textShow.setFont(win.font);
		
		jpB=new JPanel();
		state1=new JButton("1");
		state2=new JButton("2");
		state3=new JButton("3");
		state0=new JButton("0");
		state4=new JButton("4");
		state4.addActionListener(this);
		state1.addActionListener(this);;
		state2.addActionListener(this);
		state3.addActionListener(this);
		state0.addActionListener(this);
		jpB.add(state1);
		jpB.add(state2);
		jpB.add(state3);
		jpB.add(state0);
		jpB.add(state4);
		this.add(jpB,BorderLayout.SOUTH);
		add1();
		list=new ArrayList<Data0>();
		show(1);
		win.setVisible(true);
	}
	private void add1(){
		select=new JButton("Select");
		select.addActionListener(this);
		exit=new JButton("Exit&Save");
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					con.backUp();
					con.inputData();
					win.onMain();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		jpB.add(select);
		jpB.add(exit);
		
	}
	
	private void show(int n){
		list=con.pushList(n);
		textShow.setText(null);
		for (int i = 0; i < list.size(); i++) {
			ss=list.get(i).write();
			textShow.append("________\n"+(i)+"\n");
			textShow.append(ss[0]+"\n");
			textShow.append(ss[1]+"\n");
			textShow.append("##"+ss[2]+"\n");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==state1) {
			show(1);
		}
		if (e.getSource()==state2) {
			show(2);
		}
		if (e.getSource()==state3) {
			show(3);
		}
		if (e.getSource()==state0) {
			show(0);
		}
		if (e.getSource()==state4) {
			show(4);
		}
		if (e.getSource()==select) {
			int num=Integer.parseInt(JOptionPane.showInputDialog("input num"));
			if (num>list.size()) {
				return;
			}
			new ModifyPanel(list.get(num));
			
		}
	}

}
