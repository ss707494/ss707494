package remeberStudy.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import remeberStudy.ViewReme;
import remeberStudy.Data.Data0;

public class ModifyPanel extends JPanel{
	private Data0 d;
	private JFrame win;
	private TextArea text;
	private JPanel jpB;
	private JButton save,state,rem;
	public ModifyPanel(Data0 d){
		this.d=d;
		win=new JFrame();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(new Dimension(600, 500));
		win.add(this);
		this.setLayout(new BorderLayout());
		text=new TextArea();
		text.setFont(ViewReme.font);
		
		jpB=new JPanel();
		this.add(text);
		this.add(jpB,BorderLayout.SOUTH);
		addState();
		addRem();
		addSave();
		showData();
		win.setLocationRelativeTo(null);
		win.setVisible(true);
	}
	String[] ss={};
	private void showData() {
		ss=d.write();
		for (int i = 0; i < ss.length; i++) {
			text.append("##"+ss[i]+"\n");
		}
	}
	private void addRem() {
		rem=new JButton("remeberF");
		jpB.add(rem);
		rem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double rem=Double.parseDouble(JOptionPane.showInputDialog("rem",d.getRemeberF()));
				d.setRemeberF(rem);
				showData();
			}
		});
	}
	private void addState() {
		state=new JButton("state");
		jpB.add(state);
		state.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int stateNew=Integer.parseInt(JOptionPane.showInputDialog("state",d.getState()));
				d.setState(stateNew);
				showData();
			}
		});
	}
	private void addSave() {
		save=new JButton("save");
		jpB.add(save);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				win.setVisible(false);
				win.dispose();
			}
		});
	}
	
}
