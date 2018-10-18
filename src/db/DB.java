package db;

import java.sql.*;

public class DB {
	private static String url="jdbc:mysql://localhost:3306/rc_nit?useSSL=false";
	private static String name_of_user="root";
	private static String password="admin1996";
	public void setUrl(String url) {
		this.url=url;
	}
	public String getUrl() {
		return this.url;
	}
	public void setUser(String user) {
		this.name_of_user=user;
	}
	public String getUser() {
		return this.name_of_user;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getPassword() {
		return this.password;
	}
	public static Connection getConnection() throws Exception{
		Connection con=null;
			try {
		    Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, name_of_user, password);
		} catch(SQLException e) {
			e.printStackTrace();
		}
			return con;

}
}
