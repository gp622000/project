package com.mindtree.orchard.college.controller;

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

import com.mindtree.orchard.college.entity.College;
import com.mindtree.orchard.college.service.CollegeImpl;

@RequestMapping("/college")
@RestController
public class CollegeController {
	
	@Autowired
	private CollegeImpl collegeImpl;
	
	@GetMapping("/all")
	public List<College> getAllCollge(){
		return collegeImpl.getAllCollege();
	}
	
	@GetMapping("/{id}")
	public College getCollege(@PathVariable("id") int id) {
		return collegeImpl.getCollege(id);
	}
	
	@PostMapping("/add")
	public College addCollege(@RequestBody College clg) {
		return collegeImpl.addCollege(clg);
	}
	
	@PutMapping("/update/{id}")
	public College updateCollege(@PathVariable("id") int id,@RequestBody College clg) {
		return collegeImpl.updateCollege(id, clg);
	}

	@DeleteMapping("/delete/{id}")
	public College deleteCollege(@PathVariable("id") int id) {
		return collegeImpl.deleteCollege(id);
	}
}
