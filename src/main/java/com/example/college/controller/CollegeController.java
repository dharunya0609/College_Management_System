package com.example.college.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.college.entity.CollegeEntity;
import com.example.college.service.CollegeService;

@RestController

public class CollegeController 
{
	@Autowired
	CollegeService cs;
	

	@GetMapping
	public String welcome()
	{
		return  "College Management System KONGU ENGINEERING COLLEGE";
	}
	
	@GetMapping(value="/getDetails")
	public List<CollegeEntity> getList()
	{
		List<CollegeEntity> c=new ArrayList<CollegeEntity>();
		try
		{
			c=cs.getDetails();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return c;
	}
	
	@GetMapping(value="/getbyId/{id}")
	public CollegeEntity getById(@PathVariable int id)
	{
		CollegeEntity c=new CollegeEntity();
		try
		{
		   c=cs.getDetailsById(id)	;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
	}
	
	
	
	@PostMapping(value="/insert")
	public String insert(@RequestBody CollegeEntity ce)
	{
		try
		{
		   cs.saveItems(ce)	;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Data inserted successfully!";
	}
	
	
	@PutMapping(value="/update/{id}")
	public String update(@PathVariable int id,@RequestBody CollegeEntity ce)
	{
		try
		{
			cs.update(id,ce);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return "Data updated successfully !";
	}
	
	
	
	@DeleteMapping(value="/delete/{id}")
	public String delete(@PathVariable int id)
	{
		try
		{
			cs.delete(id);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Data deleted successfully !";
	}

}
