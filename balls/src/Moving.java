import java.awt.*;

public abstract class Moving{
	double G=1;
	public abstract void paint(Graphics g);
	public abstract void move(int w,int h);
	public abstract boolean touch(Ball b);
//	public abstract void moveTo(int x,int y,double s);
//	public abstract void moveTo(double sita,double s);
}
