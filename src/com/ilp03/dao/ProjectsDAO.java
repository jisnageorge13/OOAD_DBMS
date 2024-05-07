package com.ilp03.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.ilp03.entity.Projects;

public class ProjectsDAO {
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
	public static ArrayList<Projects> getAllProjects(Connection connection) {
		Statement statement;
		ArrayList<Projects> projectList = new ArrayList<Projects>();
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from projects");
			while (resultSet.next()) {
				int id = resultSet.getInt(1);
				String  projectName = resultSet.getString(2);
				String description= resultSet.getString(3);
				int createdBy = resultSet.getInt(4);
				String createdDate = resultSet.getString(5);
				int updatedBy = resultSet.getInt(4);
				String updatedDate = resultSet.getString(5);
				String status = resultSet.getString(8);
				

				Projects projects = new Projects(projectName, description, createdBy,createdDate,updatedBy,updatedDate,status);

				projectList.add(projects);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectList;

	}

}
