package remeberStudy.panel;

import remeberStudy.ConsoleRemeber;
import remeberStudy.Data.Data0;
import remeberStudy.Data.DealData;
import remeberStudy.ViewReme;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * 第二个面板 
 * 测试
 * 
 * @author tarena
 *
 */

public class PanelTest extends JPanel implements ActionListener{
	private ConsoleRemeber con;
	private TextArea ta;
	private JPanel jpt;
	private JButton show,next,preview,exit,speciel;
	private CheckboxGroup cbg;
	private Checkbox cb1,cb2,cb3,cb4;
	private ArrayList<Data0> testList;
	private ViewReme win;
	private int num;
	private String[] ss;

	public PanelTest(ViewReme win){
		this.win=win;
		win.add(this);
		con=win.getCon();
		testList=con.pushList();
		this.setLayout(new GridLayout(2,1));
		ta=new TextArea();
		this.add(ta);
		jpt=new JPanel();
		this.add(jpt);
		show=new JButton("show");
		show.addActionListener(this);
		jpt.add(show);
		cbg=new CheckboxGroup();
		cb1=new Checkbox("1", true, cbg);
		cb2=new Checkbox("2", false, cbg);
		cb3=new Checkbox("3", false, cbg);
		cb4=new Checkbox("4", false, cbg);
		jpt.add(cb1);
		jpt.add(cb2);
		jpt.add(cb3);
		jpt.add(cb4);
		next=new JButton("next");
		next.addActionListener(this);
		preview=new JButton("preview");
		preview.addActionListener(this);
		exit=new JButton("save&exit");
		exit.addActionListener(this);
		speciel=new JButton("speciel");
		speciel.addActionListener(this);
		jpt.add(next);
		jpt.add(preview);
		jpt.add(exit);
		jpt.add(speciel);
		ta.setEditable(false);
//		ta.setSize(new Dimension(ta.getParent().getWidth(), 400));
		ta.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		win.setVisible(true);
		start();
	}
	private void start(){
		num=0;
		if (testList.size()==0) {
			ta.append("no Data !!");
			return;
		}
		ss=testList.get(num).write();
		ta.append(ss[0]+"\n");
		ta.append(ss[1]+"\n");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==exit) {
			try {
				con.inputData();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			win.onMain();
		}
		if(e.getSource()==show){
			ta.append("____\n"+ss[2]);
		}
		if(e.getSource()==next){
			DealData.dealData(testList.get(num),Integer.parseInt(cbg.getSelectedCheckbox().getLabel()));
			if(num>=testList.size()-1) return;
			num++;
			ta.setText(null);
			ss=testList.get(num).write();
			ta.append(ss[0]+"\n");
			ta.append(ss[1]+"\n");
		}
		if(e.getSource()==preview){
			if(num<=0) return;
			num--;
			ta.setText("");
			ss=testList.get(num).write();
			ta.append(ss[0]+"\n");
			ta.append(ss[1]+"\n");
		}
		if(e.getSource()==speciel){
			if(num<=0) return;
			new ModifyPanel(testList.get(num));
		}
	}
	
}
