
import java.awt.*;
import javax.swing.*;

public class Splash{
	public static void main(String args[]) {
		SplashFrame frame = new SplashFrame();
		frame.setVisible(true);
		int x = 1;
		for(int i = 1; i <= 600; i+=6, x+=7) {
			
			frame.setBounds(800 - (x + i)/2, 300 - (i/4), x + i, i);
			
			try {
				Thread.sleep(10);
			}catch(Exception e) {}
		}
		
		
	}
}

class SplashFrame extends JFrame implements Runnable{
	Thread t1;
	SplashFrame(){
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\splash.jpg"));
		Image i2 = i1.getImage().getScaledInstance(1300, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		add(l1);
		
		setUndecorated(true);
		t1 = new Thread(this);
		t1.start();
	}
	
	public void run() {
		try {
			Thread.sleep(5000);
			this.setVisible(false);
			
			new Login().setVisible(true);
		}catch(Exception e) {}
	}
}



