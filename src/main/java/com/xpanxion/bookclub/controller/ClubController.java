package com.xpanxion.bookclub.controller;


import com.xpanxion.bookclub.model.Book;
import com.xpanxion.bookclub.model.Club;
import com.xpanxion.bookclub.repository.BookRepository;
import com.xpanxion.bookclub.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:4200")
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
    public Club createClub(@RequestBody Club club, @PathVariable Long id) {

        Book book=this.bookRepository.findById(id).get();
        club.setBook(book);
        return this.clubRepository.save(club);
    }
    @GetMapping("/clubs/{id}")
    public Club getClubById(@PathVariable Long id){
        return this.clubRepository.findById(id).get();
    }

    @DeleteMapping("/clubs/{id}")
    public void deleteClub(@PathVariable Long id ){
        this.clubRepository.deleteById(id);
        System.out.println("deleted");
    }
    @PutMapping("/books/{bookId}/clubs/{id}")
    public Club updateClubById(@PathVariable Long id, @PathVariable Long bookId ,@RequestBody Club updatedClub){
        Club clubDb = clubRepository.findById(id).get();
        Book bookDb = bookRepository.findById(bookId).get();
        clubDb.setName(updatedClub.getName());
        clubDb.setMembers(updatedClub.getMembers());
        clubDb.setMeetingTime(updatedClub.getMeetingTime());
        clubDb.setBook(bookDb);

        return this.clubRepository.save(clubDb);
    }

}
