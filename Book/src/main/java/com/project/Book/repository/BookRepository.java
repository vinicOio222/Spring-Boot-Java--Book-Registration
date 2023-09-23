package com.project.Book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Book.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
    List<Book> findByTitle(String title);
    List<Book> findByAuthor(String author);
    Book findByIsbn(String isbn);
}
