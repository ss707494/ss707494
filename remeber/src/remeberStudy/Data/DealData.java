package remeberStudy.Data;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

/**
 * 封装数据运算的逻辑
 * @author tarena
 *
 */
public class DealData {
	private static final int[] RF1=
		{1,3,5,7,10,15,22,29,38,50};
	private  static final int[] RF2=
		{2,4,6,8,11,17,25,38,47,64};
	private static final int[] RF3=
		{2,4,8,15,25,40,60,80,100,150};
	public static void dealData(Data0 d,int n){
		double[] rems=d.getRem();
		int x=0;
		int state=(int) rems[0];
		int times=(int) rems[1];
		double remF=rems[2];
		remF+=n-2;
		times++;
		if(state==4){
			d.setRem(state, times, remF, x);
			return;
		}
		if (remF>9) {
			state=(state==3)?3:state+1;
			remF=9;
		}
		if(remF<0) remF=0;
		if(n==1&&times>10){
			state=1;
			remF=0;
		}
		x=(int) remF;
		
		switch (state) {
		case 1:
			d.setRem(state, times, remF, RF1[x]);
			break;
		case 2:
			d.setRem(state, times, remF, RF2[x]);
			break;
		case 3:
			d.setRem(state, times, remF, RF3[x]);
			break;
			

		default:
			break;
		}
	}
	
	
}
