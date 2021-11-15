import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Payment extends JFrame implements ActionListener{

	JButton b1, b2;
	Payment(){
	
		setBounds(480, 200, 800, 600);
		setLayout(null);
		getContentPane().setBackground(Color.WHITE);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\paytm.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(800, 600, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        JLabel l15 = new JLabel(i3);
		l15.setBounds(0, 0, 800, 600);
		add(l15);
		
		b1 = new JButton("Pay");
		b1.addActionListener(this);
		b1.setBounds(420, 5, 80, 40);
		l15.add(b1);
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBounds(520, 5, 80, 40);
		l15.add(b2);
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			this.setVisible(false);
			new Paytm().setVisible(true);
		}
        if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}
	
	public static void main(String args[]) {
		new Payment().setVisible(true);
	}
}
