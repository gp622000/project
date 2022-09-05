package com.mindtree.orchard.college.service;

import java.util.List;

import com.mindtree.orchard.college.entity.College;

public interface CollegeService {
	
	public List<College> getAllCollege();
	public College getCollege(int id);
	public College addCollege(College clg);
	public College updateCollege(int id,College clg);
	public College deleteCollege(int id);
	
}
