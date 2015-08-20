import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

interface Paint{
	void paint(Graphics g);
}

public class World extends JPanel{
	int state;
	private List<Moving> moving;
	List<Ball> balls;
	public List<Moving> getMoving() {
		return moving;
	}

	public World() throws Exception {
		state=0;
		balls=new ArrayList<Ball>();
		moving=new ArrayList<Moving>();
		JFrame win=new JFrame();
		win.setSize(800,600);
		win.setVisible(true);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setLocationRelativeTo(null);
		win.add(this);
		this.setBackground(Color.white);
		this.repaint();
		Thread.sleep(5);
		Ball.w=this.getWidth();
		Ball.h=this.getHeight();
		System.out.println(Ball.w);
	}
	public void step(){
		touchAll();
		for (int i = 0; i < balls.size(); i++) {
			balls.get(i).move();
		}
	}
	/**
	 * 遍历所有moving 进行 碰撞
	 * @param m
	 * @return
	 */
	public void touchAll(){
		for (int i = 0; i < balls.size(); i++) {
			for (int j = i+1; j < balls.size(); j++) {
				balls.get(i).touch2(balls.get(j));
			}
		}
	}
 	public boolean addmoving(Moving m){
		return moving.add(m);
	}
	public void addBall(Ball b){
		balls.add(b);
	}
	@Override
	public void paint(Graphics g) {
		if (state==0) {
			super.paint(g);
		}
		for (Ball b : balls) {
			b.paint(g);
		}
		for (Moving m : moving) {
			m.paint(g);
		}
	}
	public static void main(String[] args) throws Exception {
		World w=new World();
//		Ball b1=new Ball(100, 100);
//		b1.moveTo(600, 600, 1);
//		Ball b2=new Ball(500, 400);
//		b2.moveTo(0, 0, 1);
//		w.addBall(b1);
//		w.addBall(b2);
//		
//		w.repaint();
//		while (true) {
//			Thread.sleep(2);
//			w.step();
//			w.repaint();
//		}
	}
	

}
