package com.example.college.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Management_Table")
public class CollegeEntity 
{
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String email;
	private int facultyCount;
	private long avgSalary;
	private int rating;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getFacultyCount() {
		return facultyCount;
	}
	public void setFacultyCount(int facultyCount) {
		this.facultyCount = facultyCount;
	}
	public long getAvgSalary() {
		return avgSalary;
	}
	public void setAvgSalary(long avgSalary) {
		this.avgSalary = avgSalary;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public CollegeEntity(int id, String name, String email, int facultyCount, long avgSalary, int rating) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.facultyCount = facultyCount;
		this.avgSalary = avgSalary;
		this.rating = rating;
	}
	public CollegeEntity() {
	    // Default constructor
	}

	
	

}
