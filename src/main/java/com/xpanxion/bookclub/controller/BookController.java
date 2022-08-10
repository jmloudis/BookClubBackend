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
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id ){
        this.bookRepository.deleteById(id);
        System.out.println("deleted");
    }
    @GetMapping("books/{id}")
    public Book getByBookId(@PathVariable Long id){
        return this.bookRepository.findById(id).get();
    }
    @PutMapping("books/{id}")
    public Book updateBookById(@PathVariable Long id, @RequestBody Book updatedBook){
        Book bookDb = bookRepository.findById(id).get();
        bookDb.setAuthor(updatedBook.getAuthor());
        bookDb.setGenre(updatedBook.getGenre());
        bookDb.setPrice(updatedBook.getPrice());
        bookDb.setImageUrl(updatedBook.getImageUrl());
        bookDb.setTitle(updatedBook.getTitle());
        bookDb.setYearPublished(updatedBook.getYearPublished());
        bookDb.setTotalSales(updatedBook.getTotalSales());

        return this.bookRepository.save(bookDb);
    }


}
