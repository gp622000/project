package com.mindtree.orchard.college.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clgId;

	private String clgName;
	
	@Value("${some.key:0}")
	private int totalStudents;
	
}
