package com.ilp03.utility;

import java.sql.Connection;

import java.util.Scanner;

import com.ilp03.dao.SprintsDAO;

import com.ilp03.service.PlanningPokerService;
import com.ilp03.service.ProjectService;

public class PlanningPokerUtility {

	public static void main(String[] args) {
		
		SprintsDAO sprintsDAO = new SprintsDAO();
		Connection connection=null;
		connection=SprintsDAO.getConnection();
		PlanningPokerService planningPokerService = new PlanningPokerService();
		ProjectService projectService = new ProjectService();
		Scanner scanner = new Scanner(System.in);
		char goToMainMenu = 'y';
		do {
		System.out.println("Enter a choice:");
		System.out.println("1.Insert values into sprint Table \n2.Display All Projects\n3.Display a particular project details\n4.Exit");
		int accountChoice = scanner.nextInt();

		switch (accountChoice) {
		case 1:
			sprintsDAO.insertIntoSprints(connection);
			break;
		case 2:
			projectService.getAllProjects();
			break;
		case 3:
			planningPokerService.getProjectSummary();
			break;
		case 4:
			System.out.println("Exiting");
			break;
			
		default:
			System.out.println("Invalid choice");

		}
		

	}while(goToMainMenu == 'y');

}
}
