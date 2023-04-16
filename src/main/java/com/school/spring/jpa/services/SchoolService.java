package com.school.spring.jpa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.spring.jpa.model.School;
import com.school.spring.jpa.repository.SchoolRepository;
import com.school.spring.jpa.repository.SchoolServiceInt;

@Service
public class SchoolService implements SchoolServiceInt{
	
	@Autowired
	
    SchoolRepository schoolRepository;
    
	@Override
	
	public School AddSchool(School school) {
		schoolRepository.save(school);
		return school;
	}

	@Override
	public void DeleteAllSchool(School deleteAll) {
		schoolRepository.delete(deleteAll);
		
	}

	@Override
	public void DeleteSchool(Long id) {
	     schoolRepository.deleteById(id);	
	}

	@Override
	public List<School> getAllSchool() {
		return (List<School>) schoolRepository.findAll();
	}

	@Override
	public School UpdateSchool(School school) {
		// check if the school exists in the database
        	School existingSchool = schoolRepository.findById(updatedSchool.getId())
            	.orElseThrow(() -> new EntityNotFoundException("School not found with ID " + updatedSchool.getId()));
        
		// update the existing school entity with the values from the updated school object
		existingSchool.setSchool_Name(updatedSchool.getSchool_Name());
		existingSchool.setAddress(updatedSchool.getAddress());
		existingSchool.setClass_Number(updatedSchool.getClass_Number());

		// save the updated school entity to the database
		School savedSchool = schoolRepository.save(existingSchool);

		return savedSchool;
	}

}
