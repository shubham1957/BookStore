package com.example.bookstore;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Void> createTodo(@RequestBody Book book){
        bookList.add(book);
        return new ResponseEntity<>(HttpStatus.CREATED);  // Return 201 Created status
    }
    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable int id){
        for(Book b : bookList){
            if(b.getId()==id){
                bookList.remove(b);
                return new ResponseEntity<>(HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/books/{id}")
    public ResponseEntity<Book> searchBook(@PathVariable int id){
        for(Book b : bookList){
            if(b.getId()==id){
                return  new ResponseEntity<>(b,HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("/books/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable int id,@RequestBody Book book){
        for(int i = 0; i<bookList.size();i++){
            if(bookList.get(i).getId()==id){
                bookList.set(i,book);
                return new ResponseEntity<>(bookList.get(i),HttpStatus.OK);
            }
        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
