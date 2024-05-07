package com.ilp03.dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ilp03.entity.Employee;
import com.ilp03.entity.Epics;
import com.ilp03.entity.ProjectSummary;

public class PlanningPokerDAO {
	public static Connection getConnection() {
		String connectionString = "jdbc:mysql://localhost:3306/planningpoker?useSSL=false";
		String userName = "root";
		String password = "Poragoking@13";
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(connectionString, userName, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static ArrayList<ProjectSummary> getProjectSummary(Connection connection, String choice) {
		PreparedStatement statement;
		ArrayList<ProjectSummary> projectSummaryList = new ArrayList<ProjectSummary>();
		try {
			statement = connection.prepareStatement(
					"SELECT\r\n"
					+ "p.project_name AS project_name,\r\n"
					+ "    e.epic_name,\r\n"
					+ "s.sprint_name AS sprint_name,\r\n"
					+ "    us.description AS user_story_description,\r\n"
					+ "    us.story_points,\r\n"
					+ "    us.estimated_time,\r\n"
					+ "    CONCAT(ei.employee_first_name, ' ', ei.employee_last_name) AS epic_created_by,\r\n"
					+ "    CONCAT(si.employee_first_name, ' ', si.employee_last_name) AS sprint_created_by,\r\n"
					+ "    CONCAT(ui.employee_first_name, ' ', ui.employee_last_name) AS user_story_created_by,\r\n"
					+ "    CONCAT(ue.employee_first_name, ' ', ue.employee_last_name) AS user_story_assigned_to,\r\n"
					+ "    CONCAT(um.employee_first_name, ' ', um.employee_last_name) AS user_story_conducted_by,\r\n"
					+ "    us.status AS user_story_status\r\n"
					+ "FROM\r\n"
					+ "    projects p\r\n"
					+ "INNER JOIN\r\n"
					+ "    epics e ON p.project_id = e.project_id\r\n"
					+ "INNER JOIN\r\n"
					+ "sprints s ON e.epic_id = s.epic_id\r\n"
					+ "INNER JOIN\r\n"
					+ "    user_story us ON s.sprint_id = us.sprint_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "    employees ei ON e.created_by = ei.employee_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "    employees si ON s.created_by = si.employee_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "    employees ui ON us.created_by = ui.employee_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "    employees ue ON us.assigned_to = ue.employee_id\r\n"
					+ "LEFT JOIN\r\n"
					+ "    employees um ON us.conducted_by = um.employee_id\r\n"
					+ "where p.project_name=?");
			statement.setString(1, choice);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				String project_name = resultSet.getString(1);
				String epic_name = resultSet.getString(2);
				String sprint_name = resultSet.getString(3);
				String user_story = resultSet.getString(4);
				int story_points = resultSet.getInt(5);
				int estimated_time = resultSet.getInt(6);
				String epic_created = resultSet.getString(7);
				String sprint_created = resultSet.getString(8);
				String user_story_created = resultSet.getString(9);
				String user_story_conducted = resultSet.getString(10);
				String user_story_assigned = resultSet.getString(11);
				String user_story_status = resultSet.getString(12);
				Employee epic_created_by=new Employee();
				epic_created_by.setEmployeeName(resultSet.getString(7));
				Employee sprint_created_by=new Employee(sprint_created);
				sprint_created_by.setEmployeeName(resultSet.getString(8));
				Employee user_story_created_by = new Employee(user_story_created);
				user_story_created_by.setEmployeeName(resultSet.getString(9));
				Employee user_story_conducted_by=new Employee(user_story_conducted);
				user_story_conducted_by.setEmployeeName(resultSet.getString(10));
				Employee user_story_assigned_to = new Employee(user_story_assigned);
				user_story_assigned_to.setEmployeeName(resultSet.getString(11));
				ProjectSummary projectSummary = new ProjectSummary(project_name, epic_name, sprint_name, user_story, story_points, estimated_time, epic_created_by, sprint_created_by, user_story_created_by, user_story_conducted_by, user_story_assigned_to, user_story_status);
				projectSummaryList.add(projectSummary);	
			}
			}

			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return projectSummaryList;

	
		}
}

