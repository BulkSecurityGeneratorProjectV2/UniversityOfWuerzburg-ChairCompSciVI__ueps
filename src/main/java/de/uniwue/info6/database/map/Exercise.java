package de.uniwue.info6.database.map;

/*
 * #%L
 * ************************************************************************
 * ORGANIZATION  :  Institute of Computer Science, University of Wuerzburg
 * PROJECT       :  UEPS - Uebungs-Programm fuer SQL
 * FILENAME      :  Exercise.java
 * ************************************************************************
 * %%
 * Copyright (C) 2014 - 2015 Institute of Computer Science, University of Wuerzburg
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

// Generated Oct 30, 2013 2:01:27 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

import de.uniwue.info6.database.map.daos.ExerciseDao;

/**
 * Exercise generated by hbm2java
 */
public class Exercise implements java.io.Serializable {

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
    if (!(obj instanceof Exercise)) {
      return false;
    }
    Exercise other = (Exercise) obj;
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
  private ExerciseGroup exerciseGroup;
  private Exercise exercise;
  private String question;
  private String name;
  private Byte credits;
  private Date lastModified;
  private Set userEntries = new HashSet(0);
  private Set exercises = new HashSet(0);
  private Set solutionQueries = new HashSet(0);

  public Exercise() {
  }

  public Exercise(String question, Date lastModified) {
    this.question = question;
    this.lastModified = lastModified;
  }

  public Exercise(ExerciseGroup exerciseGroup, Exercise exercise, String question, String name, Byte credits,
                  Date lastModified, Set userEntries, Set exercises, Set solutionQueries) {
    this.exerciseGroup = exerciseGroup;
    this.exercise = exercise;
    this.question = question;
    this.name = name;
    this.credits = credits;
    this.lastModified = lastModified;
    this.userEntries = userEntries;
    this.exercises = exercises;
    this.solutionQueries = solutionQueries;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public ExerciseGroup getExerciseGroup() {
    return this.exerciseGroup;
  }

  @XmlTransient
  public void setExerciseGroup(ExerciseGroup exerciseGroup) {
    this.exerciseGroup = exerciseGroup;
  }

  public Exercise getExercise() {
    return this.exercise;
  }

  @XmlTransient
  public void setExercise(Exercise exercise) {
    this.exercise = exercise;
  }

  public String getQuestion() {
    return this.question;
  }

  public void setQuestion(String question) {
    this.question = question;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Byte getCredits() {
    return this.credits;
  }

  public void setCredits(Byte credits) {
    this.credits = credits;
  }

  public Date getLastModified() {
    return this.lastModified;
  }

  public void setLastModified(Date lastModified) {
    this.lastModified = lastModified;
  }

  public Set getUserEntries() {
    return this.userEntries;
  }

  @XmlTransient
  public void setUserEntries(Set userEntries) {
    this.userEntries = userEntries;
  }

  public Set getExercises() {
    return this.exercises;
  }

  @XmlTransient
  public void setExercises(Set exercises) {
    this.exercises = exercises;
  }

  public Set getSolutionQueries() {
    return this.solutionQueries;
  }

  @XmlElement(name = "solution", type = SolutionQuery.class)
  public void setSolutionQueries(Set solutionQueries) {
    this.solutionQueries = solutionQueries;
  }

  public Exercise pull() {
    return new ExerciseDao().getById(getId());
  }
}
