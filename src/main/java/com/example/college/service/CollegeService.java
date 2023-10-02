package com.example.college.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.college.entity.CollegeEntity;
import com.example.college.repository.CollegeRepository;
 
@Service
public class CollegeService  implements CollegeServiceInterface
{
	@Autowired
	public CollegeRepository repo;
	
	public List<CollegeEntity> getDetails()
	{
		List<CollegeEntity> c=new ArrayList<CollegeEntity>();
		try
		{
			c=repo.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
		return c;
	}
	
	
	public CollegeEntity getDetailsById(int id)
	{
		CollegeEntity cnew=new CollegeEntity();
		
		
		if(id>0)
		{
			try
			{
				cnew=repo.findById(id).get();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		return cnew;
		
	}
	


	
	public String saveItems(CollegeEntity c)
	{
		CollegeEntity cnew=new CollegeEntity();
		try
		{
			if(c.getEmail()==null || c.getEmail().isEmpty())
				return "Email can not be Empty !";
			else if( c.getRating()>0 || c.getAvgSalary() >0 || c.getFacultyCount()>0)
				  return "Data can not be String or Zero";
			else if(c.getName()==null || c.getName().isEmpty())
				return "Department Name should not be Empty !";
			
			cnew=repo.save(c);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Data inserted Successfully";
	}
	
	
	
	
	
	public String update(int id,CollegeEntity centity)
	{
		
		CollegeEntity c1 = new CollegeEntity();
		String msg=null;
		
		Optional<Integer> cid=Optional.of(id);
		Optional<CollegeEntity> copt=Optional.ofNullable(centity);
		
		if(cid.get()>0 && copt.get()!=null && copt.isPresent())
		{
			try 
			{
				if(id >0) 
				{
					c1 = repo.findById(id).get();
					if(c1 != null) 
					{
						c1.setAvgSalary(centity.getAvgSalary());
						c1.setEmail(centity.getEmail());
						c1.setFacultyCount(centity.getFacultyCount());
						c1.setName(centity.getName());
						c1.setRating(centity.getRating());
						repo.save(c1);
				    }
			    }
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			return "ID or Object passed is NULL , Do check !";
		}
	       
		return msg;
		
	}
		
	public String delete(int id)
	{
		try
		{
			if(id>0 )
			  repo.deleteById(id);
			else
				return "Invalid ID passed";
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return "Data deleted successfuly";
	}

}
