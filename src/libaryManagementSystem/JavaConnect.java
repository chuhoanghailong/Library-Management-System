package libaryManagementSystem;

import java.sql.*;
import javax.swing.JOptionPane;

public class JavaConnect {
	Connection connect;


public static Connection ConnecttoDB() {
	String url = "jdbc:sqlite:E:\\database File\\dblibrary.db";
	try {
		Class.forName("org.sqlite.JDBC");
		Connection connect = DriverManager.getConnection(url);
		return connect;
	}
	catch(Exception e){
		JOptionPane.showMessageDialog(null, e);
		return null;
		}
	}
}