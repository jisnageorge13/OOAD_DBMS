package com.ilp03.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp03.dao.ProjectsDAO;
import com.ilp03.entity.Projects;

public class ProjectService {
	public void getAllProjects() {
		try {
			Connection connection = ProjectsDAO.getConnection();
			ArrayList<Projects> projectList = ProjectsDAO.getAllProjects(connection);
			System.out.println("\t\tAll Projects");
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("| Project Name  | Description  |  Creation Date  |  Status   |");
			System.out.println("---------------------------------------------------------------------------------");
			 
			for (Projects projects : projectList) {
			    System.out.printf("| %-20s | %-20s | %-15s | %-15s \n", 
			                      projects.getProjectName(), projects.getDescription(), 
			                      projects.getCreatedDate(), projects.getStatus()); 
			                      
			}
			 
			System.out.println("---------------------------------------------------------------------------------");
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
