import java.awt.*;

/**
 * 抛无线
 * @author tarena
 *
 */
public class Test2 {
	public static void main(String[] args) throws Exception {
		World w=new World();
		Ball b1=new Ball(80,80,4,Color.black);
		w.addBall(b1);
		w.repaint();
		Thread.sleep(1000);
		w.state=1;
		b1.moveTo(0,1);
		while (!b1.out()) {
			Thread.sleep(2);
			w.step();
			b1.getPower(Math.toRadians(90), 0.003);
			w.repaint();
		}
	}
}
