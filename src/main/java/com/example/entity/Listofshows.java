package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Listofshows {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int listId;
	
	@Column
	private int userId;
	
	@Column
	private int showId;
	
	@Column
	private Boolean history=false;
	
	@Column
	private Boolean notification=null;
	
	
	public Listofshows() {}

	

	public Listofshows(int userId, int showId) {
		super();
		this.userId = userId;
		this.showId = showId;
	}

	
	


	public Listofshows(int listId, int userId, int showId, Boolean history, Boolean notification) {
		super();
		this.listId = listId;
		this.userId = userId;
		this.showId = showId;
		this.history = history;
		this.notification = notification;
	}



	public int getListId() {
		return listId;
	}


	public void setListId(int listId) {
		this.listId = listId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getShowId() {
		return showId;
	}


	public void setShowId(int showId) {
		this.showId = showId;
	}

	

	public Boolean getHistory() {
		return history;
	}



	public void setHistory(Boolean history) {
		this.history = history;
	}



	public Boolean getNotification() {
		return notification;
	}



	public void setNotification(Boolean notification) {
		this.notification = notification;
	}



	@Override
	public String toString() {
		return "Listofshows [listId=" + listId + ", userId=" + userId + ", showId=" + showId + "]";
	}
	
	
	}
