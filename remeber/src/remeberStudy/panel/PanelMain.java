package remeberStudy.panel;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import remeberStudy.ViewReme;

public class PanelMain extends JPanel implements ActionListener{
	ViewReme win;
	JButton pAdd,pTest,pEdit;
	
	public PanelMain(ViewReme win){
		win.add(this);
		this.win=win;
		this.setLayout(new GridLayout(3,1));
		pAdd=new JButton("ADD");
		pAdd.addActionListener(this);
		pTest=new JButton("TEST");
		pTest.addActionListener(this);
		pEdit=new JButton("EDIT");
		pEdit.addActionListener(this);
		this.add(pAdd);
		this.add(pTest);
		this.add(pEdit);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==pAdd) {
//			JOptionPane.showInputDialog("", "ssssss");
			win.onpanelAdd();
		}
		if (e.getSource()==pTest) {
			win.onpanelTest();
		}
		if (e.getSource()==pEdit){
			win.onpanelEdit();
		}
	}

}
