package com.prodyna.ted.library.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jongo.Jongo;

import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;
import com.prodyna.ted.library.entity.LibraryUser;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Stateless
public class LibraryUserServiceBean implements LibraryUserService {
	
	private static final String LIBARY_USER = "libaryUser";

	@Inject
	private Jongo jongo;

	@Override
	public void addUser(LibraryUser user) {
		jongo.getCollection(LIBARY_USER).save(user);
	}

	@Override
	public void removeUser(UUID uuid) {
		jongo.getCollection(LIBARY_USER).remove("{libraryUserID:#}", uuid);
	}

	@Override
	public LibraryUser findUserByUUID(UUID uuid) {
		return jongo.getCollection(LIBARY_USER).findOne("{libraryUserID:#}", uuid).as(LibraryUser.class);
	}

	@Override
	public List<LibraryUser> findUsersByUsername(String username) {
		Iterator<LibraryUser> iterator = jongo.getCollection(LIBARY_USER).find("{username:'" + username + "'}").as(LibraryUser.class).iterator();
		return toList(iterator);
	}

	@Override
	public List<LibraryUser> findUsersByFirstName(String firstname) {
		Iterator<LibraryUser> iterator = jongo.getCollection(LIBARY_USER).find("{firstName:'" + firstname + "'}").as(LibraryUser.class).iterator();
		List<LibraryUser> list = toList(iterator);
		return list;
	}

	@Override
	public List<LibraryUser> findUsersByLastName(String lastname) {
		Iterator<LibraryUser> iterator = jongo.getCollection(LIBARY_USER).find("{lastName:'" + lastname + "'}").as(LibraryUser.class).iterator();
		return toList(iterator);
	}

	@Override
	public List<LibraryUser> findUsersByDateOfBirth(Date dateOfBirth) {
		Iterator<LibraryUser> iterator = jongo.getCollection(LIBARY_USER).find("{dateOfBirth:#}", dateOfBirth).as(LibraryUser.class).iterator();
		return toList(iterator);
	}

	@Override
	public LibraryUser findUserByBookLent(Book book) {
		return jongo.getCollection(LIBARY_USER).findOne("{lentBooks.isbn:'" + book.getIsbn() + "'}").as(LibraryUser.class);
	}

	@Override
	public List<LibraryUser> findUsersByBooksLentInCategory(Category category) {
		Iterator<LibraryUser> iterator = jongo.getCollection(LIBARY_USER).find("{lentBooks.categories:#}", category).as(LibraryUser.class).iterator();
		return toList(iterator);
	}

	private List<LibraryUser> toList(Iterator<LibraryUser> iterator) {
		List<LibraryUser> list = new ArrayList<>();
		while (iterator.hasNext()) {
			list.add(iterator.next());
		}
		return list;
	}

	@Override
	public void lendBook(Book book, LibraryUser user) {
		user.getLentBooks().add(book);
		jongo.getCollection(LIBARY_USER).update("{libraryUserID:#}", user.getLibraryUserID()).with(user);
	}

	@Override
	public List<Book> findBooksLentByUser(LibraryUser user) {
		LibraryUser findUserByUUID = findUserByUUID(user.getLibraryUserID());
		return findUserByUUID.getLentBooks();
	}
	
	@Override
	public void removeAll() {
		jongo.getCollection(LIBARY_USER).remove();
	}

	@Override
	public List<LibraryUser> findAll() {
		Iterator<LibraryUser> iterator = jongo.getCollection(LIBARY_USER).find().as(LibraryUser.class).iterator();
		return toList(iterator);
	}

}
