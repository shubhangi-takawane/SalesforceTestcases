package SeleniumAss;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class JDBCJava {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
	 String dbUrl = "jdbc:mysql://localhost:3306/infodata";
	 String username= "root";
	 String password= "root";
		
		//create connection to db
		Connection cn= DriverManager.getConnection(dbUrl, username, password);
		
		//load mysql jdbc driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//create query
		String query = "select *from calculator";
		String query2= "alter table calculator drop valueD";
		
		//create the statement
		Statement st= (Statement) cn.createStatement();
		
		//create result set and execute query
		ResultSet rs= st.executeQuery(query);
		//int rs= st.executeUpdate(query2);
		
		System.out.println(rs);
		
		//while loop to iterate all data
		while(rs.next()) {
			String s1= rs.getString(1);
			String s2= rs.getString(2);
			//String s3= rs.getString(3);
			System.out.println(s1+" "+s2+" ");
		}
	}
}
