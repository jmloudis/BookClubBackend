package com.xpanxion.bookclub.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column
    private long id;

    @Column
    private String title;
    @Column
    private String author;
    @Column
    private String genre;
    @Column
    private int year_pulished;
    @Column
    private int total_salse;
    @Column
    private double price;
    @Column
    private String imageUrl;

    public Book(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear_pulished() {
        return year_pulished;
    }

    public void setYear_pulished(int year_pulished) {
        this.year_pulished = year_pulished;
    }

    public int getTotal_salse() {
        return total_salse;
    }

    public void setTotal_salse(int total_salse) {
        this.total_salse = total_salse;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
