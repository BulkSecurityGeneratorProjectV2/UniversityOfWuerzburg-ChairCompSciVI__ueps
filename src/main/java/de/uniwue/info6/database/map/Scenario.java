package de.uniwue.info6.database.map;

// Generated Oct 30, 2013 2:01:27 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import de.uniwue.info6.misc.StringTools;

/**
 * Scenario generated by hbm2java
 */
@XmlRootElement
public class Scenario implements java.io.Serializable {

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
		if (!(obj instanceof Scenario)) {
			return false;
		}
		Scenario other = (Scenario) obj;
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
	private Scenario scenario;
	private String name;
	private Date lastModified;
	private Date startTime;
	private Date endTime;
	private String description;
	private String createScriptPath;
	private String imagePath;
	private String dbHost;
	private String dbUser;
	private String dbPass;
	private String dbPort;
	private String dbName;
	private Set userRights = new HashSet(0);
	private Set exerciseGroups = new HashSet(0);
	private Set scenarios = new HashSet(0);

	public Scenario() {
	}

	public Scenario(String name, Date lastModified, Date startTime, Date endTime, String description,
			String createScriptPath, String imagePath, String dbHost, String dbUser, String dbPass, String dbPort,
			String dbName) {
		this.name = name;
		this.lastModified = lastModified;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.createScriptPath = createScriptPath;
		this.imagePath = imagePath;
		this.dbHost = dbHost;
		this.dbUser = dbUser;
		this.dbPass = dbPass;
		this.dbPort = dbPort;
		this.dbName = dbName;
	}

	public Scenario(Scenario scenario, String name, Date lastModified, Date startTime, Date endTime,
			String description, String createScriptPath, String imagePath, String dbHost, String dbUser, String dbPass,
			String dbPort, String dbName, Set userRights, Set exerciseGroups, Set scenarios) {
		this.scenario = scenario;
		this.name = name;
		this.lastModified = lastModified;
		this.startTime = startTime;
		this.endTime = endTime;
		this.description = description;
		this.createScriptPath = createScriptPath;
		this.imagePath = imagePath;
		this.dbHost = dbHost;
		this.dbUser = dbUser;
		this.dbPass = dbPass;
		this.dbPort = dbPort;
		this.dbName = dbName;
		this.userRights = userRights;
		this.exerciseGroups = exerciseGroups;
		this.scenarios = scenarios;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Scenario getScenario() {
		return this.scenario;
	}

	@XmlTransient
	public void setScenario(Scenario scenario) {
		this.scenario = scenario;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLastModified() {
		return this.lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = StringTools.stripHtmlTagsForScenario(description);
	}

	public String getCreateScriptPath() {
		return this.createScriptPath;
	}

	public void setCreateScriptPath(String createScriptPath) {
		this.createScriptPath = createScriptPath;
	}

	public String getImagePath() {
		return this.imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDbHost() {
		return this.dbHost;
	}

	public void setDbHost(String dbHost) {
		this.dbHost = dbHost;
	}

	public String getDbUser() {
		return this.dbUser;
	}

	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPass() {
		return this.dbPass;
	}

	public void setDbPass(String dbPass) {
		this.dbPass = dbPass;
	}

	public String getDbPort() {
		return this.dbPort;
	}

	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}

	public String getDbName() {
		return this.dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public Set getUserRights() {
		return this.userRights;
	}

	@XmlTransient
	public void setUserRights(Set userRights) {
		this.userRights = userRights;
	}

	public Set getExerciseGroups() {
		return this.exerciseGroups;
	}

 	@XmlElement(name="exerciseGroup", type=ExerciseGroup.class)
	public void setExerciseGroups(Set exerciseGroups) {
		this.exerciseGroups = exerciseGroups;
	}

	public Set getScenarios() {
		return this.scenarios;
	}

	@XmlTransient
	public void setScenarios(Set scenarios) {
		this.scenarios = scenarios;
	}
}
