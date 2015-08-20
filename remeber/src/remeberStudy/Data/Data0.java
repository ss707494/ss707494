package remeberStudy.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Data0 implements Comparable<Data0> {
	private static SimpleDateFormat SF=new SimpleDateFormat("yyyy-MM-dd");
	private int firstTime;
	private int state,times;
	private double remeberF;
	private String ans,que;
	private Calendar date;
	public Data0() {
		super();
	}
	/**
	 * 构造器
	 * 根据从文件取得的字符串
	 * 并将其加入DatasQueue 集合中
	 * @param s1
	 * @param s2
	 * @param s3
	 * @param dq
	 */
	public Data0(String s1,String s2,String s3,DatasQuene dq){
		String [] arr=s1.split("@");
		this.date=Calendar.getInstance();
		this.firstTime=Integer.parseInt(arr[1]);
		this.state=Integer.parseInt(arr[2]);
		this.times=Integer.parseInt(arr[4]);
		this.remeberF=Double.parseDouble(arr[3]);
		try {
			this.date.setTime(SF.parse(arr[5]));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.ans=s2;
		this.que=s3;
		add(dq);
	}
	public void add(DatasQuene dq) {
		switch (this.state) {
		case 1:
			dq.datas1.add(this);
			break;
		case 2:
			dq.datas2.add(this);
			break;
		case 3:
			dq.datas3.add(this);
			break;
		case 4:
			dq.datas4.add(this);
			break;
		case 0:
			dq.datas0.add(this);
		default:
			break;
		}
		if (this.date.compareTo(Calendar.getInstance())<0) {
			dq.dataToday.add(this);
		}
	}
	
	public double[] getRem(){
		double[] rems=new double[3];
		rems[0]=state;
		rems[1]=times;
		rems[2]=remeberF;
		return rems;
	}
	public void setRem(int state,int times,double remeberF,int x){
		this.state=state;
		this.times=times;
		this.remeberF=remeberF;
		Calendar cal=Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, x);
		date=cal;
	}
	
	
	@Override
	public String toString() {
		
		return firstTime + ", " + state + ", " + remeberF + ", " + times + ", "
				+ SF.format(date.getTime()) + ",\n " + ans + ",\n " + que;
	}
	@Override
	public int compareTo(Data0 o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String[] write(){
		String[] ss=new String[3];
		ss[0]="@"+firstTime+"@"+state+"@"+remeberF+"@"+times+"@"+SF.format(date.getTime());
		ss[1]=que;
		ss[2]=ans;
		return ss;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setRemeberF(double remeberF) {
		this.remeberF = remeberF;
	}
	public String getAns() {
		return ans;
	}
	public void setAns(String ans) {
		this.ans = ans;
	}
	public String getQue() {
		return que;
	}
	public void setQue(String que) {
		this.que = que;
	}
	public int getState() {
		return state;
	}
	public double getRemeberF() {
		return remeberF;
	}
	
}
