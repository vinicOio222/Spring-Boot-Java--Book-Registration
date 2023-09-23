package com.project.Book.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.project.Book.models.Book;
import com.project.Book.repository.BookRepository;

import java.util.List;

@Controller
@RequestMapping("/")
public class BookController{
    private BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @RequestMapping(value = "/{author}", method = RequestMethod.GET)
    public String booksList(@PathVariable("author") String author, Model model){
        List<Book> booksList = bookRepository.findByAuthor(author);
        if(booksList != null){
            model.addAttribute("books", booksList);
        }
        return "booksList";
    }

    @RequestMapping(value = "/{author}", method = RequestMethod.POST)
    public String addBooksWithAuthor(@PathVariable("author") String author, Book book){
        book.setAuthor(author);
        bookRepository.save(book);
        return "redirect:/{author}";
    }


}
