package com.example.bookstore;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/books")
    public void createTodo(@RequestBody Book book){
        bookList.add(book);
    }
    @DeleteMapping("/books/{id}")
    public void deleteTodo(@PathVariable int id){
        for(Book b : bookList){
            if(b.getId()==id){
                bookList.remove(b);
                break;
            }
        }
    }


}
