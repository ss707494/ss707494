package remeberStudy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import remeberStudy.Data.Data0;
import remeberStudy.Data.DatasQuene;
import remeberStudy.IO.IOfileSS;

/**
 * 控制台 处理数据
 * 包括从文件读取 
 *   和 发送给窗口输出
 *   以及 对数据进行修改 并 储存
 * @author tarena
 *
 */
public class ConsoleRemeber {
	private SimpleDateFormat SF;
	static  Calendar TODAY;
	Path path;

	IOfileSS iofileSS;
	DatasQuene dq;
	HashMap<String, String> config;
	{
		Calendar c=Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.clear(Calendar.MINUTE);
		c.clear(Calendar.SECOND);
		TODAY=c;
	}
	
	/**
	 * 构造器
	 */
	public ConsoleRemeber() {
		SF=new SimpleDateFormat("yyyy-MM-dd");
		iofileSS=new IOfileSS();
		path = new Path();
		try {
			config=ConfigAction.loadConfig(path.getpath("config.xml"));
			dq=iofileSS.getDatas(new File(path.getpath("Test.txt")));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 添加新数据
	 * @param que
	 * @param ans
	 * @param state
	 */
	public void addNewData(Calendar firstTime,int state,double rem,int times,Calendar date,String que,String ans){
		String s1="@"+new SimpleDateFormat("yyyyMMddHH").format(firstTime.getTime())+"@"+state+"@"+rem+"@"+times+"@"+SF.format(date.getTime());
		new Data0(s1, que, ans, dq);
	}
	/**
	 * 将数据写入
	 * @throws Exception
	 */
	public void inputData() throws Exception{
		iofileSS.writeData(dq,path.getpath("Test.txt"));
	}
	
	
	
	/**
	 * 备份数据 ,将元数据备份至packup文件夹
	 * packup文件夹中有5个文件
	 * 每次会自动删除最早的备份
	 * @param file
	 * @param backfile
	 * @param con
	 * @throws Exception 
	 * @throws Exception
	 */
	public void backUp() throws Exception{
		backUp(path.getpath("Test.txt"), path.getpath("packup"), path.getpath("packup/packupfile.properties"));
	}
	public void backUp(String file,String backfile,String con) throws Exception{
        String sca=new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss").format(new Date());
        Properties po=new Properties();
        po.load(new FileInputStream(con));
        iofileSS.copyData(file, backfile+"/"+sca);
        new File(po.getProperty("t"+5)).delete();
        for (int i = po.size(); i >1 ; i--) {
//			System.out.println(po.getProperty("t"+(i-1)));
			po.setProperty("t"+i, po.getProperty("t"+(i-1)));
		}
		po.setProperty("t1", backfile+"/"+sca);
		po.store(new FileOutputStream(con),sca);
	}

	
	/**
	 * 取出datatoday集合元素
	 * @return
	 */
	public ArrayList<Data0> pushList(){
		ArrayList<Data0> list=new ArrayList<Data0>();
		System.out.println(dq);
		list=dq.dataToday;
		return list;
	}
	public ArrayList<Data0> pushList(int n){
		ArrayList<Data0> list=new ArrayList<Data0>();
		switch (n) {
		case 0:
			list=dq.datas0;
			break;
		case 1:
			list=dq.datas1;
			break;
		case 2:
			list=dq.datas2;
			break;
		case 3:
			list=dq.datas3;
			break;
		case 4:
			list=dq.datas4;
			break;
		default:
			break;
		}
		return list;
	}

	public static void main(String[] args) throws Exception {
		ConsoleRemeber c=new ConsoleRemeber();
//		System.out.prinstln(c.dq.datas3.get(0).write()[0]);
		
	}
	
}