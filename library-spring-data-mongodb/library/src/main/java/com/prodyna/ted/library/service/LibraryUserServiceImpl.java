package com.prodyna.ted.library.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodyna.ted.library.entity.LibraryUser;
import com.prodyna.ted.library.repository.LibraryRepository;

@Service
public class LibraryUserServiceImpl implements LibraryUserService {

	@Autowired
	private LibraryRepository repository;
	
	@Override
	public LibraryUser addUser(LibraryUser user) {
		return repository.save(user);
	}

	@Override
	public void removeUser(String uuid) {
		repository.delete(uuid);
	}

	@Override
	public void removeAll() {
		repository.deleteAll();
	}

	@Override
	public List<LibraryUser> findAll() {
		return repository.findAll();
	}

	@Override
	public LibraryUser findUserByUUID(String uuid) {
		return repository.findOne(uuid);
	}

	@Override
	public List<LibraryUser> findUsersByUsername(String username) {
		return repository.findByUsername(username);
	}

	@Override
	public List<LibraryUser> findUsersByFirstName(String firstname) {
		return repository.findByFirstName(firstname);
	}

	@Override
	public List<LibraryUser> findUsersByLastName(String lastname) {
		return repository.findByLastName(lastname);
	}

	@Override
	public List<LibraryUser> findUsersByDateOfBirth(Date dateOfBirth) {
		return repository.findByDateOfBirth(dateOfBirth);
	}

}
