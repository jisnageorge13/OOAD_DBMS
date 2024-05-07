package com.ilp03.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;



public class SprintsDAO {
	public static Connection getConnection() {
		String connectionString ="jdbc:mysql://localhost:3306/planningpoker?useSSL=false";
		String userName="root";
		String password="Poragoking@13";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString,userName,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	public static void closeConnection(Connection connection)
	{
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void insertIntoSprints(Connection connection) {
		Statement statement;
		Scanner scanner =new Scanner(System.in);
		PreparedStatement preparedStatement =null;
		
		try {
			System.out.println("Enter the epic Id:");
			int epicId=scanner.nextInt();
			System.out.println("Enter the sprint name:");
			scanner.nextLine();
			String sprintName=scanner.nextLine();
			System.out.println("Enter the created by employee's Id:");
			int createdBy=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the created date:");
			String createdDate=scanner.nextLine();
			System.out.println("Enter the updated by employee's Id:");
			int updatedBy=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter the updated date:");
			String updatedDate=scanner.nextLine();
			System.out.println("Enter any of the status 1.Active,2.Inactive,3.Completed :");
			String status=scanner.nextLine();			
			statement = connection.createStatement();
			String sql="insert into sprints (epic_id, sprint_name, created_by, created_date, updated_by, updated_date, status) values(?,?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			//ResultSet resultSet = statement.execute("insert into sprints (epic_id, sprint_name, created_by, created_date, updated_by, updated_date, status) values(?,?,?,?,?,?,?)");
			
				preparedStatement.setInt(1, epicId);
	            preparedStatement.setString(2, sprintName);
	            preparedStatement.setInt(3, createdBy);
	            preparedStatement.setString(4, createdDate);
	            preparedStatement.setInt(5, updatedBy);
	            preparedStatement.setString(6, updatedDate);
	            preparedStatement.setString(7, status);
			
			int rowsAffected = preparedStatement.executeUpdate();
			 
            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
                
            } else {
                System.out.println("Failed to insert data!");
            }
 
        
		}catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
	}
}
        
    