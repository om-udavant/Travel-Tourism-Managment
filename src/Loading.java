import java.awt.*;
import javax.swing.*;

public class Loading extends JFrame implements Runnable
{
	JLabel l1,l2,l3;
	JTextField t1;
	JProgressBar p;
	Thread t;
	String username;
	
	Loading(String a){
		username= a;
		t = new Thread(this);

		setBounds(400,250,700,400);
		setLayout(null);
		getContentPane().setBackground(new Color(255,255,204));
		setUndecorated(true);
		
		l1 = new JLabel("Travel And Tourism Application");
		l1.setBounds(80,80,600,50);
		l1.setFont(new Font("Raleway", Font.BOLD,35));
		l1.setForeground(Color.BLUE);
		add(l1);
		
		p = new JProgressBar();
		p.setBounds(200,150,300,25);
		p.setStringPainted(true);
		add(p);
		
		l2 = new JLabel("Please Wait...");
		l2.setBounds(300,180,100,25);
		l2.setFont(new Font("Raleway", Font.BOLD,15));
		l2.setForeground(Color.RED);
		add(l2);
		
		l3 = new JLabel("Welcome " + username);
		l3.setBounds(10, 350, 400, 25);
		l3.setFont(new Font("Raleway", Font.BOLD,15));
		l3.setForeground(Color.RED);
		add(l3);
		
		t.start();
	}
	
	public  void run() {
		
		try {
			
			for(int i = 1; i <= 101; i++) {
				int m = p.getMaximum();
				int n = p.getValue();
				if(n < m) {
					
					p.setValue(p.getValue() + 1);
				}else {
					i = 101;
					Thread.sleep(1000);
					setVisible(false);
					new Dashboard(username).setVisible(true);
					}
				
				Thread.sleep(50);
			}
			
		}catch(Exception e) {}
	}
	
	public static void main(String args[]) {
		new Loading("").setVisible(true);;
	}
}
