import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class ViewPackage extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15;
	JButton b1;
	String username;
	
	ViewPackage(String username){
		this.username = username;
		setBounds(480, 200, 900, 450);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel heading = new JLabel("VIEW PACKAGE DETAILS");
		heading.setBounds(60, 0, 300, 30);
		heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
		add(heading);
		
		l1 = new JLabel("Username :");
		l1.setBounds(30, 50, 100, 30);
		add(l1);
		
		l2 = new JLabel();
		l2.setBounds(250, 50, 200, 30);
		add(l2);
		
		l3 = new JLabel("Package :");
		l3.setBounds(30, 90, 100, 30);
		add(l3);
		
		l4 = new JLabel();
		l4.setBounds(250, 90, 200, 30);
		add(l4);
		
		l5 = new JLabel("Total Persons :");
		l5.setBounds(30, 130, 100, 30);
		add(l5);
		
		l6 = new JLabel();
		l6.setBounds(250, 130, 200, 30);
		add(l6);
		
		l7 = new JLabel("ID :");
		l7.setBounds(30, 170, 100, 30);
		add(l7);
		
		l8 = new JLabel();
		l8.setBounds(250, 170, 200, 30);
		add(l8);
		
		l9 = new JLabel("Number :");
		l9.setBounds(30, 210, 100, 30);
		add(l9);
		
		l10 = new JLabel();
		l10.setBounds(250, 210, 200, 30);
		add(l10);
		
		l11 = new JLabel("Phone :");
		l11.setBounds(30, 250, 100, 30);
		add(l11);
		
		l12 = new JLabel();
		l12.setBounds(250, 250, 200, 30);
		add(l12);
		
		l13 = new JLabel("Price :");
		l13.setBounds(30, 290, 100, 30);
		add(l13);
		
		l14 = new JLabel();
		l14.setBounds(250, 290, 200, 30);
		add(l14);
		
		try {
			
			Conn c= new Conn();
			ResultSet rs = c.s.executeQuery("select * from bookPackage where username ='"+username+"'");
			while(rs.next()) {
				l2.setText(rs.getString("username"));
				l4.setText(rs.getString("package"));
				l6.setText(rs.getString("person"));
				l8.setText(rs.getString("id"));
				l10.setText(rs.getString("number"));
				l12.setText(rs.getString("phone"));
				l14.setText(rs.getString("price"));
				
			}
		}catch(Exception e) {}
		
		b1 = new JButton("Back");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(150, 340, 150, 25);
		add(b1);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\bookedDetails.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        l15 = new JLabel(i3);
		l15.setBounds(450, 20, 500, 400);
		add(l15);
	
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			this.setVisible(false);
		}
	}
	
	public static void main(String args[]) {
		new ViewPackage("").setVisible(true);
	}
}
