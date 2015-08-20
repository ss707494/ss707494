import java.awt.*;

/**
 * 圆周
 * @author tarena
 *
 */
public class Test3 {
	public static void main(String[] args) throws Exception {
		World w=new World();
		Ball b1=new Ball(200,300,20,Color.black);
		w.addBall(b1);
		w.repaint();
		Thread.sleep(1000);
		b1.moveTo(90,1);
		while (true) {
			Thread.sleep(2);
			b1.getPower(400,300,1.0/(200));
			w.step();
			w.repaint();
		}
	}
}
