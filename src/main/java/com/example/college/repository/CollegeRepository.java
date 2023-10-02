package com.example.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.college.entity.CollegeEntity;

public interface CollegeRepository extends JpaRepository<CollegeEntity, Integer>
{


}
