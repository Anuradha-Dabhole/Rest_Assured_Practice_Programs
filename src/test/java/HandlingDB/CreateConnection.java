package HandlingDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateConnection {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		Statement mystmt=null;
		ResultSet myres=null;
		
	con=	DriverManager.getConnection("jdbc:mysql://localhost:3306/Local Instance 3","root","root");
	mystmt=con.createStatement();
	
	mystmt
	}

}
