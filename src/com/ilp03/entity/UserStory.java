package com.ilp03.entity;

public class UserStory {
	
	private int storyId;
	private String description;
	private int cardId;
	private int sprintId;
	private int conductedBy;
	private int assignedTo;
	private int storyPoints;
	private int estimatedTime;
	private String startDate;
	private String endDate;
	private int createdBy;
	private String createdDate;
	private int updatedBy;
	private String updatedDate;
	private String status;
	public UserStory(int storyId, String description, int cardId, int sprintId, int conductedBy, int assignedTo,
			int storyPoints, int estimatedTime, String startDate, String endDate, int createdBy, String createdDate,
			int updatedBy, String updatedDate, String status) {
		super();
		this.storyId = storyId;
		this.description = description;
		this.cardId = cardId;
		this.sprintId = sprintId;
		this.conductedBy = conductedBy;
		this.assignedTo = assignedTo;
		this.storyPoints = storyPoints;
		this.estimatedTime = estimatedTime;
		this.startDate = startDate;
		this.endDate = endDate;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.status = status;
	}
	public int getStoryId() {
		return storyId;
	}
	public void setStoryId(int storyId) {
		this.storyId = storyId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getSprintId() {
		return sprintId;
	}
	public void setSprintId(int sprintId) {
		this.sprintId = sprintId;
	}
	public int getConductedBy() {
		return conductedBy;
	}
	public void setConductedBy(int conductedBy) {
		this.conductedBy = conductedBy;
	}
	public int getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(int assignedTo) {
		this.assignedTo = assignedTo;
	}
	public int getStoryPoints() {
		return storyPoints;
	}
	public void setStoryPoints(int storyPoints) {
		this.storyPoints = storyPoints;
	}
	public int getEstimatedTime() {
		return estimatedTime;
	}
	public void setEstimatedTime(int estimatedTime) {
		this.estimatedTime = estimatedTime;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
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
