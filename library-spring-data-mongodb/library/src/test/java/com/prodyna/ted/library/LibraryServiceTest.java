package com.prodyna.ted.library;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.prodyna.ted.library.entity.LibraryUser;
import com.prodyna.ted.library.service.LibraryUserService;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class LibraryServiceTest {

	@Autowired
	private LibraryUserService service;
	
	@After
	public void after() {
		service.removeAll();
	}
	
	@Test
	public void test() {
		LibraryUser user = new LibraryUser("Hans", "Müller");
		Date date = new Date();
		user.setDateOfBirth(date);
		
		LibraryUser libraryUser = service.addUser(user);
	    Assert.assertNotNull(libraryUser);
		String libraryUserID = libraryUser.getLibraryUserID();
		Assert.assertNotNull(libraryUserID);

		List<LibraryUser> findAll = service.findAll();
		assertNotNull(findAll);
		assertEquals(1, findAll.size());

		LibraryUser findUserByUUID = service.findUserByUUID(libraryUserID);
		assertNotNull(findUserByUUID);

		List<LibraryUser> findUsersByFirstName = service.findUsersByFirstName("Hans");
		assertNotNull(findUsersByFirstName);
		assertEquals(1, findUsersByFirstName.size());
		
		List<LibraryUser> findUsersByDateOfBirth = service.findUsersByDateOfBirth(libraryUser.getDateOfBirth());
		assertNotNull(findUsersByDateOfBirth);
		assertEquals(1, findUsersByDateOfBirth.size());
	}
}
