package windowsTest;

import java.awt.TextArea;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileOutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MyNote extends WindowAdapter implements ActionListener{
	JFrame jf;
	JButton jb,jb1;
	JTextArea ta;
	String filename,copy,paste,cut;
	JPanel jp;
	JMenu jmb,jmb2;
	JMenuItem _fm,_fm1,_fm2,_fm3,_fm4,_fe1,_fe2,_fe3,_fe4;
	JMenuBar JMENU;
	JScrollPane jsp;
	
	
	public MyNote() {
		super();
		jp=new JPanel();
		JMENU=new JMenuBar();
		ta=new JTextArea();
		jf=new JFrame();
		jsp=new JScrollPane(ta);
		jf.addWindowListener(this);
		jmb=new JMenu("file");
		jmb2=new JMenu("edit");
		_fm1=new JMenuItem("open");
		_fm1.addActionListener(this);
		_fm2=new JMenuItem("save");
		_fm2.addActionListener(this);
		_fm4=new JMenuItem("save as");
		_fm4.addActionListener(this);
		_fm3=new JMenuItem("close");
		_fm3.addActionListener(this);
		_fm=new JMenuItem("new");
		_fm.addActionListener(this);
		_fe1=new JMenuItem("copy");
		_fe1.addActionListener(this);
		_fe2=new JMenuItem("paste");
		_fe2.addActionListener(this);
		_fe3=new JMenuItem("cut");
		_fe3.addActionListener(this);
		_fe4=new JMenuItem("version");
		_fe4.addActionListener(this);
		jf.setJMenuBar(JMENU);
		jf.setTitle("note");
		
		jmb.add(_fm);
		jmb.addSeparator();
		jmb.add(_fm1);
		jmb.addSeparator();
		jmb.add(_fm2);
		jmb.addSeparator();
		jmb.add(_fm4);
		jmb.addSeparator();
		jmb.add(_fm3);
		
		jmb2.add(_fe1);
		jmb.addSeparator();
		jmb2.add(_fe2);
		jmb.addSeparator();
		jmb2.add(_fe3);
		jmb.addSeparator();
		jmb2.add(_fe4);
		
		JMENU.add(jmb);
		JMENU.add(jmb2);
		
		jb=new JButton("save");
		jb.addActionListener(this);
		jb1=new JButton("close");
		jb1.addActionListener(this);
		jp.add(jb);
		jp.add(jb1);
		jf.add(jp,"South");
		ta.setWrapStyleWord(true);
		jf.add(jsp);
		jf.setSize(600,400);
		jf.setVisible(true);
		int W=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int H=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		jf.setLocation((W-jf.getWidth())/2,(H-jf.getHeight())/2);
		
//		JTextArea ta2=new JTextArea();
//		jf.add(ta2);
//		ta2.setWrapStyleWord(true);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jb||e.getSource()==_fm2) {
			try {
				if (filename==null) {
					filename=JOptionPane.showInputDialog("input name::","java");
					FileOutputStream fout=new FileOutputStream(filename+".txt");
					byte b[]=ta.getText().getBytes();
					fout.write(b);
					fout.close();
					JOptionPane.showMessageDialog(null, "saved!!");
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		if (e.getSource()==_fm) {
			if (!(ta.getText().equals(""))) {
				Object[] opt={"yes","cancel"};
			}
		}
	}
	public static void main(String[] args) {
		new MyNote();
	}


	@Override
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
}
