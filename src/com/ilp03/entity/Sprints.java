package com.ilp03.entity;

public class Sprints {
	
	private int sprintId;
	private int epicId;
	private String sprintName;
	private int createdBy;
	private String createdDate;
	private int updatedBy;
	private String updatedDate;
	private String status;
	public Sprints(int sprintId, int epicId, String sprintName, int createdBy, String createdDate,
			int updatedBy, String updatedDate, String status) {
		super();
		this.sprintId = sprintId;
		this.epicId = epicId;
		this.sprintName = sprintName;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.status = status;
		
	}
	public int getSprintId() {
		return sprintId;
	}
	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}
	public int getEpicId() {
		return epicId;
	}
	public void setEpicId(int epicId) {
		this.epicId = epicId;
	}
	public String getSprintName() {
		return sprintName;
	}
	public void setSprintName(String sprintName) {
		this.sprintName = sprintName;
	}
	public int getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(int createdBy) {
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
