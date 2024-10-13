
import java.sql.*;
import java.util.Scanner;

import javax.imageio.event.IIOReadWarningListener;
//import java.util.function.ToDoubleBiFunction;
public class Demo2 {

private static final String url="jdbc:mysql://localhost:3306/MYDB";
	
	private static final String username="root";
	private static final  String password="put Your own database name here"; 

	public static void main(String[] args) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (ClassNotFoundException e) {
		System.out.println(e.getMessage());	
		
		}
		
		try {
//			Connection connection = DriverManager.getConnection(url,username,password);
			
//			Statement statement = connection.createStatement();
			
			//TO INSERT THE DATA INTO DATABASE
			
//			String queryString = String.format("INSERT INTO STUDENT(NAME,AGE,MARKS) VALUES('%s', '%o','%f')","Rahul",28,70.6);
			
			//To Update Data in DataBase 
			
//			String queryString = String.format("UPDATE Student SET MARKS =  %f  WHERE ID = %d ",82.0,5);
//			String queryString = String.format("UPDATE Student SET ID =  %d  WHERE ID = %d ",4,6);
			
			//To Delete the data from Database
			
//			String queryString = String.format("Delete From Student WHERE ID = 5 ");
 
			// BY using PreparedStatement performing insertion operation
			
//			Connection connection = DriverManager.getConnection(url,username,password);

//			String query="INSERT INTO STUDENT (NAME ,AGE, MARKS) VALUES(?,?,?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setString(1, "Mihir");
//			preparedStatement.setInt(2, 23);
//			preparedStatement.setDouble(3, 90.25);
//			
			
//		   int  rowAffected = preparedStatement.executeUpdate();
//		   if(rowAffected>0) {
////			   System.out.println("Data Updated");
//			   System.out.println("Data  Inserted Succefully");
//		   }
//			
//		   else {
//			System.out.println("Nothing has change");
//			
//		}
			//perform Retrieve operation
			
//			String qString ="Select * from Student e where ID = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(qString);
//			preparedStatement.setInt(1, 7);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if(resultSet.next()) {
//				double Marks =resultSet.getDouble("MARKS");
//				String Name =resultSet.getString("NAME");
//				System.out.println("Name : " + Name );
//				System.out.println("Marks : "+ Marks );
//			}
//			else {
//				System.out.println("Marks Not Found");
//			}
			
//			// Performing update operation
			
//			Connection connection = DriverManager.getConnection(url,username,password);
//			String qString = "UPDATE Student SET ID = ? WHERE ID = ?";
//			PreparedStatement preparedStatement = connection.prepareStatement(qString);
//			preparedStatement.setDouble(1, 5);
//			preparedStatement.setInt(2, 7);
//			
//			 int  rowAffected = preparedStatement.executeUpdate();
//			   if(rowAffected>0) {
//				   System.out.println("Data  updated Succefully");
//			   }
//				
//			   else {
//				System.out.println("Nothing has change");
//				
//			}
//		
//			
			// Performing Delete  operation
			
//						Connection connection = DriverManager.getConnection(url,username,password);
//						String qString = "DELETE  from Student  WHERE ID = ?";
//						PreparedStatement preparedStatement = connection.prepareStatement(qString);
//						preparedStatement.setDouble(1, 5);
//							
//						 int  rowAffected = preparedStatement.executeUpdate();
//						   if(rowAffected>0) {
//							   System.out.println("Data  Deleted Succefully");
//						   }
//							
//						   else {
//							System.out.println("Nothing has change");
//							
//						}
//					
//					connection.close();
//		} 
			
			
			// Batch Processing
			
			Connection connection = DriverManager.getConnection(url,username,password);//for prepared Statement
			
//			Statement statement=connection.createStatement();
			String qString = "INSERT INTO Student(NAME,AGE, MARKS) VALUES(?,?,?)";

           PreparedStatement preparedStatement = connection.prepareStatement(qString);
			Scanner scanner = new Scanner(System.in);
			
			while(true) {
				System.out.print("Enter Name :");
				String Name= scanner.next();
				System.out.print("Enter Age :");
				int AGE = scanner.nextInt();
				System.out.print("Enter Marks ");
				double Marks = scanner.nextDouble();
				System.out.println("Enter more data(Y/N) ");
				
				//for prepared statement
				
				preparedStatement.setString(1, Name);
				preparedStatement.setInt(2, AGE);
				preparedStatement.setDouble(3, Marks);
				//for Statement
				
			  // String qString = String.format("INSERT INTO Student(NAME,AGE, MARKS) VALUES('%s',%d,%f)",Name,AGE,Marks); //for Statement

				
				// prepared statement
				

//			statement.addBatch(qString);
//				preparedStatement.addBatch(qString);//for statement
				preparedStatement.addBatch();//for prepared statement

				String choice=scanner.next();
				if(choice.toUpperCase().equals("N")) {
					break;
				}
				
			}
			
			int [] arr = preparedStatement.executeBatch();
//			   if(rowAffected>0) {
//				   System.out.println("Data  Deleted Succefully");
//			   }
//				
//			   else {
//				System.out.println("Nothing has change");
			for(int i =0 ;i<arr.length;i++) {
				if(arr[i]==0) {
					System.out.println("Query"+i+"Not Executed Succesfully");
				}
			}
//				
//			}
//			String qString = String.format("INSERT INTO Student(NAME,AGE, MARKS) VALUES('%s',%d,%f)");
//			PreparedStatement preparedStatement = connection.prepareStatement(qString);
//			preparedStatement.setDouble(1, 5);
//					
			
			 
		
		connection.close();
}
			
			
		catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	  
}