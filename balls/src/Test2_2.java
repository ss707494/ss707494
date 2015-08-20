import java.awt.*;

/**
 * 自由落体
 * @author tarena
 *
 */
public class Test2_2 {
	public static void main(String[] args) throws Exception {
		World w=new World();
		w.state=0;
		Ball b1=new Ball(200,80,40,Color.black);
		w.addBall(b1);
		w.repaint();
		Thread.sleep(1000);
		while (true
				) {
			Thread.sleep(2);
			w.step();
			b1.getPower(Math.toRadians(90), 0.003);
			w.repaint();
		}
	}
}
