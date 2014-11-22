package de.uniwue.info6.database.map;

// Generated Oct 30, 2013 2:01:27 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlTransient;

/**
 * UserEntry generated by hbm2java
 */
public class UserEntry implements java.io.Serializable {
	// ******************************************************************
	// custom (not generated methods)
	// ******************************************************************
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof UserEntry)) {
			return false;
		}
		UserEntry other = (UserEntry) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}
	// ******************************************************************
	// generated methods of hibernate
	// ******************************************************************

	private Integer id;
	private User user;
	private Exercise exercise;
	private String userQuery;
	private Date entryTime;
	private String resultMessage;
	private Set solutionQueries = new HashSet(0);
	private Set userResults = new HashSet(0);

	public UserEntry() {
	}

	public UserEntry(User user, Exercise exercise, String userQuery, Date entryTime) {
		this.user = user;
		this.exercise = exercise;
		this.userQuery = userQuery;
		this.entryTime = entryTime;
	}

	public UserEntry(User user, Exercise exercise, String userQuery, Date entryTime, String resultMessage,
			Set solutionQueries, Set userResults) {
		this.user = user;
		this.exercise = exercise;
		this.userQuery = userQuery;
		this.entryTime = entryTime;
		this.resultMessage = resultMessage;
		this.solutionQueries = solutionQueries;
		this.userResults = userResults;
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

	@XmlTransient
	public void setExercise(Exercise exercise) {
		this.exercise = exercise;
	}

	public String getUserQuery() {
		return this.userQuery;
	}

	public void setUserQuery(String userQuery) {
		this.userQuery = userQuery;
	}

	public Date getEntryTime() {
		return this.entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public String getResultMessage() {
		return this.resultMessage;
	}

	public void setResultMessage(String resultMessage) {
		this.resultMessage = resultMessage;
	}

	public Set getSolutionQueries() {
		return this.solutionQueries;
	}

	public void setSolutionQueries(Set solutionQueries) {
		this.solutionQueries = solutionQueries;
	}

	public Set getUserResults() {
		return this.userResults;
	}

	public void setUserResults(Set userResults) {
		this.userResults = userResults;
	}

}