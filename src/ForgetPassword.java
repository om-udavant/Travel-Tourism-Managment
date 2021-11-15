import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ForgetPassword extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3;

	ForgetPassword(){
		setBounds(350, 250, 850, 380);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JPanel p = new JPanel();
		p.setLayout(null);
		p.setBackground(new Color(204,204,204));
		p.setBounds(30, 30, 500, 280);
		add(p);
		
		l1 = new JLabel("Username");
		l1.setBounds(40, 20, 100, 25);
		l1.setFont(new Font("Tahoma", Font.BOLD, 14));
		p.add(l1);
		
		t1 = new JTextField();
		t1.setBorder(BorderFactory.createEmptyBorder());
		t1.setBounds(220, 20, 150, 25);
		p.add(t1);
		
		b1 = new JButton("Search");
		b1.setBackground(new Color(102,102,102));
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(380, 20, 100, 25);
		p.add(b1);

		
		l2 = new JLabel("Name");
		l2.setBounds(40, 60, 100, 25);
		l2.setFont(new Font("Tahoma", Font.BOLD, 14));
		p.add(l2);
		
		t2 = new JTextField();
		t2.setBorder(BorderFactory.createEmptyBorder());
		t2.setBounds(220, 60, 150, 25);
		p.add(t2);
		
		l3 = new JLabel("Your Security Question");
		l3.setBounds(40, 100, 170, 25);
		l3.setFont(new Font("Tahoma", Font.BOLD, 14));
		p.add(l3);
		
		t3 = new JTextField();
		t3.setBorder(BorderFactory.createEmptyBorder());
		t3.setBounds(220, 100, 250, 25);
		p.add(t3);
		
		l4 = new JLabel("Answer");
		l4.setBounds(40, 140, 100, 25);
		l4.setFont(new Font("Tahoma", Font.BOLD, 14));
		p.add(l4);
		
		t4 = new JTextField();
		t4.setBorder(BorderFactory.createEmptyBorder());
		t4.setBounds(220, 140, 150, 25);
		p.add(t4);
		
		b2 = new JButton("Retrieve");
		b2.setBackground(new Color(102,102,102));
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(380, 140, 100, 25);
		p.add(b2);

		
		l5 = new JLabel("Password");
		l5.setBounds(40, 180, 100, 25);
		l5.setFont(new Font("Tahoma", Font.BOLD, 14));
		p.add(l5);
		
		t5 = new JTextField();
		t5.setBorder(BorderFactory.createEmptyBorder());
		t5.setBounds(220, 180, 150, 25);
		p.add(t5);
		
		b3 = new JButton("Back");
		b3.setBackground(new Color(102,102,102));
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		b3.setBounds(150, 230, 100, 25);
		p.add(b3);

		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\forgotpassword.jpg"));
		Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        l6 = new JLabel(i3);
		l6.setBounds(580, 70, 200, 200);
		add(l6);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		Conn c = new Conn();
		if(ae.getSource() == b1) {
			try {
		
			ResultSet rs = c.s.executeQuery("select * from tra where username = ' " + t1.getText() + "'");
			while(rs.next()) {
				
				t2.setText(rs.getString("name"));
				t3.setText(rs.getString("Security"));
				
				
			}
			}catch(Exception e) {}
		}
        if(ae.getSource() == b2) {
        	try {
        		
    			ResultSet rs = c.s.executeQuery("select * from tra where answer = ' " + t4.getText() + "' AND username = ' " + t1.getText() + "'");
    			while(rs.next()) {
    				
    				t5.setText(rs.getString("password"));
    				
    				
    			}
    			}catch(Exception e) {}
		}
        if(ae.getSource() == b3) {
        	this.setVisible(false);
        	new Login().setVisible(true);
	
        }
	}
	
	public static void main(String args[]) {
		new ForgetPassword().setVisible(true);
	}
}
