package com.example.bookstore;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
    public static List<Book> books;
    public  BookController(){
        books = new ArrayList<>();
        books.add(new Book(2020,"Book1",1));
        books.add(new Book(2021,"Book2",2));
    }

}
