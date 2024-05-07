package com.ilp03.service;

import java.sql.Connection;




import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.ilp03.dao.PlanningPokerDAO;
import com.ilp03.entity.ProjectSummary;
import com.ilp03.entity.Employee;

public class PlanningPokerService {

	public void getProjectSummary() {
		try {
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the project name:");
			String choice =scanner.nextLine();
			Connection connection = PlanningPokerDAO.getConnection();
			ArrayList<ProjectSummary> projectSummaryList = PlanningPokerDAO.getProjectSummary(connection,choice);
			
			System.out.println("\t\tProject Details");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(String.format("%-20s | %-20s | %-10s | %-30s | %-13s | %-15s | %-20s | %-20s | %-15s | %-15s | %-20s | %-15s",
			    "Project Name", "Epics", "Sprints", "User Story", "Story Points", "Estimated Time",
			    "Epic Created By", "Sprint Created By", "Story Created By", "Assigned To", "Scrum Meeting By", "Status"));
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			 
			for (ProjectSummary projectSummary : projectSummaryList) {
			    System.out.println(String.format("%-20s | %-20s | %-10s | %-30s | %-13d | %-15d | %-20s | %-20s | %-15s | %-15s | %-20s | %-15s",
			        projectSummary.getProject_name(),
			        projectSummary.getEpic_name(),
			        projectSummary.getSprint_name(),
			        projectSummary.getUser_story(),
			        projectSummary.getStory_points(),
			        projectSummary.getEstimated_time(),
			        projectSummary.getEpic_created_by().getEmployeeName(),
			        projectSummary.getSprint_created_by().getEmployeeName(),
			        projectSummary.getUser_story_created_by().getEmployeeName(),
			        projectSummary.getUser_story_assigned_to().getEmployeeName(),
			        projectSummary.getUser_story_conducted_by().getEmployeeName(),
			        projectSummary.getUser_story_status()));
			    System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
			}
			
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

}
}
