import java.sql.*;

public class Conn {
	Connection c;
	Statement s;
	public Conn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("Jdbc:mysql://localhost:3306/travel", "root", "mit");
			s = c.createStatement();
			
		}catch(Exception e) {}
	}

}
