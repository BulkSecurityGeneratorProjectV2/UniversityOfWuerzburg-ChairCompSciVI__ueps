package de.uniwue.info6.database.map;

// Generated Oct 30, 2013 2:01:27 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * UserExTag generated by hbm2java
 */
public class UserExTag implements java.io.Serializable {
	// ******************************************************************
	// custom (not generated methods)
	// ******************************************************************
	
	// ******************************************************************
	// generated methods of hibernate
	// ******************************************************************

	private Integer id;
	private User user;
	private Exercise exercise;
	private String tag;
	private Date lastModified;

	public UserExTag() {
	}

	public UserExTag(User user, Exercise exercise, String tag, Date lastModified) {
		this.user = user;
		this.exercise = exercise;
		this.tag = tag;
		this.lastModified = lastModified;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Exercise getExercise() {
		return this.exercise;
	}

	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

}