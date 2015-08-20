import java.awt.*;

public class Ball extends Moving{
	private double P=Math.PI;
	private boolean spe=true;
	private int x,y,r;
	private double dx,dy;
	 static int w,h;
	public void setW(int w) {
		this.w = w;
	}
	public void setH(int h) {
		this.h = h;
	}

	private Color co;
	private double alf,speed;
	/**
	 * 两个球碰撞
	 * @param b
	 */
	
	public void touch2(Ball b){
		if (Math.hypot(b.x-x, b.y-y)<=r+b.r) {
			double sita=Math.atan2(b.y-y, b.x-x);
			double pow=Math.cos(this.alf-sita)*this.speed+
						Math.cos(sita-b.alf+P)*b.speed;
			getPower(sita+P, pow);
			b.getPower(sita, pow);
		}
	}
	public boolean touch(Ball b){
		if (Math.hypot(b.x-x, b.y-y)<=r+b.r) {
			double sp0=speed;
			double bsp0=b.speed;
			moveTo(x*2-b.x, 2*y-b.y, bsp0);
			b.moveTo(2*b.x-x, 2*b.y-y, sp0);
			return true;
		}else return false;
	}
	@Override
	public void move(int w,int h) {
		if (dx-r<=0||dx+r>=w) {
			alf=P-alf;
		}
		if(dy-r<=0||dy+r>=h){
			alf=-alf;
		}
		dx+=Math.cos(alf)*speed;
		dy+=Math.sin(alf)*speed;
		x=(int)dx;
		y=(int)dy;
		
	}
	public void move(){
		if (alf<0) alf+=2*P;
		if(alf>2*P) alf-=2*P;
		if (dx-r<=0||dx+r>=w) {
			alf=P-alf;
		}
		if(dy-r<=0||dy+r>=h){
			alf=-alf;
		}
		dx+=Math.cos(alf)*speed;
		dy+=Math.sin(alf)*speed;
		x=(int)dx;
		y=(int)dy;
//		speed-=0.0003;
	}
	public void getPower(double sita,double a){
		double sx2=Math.cos(sita)*a+Math.cos(alf)*speed;
		double sy2=Math.sin(sita)*a+Math.sin(alf)*speed;
		alf=Math.atan2(sy2, sx2);
		speed=Math.hypot(sx2, sy2);
	}
	public void getPower(double x,double y,double a){
		double tx=x-this.x;
		double ty=y-this.y;
		double sx2=tx*a/Math.hypot(tx, ty)+Math.cos(alf)*speed;
		double sy2=ty*a/Math.hypot(tx, ty)+Math.sin(alf)*speed;
		alf=Math.atan2(sy2, sx2);
		speed=Math.hypot(sx2, sy2);
	}
	public void moveTo(int tx,int ty,double s){
		speed=s;
		alf=Math.atan2(ty-y, tx-x);
	}
	public void moveTo(double sita,double s){
		alf=-Math.toRadians(sita);
		speed=s;
	}
	
	public boolean out(){
		return x-r<=0||x+r>=w||y-r<=0||y+r>=h;
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(co);
		g.fillArc(x-r, y-r, 2*r, 2*r, 0, 360);
	}
	
	public Ball() {
		super();
		
	}
	public Ball(int x, int y, int r, Color co) {
		super();
		this.x = x;
		this.y = y;
		dx=x;
		dy=y;
		this.r = r;
		this.co = co;
//		new Thread(){
//			public void run(){
//				while(true){
//					try {
//						Thread.sleep(1);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//					if(speed>0){
//						move();
//					}else speed=0;
//				}
//			}
//		}.start();
	}
	public Ball(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.r=50;
		this.co=Color.black;
		dx=x;
		dy=y;
	}
	
}
