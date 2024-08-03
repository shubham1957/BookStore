package com.example.bookstore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    public static List<Book> bookList;
    public  BookController(){
        bookList = new ArrayList<>();
        bookList.add(new Book(2020,"Book1",1));
        bookList.add(new Book( 2021,"Book2",2));
        bookList.add(new Book(2022,"Book3",3));
    }

    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookList;
    }

}
