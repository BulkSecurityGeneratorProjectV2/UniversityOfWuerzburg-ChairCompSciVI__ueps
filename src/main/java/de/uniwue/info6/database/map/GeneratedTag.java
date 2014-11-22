package de.uniwue.info6.database.map;

// Generated Oct 30, 2013 2:01:27 PM by Hibernate Tools 4.0.0

import java.util.Date;

/**
 * GeneratedTag generated by hbm2java
 */
public class GeneratedTag implements java.io.Serializable {

	// ******************************************************************
	// custom (not generated methods)
	// ******************************************************************
	
	// ******************************************************************
	// generated methods of hibernate
	// ******************************************************************

	private Integer id;
	private Exercise exercise;
	private String tag;
	private Date lastModified;

	public GeneratedTag() {
	}

	public GeneratedTag(Exercise exercise, String tag, Date lastModified) {
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
