package com.prodyna.ted.library.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.prodyna.ted.library.entity.LibraryUser;

public interface LibraryRepository extends MongoRepository<LibraryUser, String>{
	
	List<LibraryUser> findByFirstName(String firstName);
	List<LibraryUser> findByUsername(String username);
	List<LibraryUser> findByLastName(String lastName);
	List<LibraryUser> findByDateOfBirth(Date dateOfBirth);
}
