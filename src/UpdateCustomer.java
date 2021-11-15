import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class UpdateCustomer extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
	JButton b1,b2;
	String username; 
	
	UpdateCustomer(String username){
		this.username = username;
		
		setBounds(480, 200,  850, 550);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		l1 = new JLabel("Username : ");
		l1.setBounds(30, 50, 150, 25);
		add(l1);
		
		t1 = new JTextField();
		t1.setBounds(220, 50, 150, 25);
		add(t1);
		
		l2 = new JLabel("ID : ");
		l2.setBounds(30, 90, 150, 25);
		add(l2);
		
		t8 = new JTextField();
		t8.setBounds(220, 90, 150, 25);
		add(t8);
		
		l3 = new JLabel("Number : ");
		l3.setBounds(30, 130, 150, 25);
		add(l3);
		
		t2 = new JTextField();
		t2.setBounds(220, 130, 150, 25);
		add(t2);
	
		l4 = new JLabel("Name : ");
		l4.setBounds(30, 170, 150, 25);
		add(l4);
		
		t3 = new JTextField();
		t3.setBounds(220, 170, 150, 25);
		add(t3);
		
		l5 = new JLabel("Gender : ");
		l5.setBounds(30, 210, 150, 25);
		add(l5);
		
		t9 = new JTextField();
		t9.setBounds(220, 210, 150, 25);
		add(t9);
		
		l6 = new JLabel("Country : ");
		l6.setBounds(30, 250, 150, 25);
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(220, 250, 150, 25);
		add(t4);
		
		l7 = new JLabel("Address : ");
		l7.setBounds(30, 290, 150, 25);
		add(l7);
		
		t5 = new JTextField();
		t5.setBounds(220, 290, 150, 25);
		add(t5);
		
		l8 = new JLabel("Phone : ");
		l8.setBounds(30, 330, 150, 25);
		add(l8);
		
		t6 = new JTextField();
		t6.setBounds(220, 330, 150, 25);
		add(t6);
		
		l9 = new JLabel("Email : ");
		l9.setBounds(30, 370, 150, 25);
		add(l9);
		
		t7 = new JTextField();
		t7.setBounds(220, 370, 150, 25);
		add(t7);
		
		b1 = new JButton("Update");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(70, 430, 100, 25);
		add(b1);

		b2 = new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(220, 430, 100, 25);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\update.png"));
		Image i2 = i1.getImage().getScaledInstance(280, 350, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        l10 = new JLabel(i3);
		l10.setBounds(400, 40, 450, 420);
		add(l10);
		
		l11 = new JLabel("Update Costomer Details");
		l11.setFont(new Font("Tahoma", Font.BOLD, 30));
		l11.setForeground(Color.BLUE);
		l11.setBounds(280, 0, 500, 40);
		add(l11);
		
		
		try {
			
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
			while(rs.next()) {
				t1.setText(rs.getString("username"));
				t2.setText(rs.getString("number"));
				t3.setText(rs.getString("name"));
				t4.setText(rs.getString("country"));
				t5.setText(rs.getString("address"));
				t6.setText(rs.getString("phone"));
				t7.setText(rs.getString("email"));
				t8.setText(rs.getString("id"));
				t9.setText(rs.getString("gender"));
				
			}
			
		}catch(Exception e) {}
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String username = t1.getText();
			String id = t8.getText();
			String number = t2.getText();
			String name = t3.getText();
			String radio = t9.getText();
			String country = t4.getText();
			String address = t5.getText();
			String phone = t6.getText();
			String email = t7.getText();
			
			String q = "update customer set username = '"+username+"', id = '"+id+"', number = '"+number+"', name = '"+name+"', gender = '"+radio+"', country = '"+country+"', address = '"+address+"', phone = '"+phone+"', email = '"+email+"'";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(q);
				
				JOptionPane.showMessageDialog(null, "Customer Details Updated Successfully");
				this.setVisible(false);
			}catch(Exception e) {
				
			}
		}
		if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}
	
	
	public static void main(String args[]) {
		new UpdateCustomer("").setVisible(true);
	}
}
