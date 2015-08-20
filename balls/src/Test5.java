import java.awt.*;
import java.util.Random;

/**
 * 多个
 * @author tarena
 *
 */
public class Test5 {
	private static int n=4;//设置个数
	public static void main(String[] args) throws Exception {
		World w=new World();
		Random ra=new Random();
		Ball b1;
		for (int i = 0; i < n; i++) {
			b1=new Ball(80+ra.nextInt(100)+(i%2)*370, 
					80+ra.nextInt(100)+(i/2)*220,
					50+ra.nextInt(20), 
					new Color(ra.nextInt(255),ra.nextInt(255),ra.nextInt(255),255));
			w.addBall(b1);
			b1.moveTo(ra.nextInt(360), 1);
		}
		w.repaint();
		Thread.sleep(1000);
		while (true) {
			Thread.sleep(3);
			w.step();
			w.repaint();
		}
	}
}
