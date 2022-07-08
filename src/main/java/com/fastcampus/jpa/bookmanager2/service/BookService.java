package com.fastcampus.jpa.bookmanager2.service;

import com.fastcampus.jpa.bookmanager2.domain.Author;
import com.fastcampus.jpa.bookmanager2.domain.Book;
import com.fastcampus.jpa.bookmanager2.repository.AuthorRepository;
import com.fastcampus.jpa.bookmanager2.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {
	private final BookRepository bookRepository;
	private final AuthorRepository authorRepository;

	public void putBookAndAuthor(){
		Book book = new Book();
		book.setName("JPA 시작하기");

		bookRepository.save(book);

		Author author = new Author();
		author.setName("martin");

		authorRepository.save(author);
	}
}
