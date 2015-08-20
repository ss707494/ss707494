/**
 * 简单碰撞
 * @author tarena
 *
 */
public class Test4 {
	public static void main(String[] args) throws Exception {
		World w=new World();
		Ball b1=new Ball(200	, 300);
		b1=new Ball(200, 320);
		w.addBall(b1);
		Ball b2=new Ball(600, 300);
		w.addBall(b2);
		w.repaint();
		Thread.sleep(1000);
		b1.moveTo(0,1);
//		b2.moveTo(180, 1);
		while (true) {
			Thread.sleep(2);
			w.step();
			w.repaint();
		}
	}
}
