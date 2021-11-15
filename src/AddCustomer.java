import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class AddCustomer extends JFrame implements ActionListener{

	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JComboBox c1;
	JRadioButton r1,r2;
	JButton b1,b2;
	ButtonGroup g1 = new ButtonGroup();
	String username; 
	
	AddCustomer(String username){
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
		
		c1 = new JComboBox(new String[] {"Passport", "Aadhar Card", "Pan Card", "Ration Card"});
		c1.setBounds(220, 90, 150, 25);
		add(c1);
		
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
		
		r1 = new JRadioButton("Male");
		r1.setBackground(Color.WHITE);
		r1.setBounds(220, 210, 70, 25);
		g1.add(r1);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBackground(Color.WHITE);
		r2.setBounds(300, 210, 70, 25);
		g1.add(r2);
		add(r2);
		
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
		
		b1 = new JButton("Add");
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
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\newcustomer.jpg"));
		Image i2 = i1.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        l10 = new JLabel(i3);
		l10.setBounds(400, 40, 450, 420);
		add(l10);
		
		l11 = new JLabel("Add Costomer Details");
		l11.setFont(new Font("Tahoma", Font.BOLD, 30));
		l11.setForeground(Color.BLUE);
		l11.setBounds(280, 0, 500, 40);
		add(l11);
		
		
		try {
			
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from tra where username = '"+username+"'");
			while(rs.next()) {
				t1.setText(rs.getString("username"));
				t3.setText(rs.getString("name"));
			}
			
		}catch(Exception e) {}
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1) {
			String username = t1.getText();
			String id = (String) c1.getSelectedItem();
			String number = t2.getText();
			String name = t3.getText();
			String radio = null;
			if(r1.isSelected()) {
				radio = "Male";
			}else if(r2.isSelected()) {
				radio = "Female";
			}
			String country = t4.getText();
			String address = t5.getText();
			String phone = t6.getText();
			String email = t7.getText();
			
			String q = "insert into customer value('"+username+"', '"+id+"', '"+number+"', '"+name+"','"+radio+"', '"+country+"', '"+address+"','"+phone+"','"+email+"')";
			try {
				Conn c = new Conn();
				c.s.executeUpdate(q);
				
				JOptionPane.showMessageDialog(null, "Customer Details Added Successfully");
				this.setVisible(false);
			}catch(Exception e) {
				
			}
		}
		if(ae.getSource() == b2) {
			this.setVisible(false);
		}
	}
	
	
	public static void main(String args[]) {
		new AddCustomer("").setVisible(true);
	}
}
