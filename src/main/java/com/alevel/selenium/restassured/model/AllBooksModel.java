package com.alevel.selenium.restassured.model;

import java.util.List;

public class AllBooksModel {

    private List<BookModel> books;

    public AllBooksModel(List<BookModel> books) {
        this.books = books;
    }

    public AllBooksModel() {

    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "AllBooksModel{" +
                "books=" + books +
                '}';
    }
}
