package com.ilp03.entity;

public class Epics {

	private int epicId;
	private String epic_name;
	private String description;
	private int projectId;
	private String createdBy;
	private String createdDate;
	private int updatedBy;
	private String updatedDate;
	public Epics(int epicId, String epic_name, String description, int projectId, String createdBy,
			String createdDate, int updatedBy, String updatedDate) {
		
		this.epicId = epicId;
		this.epic_name = epic_name;
		this.description = description;
		this.projectId = projectId;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
	}
	public int getEpicId() {
		return epicId;
	}
	public void setEpicId(int epicId) {
		this.epicId = epicId;
	}
	public String getEpic_name() {
		return epic_name;
	}
	public void setEpic_name(String epic_name) {
		this.epic_name = epic_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(int updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
}
