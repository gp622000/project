package com.mindtree.orchard.college.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.orchard.college.entity.College;


@Repository
public interface CollegeRepository extends JpaRepository<College, Integer>  {
	
	public College findByClgId(int id);
}
