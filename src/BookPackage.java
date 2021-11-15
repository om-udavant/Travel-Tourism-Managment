import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class BookPackage extends JFrame implements ActionListener{

	JLabel l1,l2,l4,l5,l6,l8,l10,l12,l14;
	JLabel l3,l7,l9,l11,l13;
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	String username;
	
	BookPackage(String username){
		this.username = username;
		
		setBounds(400, 200, 1100, 500);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		l1 = new JLabel("BOOK PACKAGE");
		l1.setBounds(100, 10, 200, 30);
		l1.setFont(new Font("Yu Mincho", Font.PLAIN, 20));
		add(l1);
		
		l2 = new JLabel("Username :");
		l2.setBounds(40, 70, 100, 30);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l2);
		
		l3 = new JLabel();
		l3.setBounds(250, 70, 100, 30);
		l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l3);
		
		l4 = new JLabel("Select Package :");
		l4.setBounds(40, 110, 150, 30);
		l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l4);
		
		c1 = new Choice();
		c1.add("Gold Package");
		c1.add("Silver Package");
		c1.add("Bronze Package");
		c1.setBounds(250, 110, 200, 30);
		add(c1);
		
		l5 = new JLabel("Total Persons :");
		l5.setBounds(40, 150, 150, 30);
		l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l5);
		
		t1 = new JTextField("1");
		t1.setBounds(250, 150, 200, 25);
		add(t1);
		
		l6 = new JLabel("ID :");
		l6.setBounds(40, 190, 100, 30);
		l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l6);
		
		l7 = new JLabel();
		l7.setBounds(250, 190, 100, 30);
		l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l7);
		
		l8 = new JLabel("Number :");
		l8.setBounds(40, 230, 100, 30);
		l8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l8);
		
		l9 = new JLabel();
		l9.setBounds(250, 230, 100, 30);
		l9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l9);
		
		l10 = new JLabel("Phone :");
		l10.setBounds(40, 270, 100, 30);
		l10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l10);
		
		l11 = new JLabel();
		l11.setBounds(250, 270, 100, 30);
		l11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l11);
		
		l12 = new JLabel("Total Price :");
		l12.setBounds(40, 310, 100, 30);
		l12.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l12);
		
		l13 = new JLabel();
		l13.setBounds(250, 310, 300, 30);
		l13.setForeground(Color.RED);
		l13.setFont(new Font("Tahoma", Font.PLAIN, 16));
		add(l13);
		
	try {
			
			Conn c = new Conn();
			ResultSet rs = c.s.executeQuery("select * from customer where username = '"+username+"'");
			while(rs.next()) {
				l3.setText(rs.getString("username"));
				l7.setText(rs.getString("id"));
				l9.setText(rs.getString("number"));
				l11.setText(rs.getString("phone"));
				
			}
			
		}catch(Exception e) {}
		
		b1 = new JButton("Check Price");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(60, 380, 120, 25);
		add(b1);
		
		b2 = new JButton("Book Package");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(200, 380, 120, 25);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.addActionListener(this);
		b3.setBounds(340, 380, 120, 25);
		add(b3);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons\\bookpackage.jpg"));
		Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        l14 = new JLabel(i3);
		l14.setBounds(550, 50, 500, 300);
		add(l14);
          
	}
	
	public void actionPerformed(ActionEvent ae) {
		String p = c1.getSelectedItem();
		int cost = 0;
		if(p.equals("Gold Package")) {
			cost += 12000;
		}
		else if(p.equals("Silver Package")) {
			cost += 24000;
		}
		else if(p.equals("Bronze Package")) {
			cost += 32000;
		}
		
		int person = Integer.parseInt(t1.getText());
		cost *= person;
		
		if(ae.getSource() == b1) {
			if(person > 0) {
			    l13.setText("Rs " + cost);
			}else {
				l13.setText("Please Enter a Valid Number");
				JOptionPane.showMessageDialog(null, "Please Check the Total Person's Details");
				
			}
		} 
		
		if(ae.getSource() == b2) {
			if(person != 0) {	
				try {
					l13.setText("Rs " + cost);
					Conn c = new Conn();
					c.s.executeUpdate("insert into bookPackage Values('"+l3.getText()+"', '"+c1.getSelectedItem()+"', '"+t1.getText()+"', '"+l7.getText()+"', '"+l9.getText()+"', '"+l11.getText()+"', '"+l13.getText()+"')");
				    JOptionPane.showMessageDialog(null, "Package Booked Successfully");
				    this.setVisible(false);
				}catch(Exception e) {}
					
		     }else {
		    	    l13.setText("Please Enter a Valid Number");
					JOptionPane.showMessageDialog(null, "Please Check the Total Person's Details");
					
				}
		
		if(ae.getSource() == b3) {
			 this.setVisible(false);
		}

		}
	}
	
	public static void main(String args[]) {
		new BookPackage("").setVisible(true);
	}
}
