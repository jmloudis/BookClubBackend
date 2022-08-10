package com.xpanxion.bookclub.controller;

import com.xpanxion.bookclub.model.Book;
import com.xpanxion.bookclub.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return this.bookRepository.findAll();
    }
    @PostMapping("/books")
    public Book createBook(@RequestBody Book book) {
        return this.bookRepository.save(book);
    }

}
