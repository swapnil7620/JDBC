import java.sql.*;
public class DEMO {

	private static final String url="jdbc:mysql://localhost:3306/MYDB";
	
	private static final String username="root";
	private static final  String password="Put Your own database Name here"; 

	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());	
		
		}
		
		try {
			Connection connection = DriverManager.getConnection(url,username,password);
			Statement statement = connection.createStatement();
			String queryString = "Select * From Student";
			ResultSet resultSet = statement.executeQuery(queryString);
			while(resultSet.next()) {
				int id = resultSet.getInt("ID");
				String Name = resultSet.getString("NAME");
				int Age = resultSet.getInt("AGE");
				double Marks = resultSet.getDouble("MARKS");
//				System.out.println("ID :" + id + ":" + "Name : " + ":"+ Name + " Age: " + ":" + Age + " Marks :" + ":"+ Marks);
				System.out.println("ID :" + id);
				System.out.println("NAME: " + Name );
				System.out.println("AGE: " + Age );
				System.out.println("MARKS: " + Marks );
				System.out.println("");
			
			}
			connection.close();
		} 
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}