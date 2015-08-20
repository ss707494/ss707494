/**
 * 任意方向
 * @author tarena
 *
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		World w=new World();
		Ball b1=new Ball(400	, 300);
		w.addBall(b1);
		w.repaint();
		Thread.sleep(1000);
		//设置(方向 角度,速度)
		b1.moveTo(90,1);
		while (true) {
			Thread.sleep(2);
			w.step();
			w.repaint();
		}
	
	}
}
