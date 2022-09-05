package com.mindtree.orchard.college.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.orchard.college.entity.College;
import com.mindtree.orchard.college.repository.CollegeRepository;

@Service
public class CollegeImpl implements CollegeService {
	
	@Autowired
	private CollegeRepository collegeRepository;

	@Override
	public List<College> getAllCollege() {
		// TODO Auto-generated method stub
		return collegeRepository.findAll();
	}

	@Override
	public College getCollege(int id) {
		// TODO Auto-generated method stub
		return collegeRepository.findByClgId(id);
	}

	@Override
	public College addCollege(College clg) {
		// TODO Auto-generated method stub
		return collegeRepository.saveAndFlush(clg);
	}

	@Override
	public College updateCollege(int id,College clg) {
		
		College college = getCollege(id);
		clg.setClgId(id);
		if(clg.getClgName()==null) {
			clg.setClgName(college.getClgName());
		}
		// TODO Auto-generated method stub
		return collegeRepository.saveAndFlush(clg);
	}

	@Override
	public College deleteCollege(int id) {
		// TODO Auto-generated method stub
		College college = getCollege(id);
		collegeRepository.deleteById(id);
		return college;
	}

}
