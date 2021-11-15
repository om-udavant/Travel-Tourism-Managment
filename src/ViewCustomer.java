import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class ViewCustomer extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20;
	JButton b2;
	String username; 
	
	ViewCustomer(String username){
		this.username = username;
		
		l20 = new JLabel("Costomer Details");
		l20.setFont(new Font("Tahoma", Font.BOLD, 30));
		l20.setForeground(Color.BLUE);
		l20.setBounds(280, 0, 500, 40);
		add(l20);
		
		setBounds(480, 200,  870, 615);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		l1 = new JLabel("Username : ");
		l1.setBounds(30, 50, 150, 25);
		add(l1);
		
		l11 = new JLabel();
		l11.setBounds(220, 50, 150, 25);
		add(l11);
		
		l2 = new JLabel("ID : ");
		l2.setBounds(30, 110, 150, 25);
		add(l2);
		
		l12 = new JLabel();
		l12.setBounds(220, 110, 150, 25);
		add(l12);
		
		l3 = new JLabel("Number : ");
		l3.setBounds(30, 170, 150, 25);
		add(l3);
		
		l13 = new JLabel();
		l13.setBounds(220, 170, 150, 25);
		add(l13);
	
		l4 = new JLabel("Name : ");
		l4.setBounds(30, 230, 150, 25);
		add(l4);
		
		l14 = new JLabel();
		l14.setBounds(220, 230, 150, 25);
		add(l14);
		
		l5 = new JLabel("Gender : ");
		l5.setBounds(30, 290, 150, 25);
		add(l5);
		
		l15 = new JLabel();
		l15.setBounds(220, 290, 150, 25);
		add(l15);
		
		l6 = new JLabel("Country : ");
		l6.setBounds(500, 50, 150, 25);
		add(l6);
		
		l16 = new JLabel();
		l16.setBounds(690, 50, 150, 25);
		add(l16);
		
		l7 = new JLabel("Address : ");
		l7.setBounds(500, 110, 150, 25);
		add(l7);
		
		l17 = new JLabel();
		l17.setBounds(690, 110, 150, 25);
		add(l17);
		
		l8 = new JLabel("Phone : ");
		l8.setBounds(500, 170, 150, 25);
		add(l8);
		
		l18 = new JLabel();
		l18.setBounds(690, 170, 150, 25);
		add(l18);
		
		l9 = new JLabel("Email : ");
		l9.setBounds(500, 230, 150, 25);
		add(l9);
		
		l19 = new JLabel();
		l19.setBounds(690, 230, 150, 25);
		add(l19);
		
		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(350, 350, 100, 25);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\Viewall.jpg"));
		Image i2 = i1.getImage().getScaledInstance(620, 200, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        l10 = new JLabel(i3);
		l10.setBounds(0, 400, 620, 200);
		add(l10);
		
		ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons\\Viewall.jpg"));
		Image i5 = i4.getImage().getScaledInstance(620, 200, Image.SCALE_DEFAULT);
		ImageIcon i6= new ImageIcon(i5);
        l20 = new JLabel(i6);
		l20.setBounds(600, 400, 620, 200);
		add(l20);
		
		
		
		try {
			
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
			while(rs.next()) {
				l11.setText(rs.getString("username"));
				l12.setText(rs.getString("id"));
				l13.setText(rs.getString("number"));
				l14.setText(rs.getString("name"));
				l15.setText(rs.getString("gender"));
				l16.setText(rs.getString("country"));
				l17.setText(rs.getString("address"));
				l18.setText(rs.getString("phone"));
				l19.setText(rs.getString("email"));
				
			}
			
		}catch(Exception e) {}
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}
	
	
	public static void main(String args[]) {
		new ViewCustomer("").setVisible(true);
	}
}
