package com.ilp03.entity;

import java.util.ArrayList;

public class ProjectSummary {
	
	
	private String project_name;
	private String epic_name;
	private String sprint_name;
	private String user_story;
	private int story_points;
	private int estimated_time;
	private Employee epic_created_by;
	private Employee sprint_created_by;
	private Employee user_story_created_by;
	private Employee user_story_conducted_by;
	private Employee user_story_assigned_to;
	private String user_story_status;
	
	public ProjectSummary(String project_name, String epic_name, String sprint_name, String user_story,
			int story_points, int estimated_time, Employee epic_created_by, Employee sprint_created_by,
			Employee user_story_created_by, Employee user_story_conducted_by, Employee user_story_assigned_to,
			String user_story_status) {
		super();
		this.project_name = project_name;
		this.epic_name = epic_name;
		this.sprint_name = sprint_name;
		this.user_story = user_story;
		this.story_points = story_points;
		this.estimated_time = estimated_time;
		this.epic_created_by = epic_created_by;
		this.sprint_created_by = sprint_created_by;
		this.user_story_created_by = user_story_created_by;
		this.user_story_conducted_by = user_story_conducted_by;
		this.user_story_assigned_to = user_story_assigned_to;
		this.user_story_status = user_story_status;
	}
	public String getProject_name() {
		return project_name;
	}
	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}
	public String getEpic_name() {
		return epic_name;
	}
	public void setEpic_name(String epic_name) {
		this.epic_name = epic_name;
	}
	public String getSprint_name() {
		return sprint_name;
	}
	public void setSprint_name(String sprint_name) {
		this.sprint_name = sprint_name;
	}
	public String getUser_story() {
		return user_story;
	}
	public void setUser_story(String user_story) {
		this.user_story = user_story;
	}
	public int getStory_points() {
		return story_points;
	}
	public void setStory_points(int story_points) {
		this.story_points = story_points;
	}
	public int getEstimated_time() {
		return estimated_time;
	}
	public void setEstimated_time(int estimated_time) {
		this.estimated_time = estimated_time;
	}
	public Employee getEpic_created_by() {
		return epic_created_by;
	}
	public void setEpic_created_by(Employee epic_created_by) {
		this.epic_created_by = epic_created_by;
	}
	public Employee getSprint_created_by() {
		return sprint_created_by;
	}
	public void setSprint_created_by(Employee sprint_created_by) {
		this.sprint_created_by = sprint_created_by;
	}
	public Employee getUser_story_created_by() {
		return user_story_created_by;
	}
	public void setUser_story_created_by(Employee user_story_created_by) {
		this.user_story_created_by = user_story_created_by;
	}
	public Employee getUser_story_conducted_by() {
		return user_story_conducted_by;
	}
	public void setUser_story_conducted_by(Employee user_story_conducted_by) {
		this.user_story_conducted_by = user_story_conducted_by;
	}
	public Employee getUser_story_assigned_to() {
		return user_story_assigned_to;
	}
	public void setUser_story_assigned_to(Employee user_story_assigned_to) {
		this.user_story_assigned_to = user_story_assigned_to;
	}
	public String getUser_story_status() {
		return user_story_status;
	}
	public void setUser_story_status(String user_story_status) {
		this.user_story_status = user_story_status;
	}
	
		
	
	
	

}
