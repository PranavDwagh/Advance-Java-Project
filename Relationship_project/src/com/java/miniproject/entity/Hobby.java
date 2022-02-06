package com.java.miniproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name="hobby_tbl")
public class Hobby {
	
	@Id
	@Column(name="hobby_id")
	private int id;
	@Column(name="hobby_userid")
	private int userId;
	@Column(name="hobby_hobby")
	private String hobby;
	
	@ManyToOne
	private User user_id;
	
	
	public User getUser_id() {
		return user_id;
	}

	public void setUser_id(User user_id) {
		this.user_id = user_id;
	}

	public Hobby()
	{
		//
	}

	@Override
	public String toString() {
		return "Hobby [id=" + id + ", userId=" + userId + ", hobby=" + hobby + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public Hobby(int id, int userId, String hobby) {
		super();
		this.id = id;
		this.userId = userId;
		this.hobby = hobby;
	}
	
	
	
	
	
	
	
}
