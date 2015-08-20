import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class Test {
	public static void main(String[] args) throws Exception {
		World wo=new World();
		Random ra=new Random();
		final Ball zb;
		wo.getMoving().add(
				zb=new Ball(650, 300, 
					30, 
					Color.black)
		);
		for (int i = 0; i < 5; i++) {
			boolean flag=false;
			Ball b=new Ball(ra.nextInt(650)+100, 310, 
					30, 
					Color.blue);
			for (Moving m: wo.getMoving()) {
				if(m.touch(b)){
					i--;
					flag=true;
					break;
				}
			}
			if (!flag) {
				wo.getMoving().add(b);
			}
			
		}
		MouseAdapter l=new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
//				zb.moveTo(Math.PI, 1);
				zb.moveTo(e.getX(), e.getY(), 0.5);
				System.out.println(e.getX());
			}
		};
		wo.addMouseListener(l);
		wo.addMouseMotionListener(l);
		wo.repaint();
		for (Moving m : wo.getMoving()) {
			if (m instanceof Ball) {
				((Ball)m).setH(wo.getHeight());
				((Ball)m).setW(800);
//				((Ball)m).moveTo(ra.nextInt(628)/100.0, 0.1);
			}
		}
		wo.touchAll();
		while (true) {
			Thread.sleep(10);
			for (Moving m : wo.getMoving()) {
//				((Ball)m).getPower(300, 200, 50.0*50/150);
			}
			wo.repaint();
		}
		
		
	}
}
