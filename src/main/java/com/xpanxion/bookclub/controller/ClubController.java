package com.xpanxion.bookclub.controller;


import com.xpanxion.bookclub.model.Book;
import com.xpanxion.bookclub.model.Club;
import com.xpanxion.bookclub.repository.BookRepository;
import com.xpanxion.bookclub.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ClubController {
    @Autowired
    private ClubRepository clubRepository;
    @Autowired
     private BookRepository bookRepository;

    @GetMapping("/clubs")
    public List<Club> getAllClubs(){
        return this.clubRepository.findAll();
    }
    @PostMapping("/books/{id}/clubs")
    public Club createClub(@RequestBody Club club,@PathVariable Long id) {

        Book book=this.bookRepository.findById(id).get();
        club.setBook(book);
        return this.clubRepository.save(club);
    }

}
