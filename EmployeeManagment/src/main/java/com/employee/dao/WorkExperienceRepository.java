package com.employee.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.employee.entity.WorkExperience;

@Repository
public interface WorkExperienceRepository extends JpaRepository<WorkExperience, Long> {


	
}
