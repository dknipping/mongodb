package com.prodyna.ted.library.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import org.jongo.Jongo;

import com.prodyna.ted.library.entity.Book;
import com.prodyna.ted.library.entity.Category;

/**
 * @author Iryna Feuerstein (PRODYNA AG)
 *
 */
@Stateless
public class BookServiceBean implements BookService {

	private static final String BOOKS = "books";

	@Inject
	private Jongo jongo;

	@Override
	public void addBook(Book book) {
		jongo.getCollection(BOOKS).save(book);
	}

	@Override
	public void removeBook(String isbn) {
		jongo.getCollection(BOOKS).remove("{isbn:'" + isbn + "'}");
	}

	@Override
	public Book findBookByISBN(String isbn) {
		return jongo.getCollection(BOOKS).findOne("{isbn:'" + isbn + "'}").as(Book.class);
	}

	@Override
	public List<Book> findBooksByTitle(String title) {
		Iterator<Book> iterator = jongo.getCollection(BOOKS).find("{title:'" + title + "'}").as(Book.class).iterator();
		return toList(iterator);
	}

	@Override
	public List<Book> findBooksByAuthor(String author) {
		Iterator<Book> iterator = jongo.getCollection(BOOKS).find("{authors:'" + author + "'}").as(Book.class).iterator();
		return toList(iterator);
	}

	@Override
	public List<Book> findBooksByCategory(Category category) {
		Iterator<Book> iterator = jongo.getCollection(BOOKS).find("{categories:#}", category).as(Book.class).iterator();
		return toList(iterator);
	}

	@Override
	public void removeAll() {
		jongo.getCollection(BOOKS).remove();
	}

	@Override
	public List<Book> findAll() {
		Iterator<Book> iterator = jongo.getCollection(BOOKS).find().as(Book.class).iterator();
		return toList(iterator);
	}
	
	private List<Book> toList(Iterator<Book> iterator) {
		List<Book> books = new ArrayList<>();
		while (iterator.hasNext()) {
			books.add(iterator.next());
		}
		return books;
	}
}
