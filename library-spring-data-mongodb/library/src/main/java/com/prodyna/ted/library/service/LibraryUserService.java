package com.prodyna.ted.library.service;

import java.util.Date;
import java.util.List;

import com.prodyna.ted.library.entity.LibraryUser;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
public interface LibraryUserService {
	
	public LibraryUser addUser(LibraryUser user);
	
	public void removeUser(String id);
	
	public void removeAll();
	
	public List<LibraryUser> findAll();
	
	public LibraryUser findUserByUUID(String id);
	
	public List<LibraryUser> findUsersByUsername(String username);
	
	public List<LibraryUser> findUsersByFirstName(String firstname);
	
	public List<LibraryUser> findUsersByLastName(String lastname);
	
	public List<LibraryUser> findUsersByDateOfBirth(Date dateOfBirth);

}
