import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2,b3;
	
	Login(){
		
		setLayout(null);
		getContentPane().setBackground(Color.white);
		setBounds(350, 250, 900, 400);
		setVisible(true);
		
		JPanel p1 = new JPanel();
		p1.setBackground(new Color(133, 193, 233));
		p1.setBounds(0, 0, 400, 400);
		p1.setLayout(null);
		add(p1);
		
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\login.png"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        l1 = new JLabel(i3);
		l1.setBounds(100, 120, 200, 200);
		p1.add(l1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(new Color(204,204,204));
		p2.setBounds(400, 30, 450, 300);
		add(p2);
		
		l2 = new JLabel("Username");
		l2.setBounds(60, 20, 100, 25);
		l2.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		p2.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(60, 60, 300, 30);
		t1.setBorder(BorderFactory.createEmptyBorder());
		p2.add(t1);
		
		l3 = new JLabel("Password");
		l3.setBounds(60, 110, 100, 25);
		l3.setFont(new Font("SAN_SERIF", Font.PLAIN, 20));
		p2.add(l3);
		
		t2 = new JPasswordField();
		t2.setBounds(60, 150, 300, 30);
		t2.setBorder(BorderFactory.createEmptyBorder());
		p2.add(t2);
		
		b1 = new JButton("Login");
		b1.setBounds(60, 200 ,130, 30);
		b1.setBackground(new Color(133, 193, 233));
		b1.setForeground(Color.WHITE);
		b1.setBorder(BorderFactory.createEmptyBorder());
		b1.addActionListener(this);
		p2.add(b1);
		
		b2 = new JButton("Signup");
		b2.setBounds(230, 200 ,130, 30);
		b2.setForeground(new Color(133, 193, 233));
		b2.setBackground(Color.WHITE);
		b2.setBorder(new LineBorder(new Color(133, 193, 233)));
		b2.addActionListener(this);
		p2.add(b2);
		
		b3 = new JButton("Forget Password");
		b3.setBounds(130, 250 ,160, 30);
		b3.setForeground(new Color(133, 193, 233));
		b3.setBackground(Color.WHITE);
		b3.setBorder(new LineBorder(new Color(133, 193, 233)));
		b3.addActionListener(this);
		p2.add(b3);
		
		l4 = new JLabel("Trouble in Login...");
		l4.setForeground(Color.RED);
		l4.setBounds(300, 250, 120, 20);
		p2.add(l4);

	}
	
	public void actionPerformed(ActionEvent ae) {
		Conn c = new Conn();
		if(ae.getSource() == b1) {
			
            try {
        		
    			ResultSet rs = c.s.executeQuery("select * from tra where username = ' " + t1.getText() + "' AND password = ' " + t2.getText() + "'");
    			
    			if(rs.next()) {
    				String username = rs.getString("username");
    				this.setVisible(false);
    				new Loading(username).setVisible(true);
    			}else {
    				JOptionPane.showMessageDialog(null, "Invalid Login");
    			}
    			}catch(Exception e) {}
		}
        if(ae.getSource() == b2) {
        	this.setVisible(false);
			new Signup().setVisible(true);
		}
        if(ae.getSource() == b3) {
        	this.setVisible(false);
			new ForgetPassword().setVisible(true);
		}
	}
	
	public static void main(String args[]) {
		new Login();
	}

}
