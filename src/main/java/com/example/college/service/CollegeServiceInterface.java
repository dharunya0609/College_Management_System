package com.example.college.service;

import java.util.List;

import com.example.college.entity.CollegeEntity;

public interface CollegeServiceInterface 
{
	List<CollegeEntity> getDetails();
	
	CollegeEntity getDetailsById(int id);
	
	CollegeEntity saveItems(CollegeEntity c);
	
	String update(int id,CollegeEntity centity);
	
	String delete(int id);
	

}
