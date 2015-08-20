package remeberStudy.IO;

import remeberStudy.Data.Data0;
import remeberStudy.Data.DatasQuene;

import java.io.*;
import java.text.SimpleDateFormat;

/**
 * 处理文件的输入输出
 * @author tarena
 *
 */
public class IOfileSS {
	private static SimpleDateFormat SF=new SimpleDateFormat("yyyy-MM-dd");
	/**
	 * 从文件 txt 读取数据 
	 * 并以 Datas 集合形式返回
	 * @return
	 */
	public DatasQuene getDatas(File s){
		DatasQuene d=new DatasQuene();
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream(s)));
			StringBuffer s2 =new StringBuffer() ,s3=new StringBuffer();
			String s1,s4;
			 
			while ((s4=(br.readLine()))!=null) {
				s1=s4;
				if (!s1.toString().startsWith("@")) continue;
				while(!(s4=br.readLine()).startsWith("#")){
					s2.append(s4+"\n");
				}
				s3.append(s4+"\n");
				while(!s3.subSequence(0, s3.length()-1).toString().endsWith("#")){
					s4=br.readLine();
					s3.append(s4+"\n");
				}
//				System.out.println(s2.toString());
//				System.out.println(s3.substring(1, s3.length()-2).toString());
				new Data0(s1, s2.toString().substring(0, s2.length()-1), s3.substring(1, s3.length()-2).toString(),d);
				s2.delete(0, s2.length());
				s3.delete(0, s3.length());
				
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public  void writeData(DatasQuene dq,String file) throws Exception{
		PrintWriter pw=new PrintWriter(new OutputStreamWriter(new FileOutputStream(file)));
		String[] ss=new String[3];
		for (int i = 0; i < dq.datas1.size(); i++) {
			ss=dq.datas1.get(i).write();
			pw.println(ss[0]);
			pw.println(ss[1]);
			pw.println("#"+ss[2]+"#");
		}
		for (int i = 0; i < dq.datas2.size(); i++) {
			ss=dq.datas2.get(i).write();
			pw.println(ss[0]);
			pw.println(ss[1]);
			pw.println("#"+ss[2]+"#");
		}
		for (int i = 0; i < dq.datas3.size(); i++) {
			ss=dq.datas3.get(i).write();
			pw.println(ss[0]);
			pw.println(ss[1]);
			pw.println("#"+ss[2]+"#");
		}
		for (int i = 0; i < dq.datas4.size(); i++) {
			ss=dq.datas4.get(i).write();
			pw.println(ss[0]);
			pw.println(ss[1]);
			pw.println("#"+ss[2]+"#");
		}
		pw.close();
		
	}
	
	public void copyData(String ori ,String goal) throws Exception{
		BufferedInputStream bis=new BufferedInputStream(new FileInputStream(ori));
		BufferedOutputStream bos=new BufferedOutputStream(new FileOutputStream(goal));
		int d=-1;
		while ((d=bis.read())!=-1) {
			bos.write(d);
		}
		bos.close();
		bis.close();
	}
	public static Data0 getOneData(){
		Data0 d=new Data0();
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(new FileInputStream("remeberStudy/Test.txt")));
			String s1,s2,s3;
			while ((s1=br.readLine())!=null) {
				if (!s1.startsWith("@")) continue;
				String[] sA=s1.split("@");
				
				System.out.println(SF.parse(sA[5]));
				d=new Data0();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return d;
	}
	public static void main(String[] args) throws Exception {
	}
}
