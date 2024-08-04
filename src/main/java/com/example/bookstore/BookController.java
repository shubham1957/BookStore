package com.example.bookstore;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/api/books/v1") //API Versioning (Parent URL)
public class BookController {
    public static List<Book> bookList;
    public  BookController(){
        bookList = new ArrayList<>();
        bookList.add(new Book(2020,"Book1",1));
        bookList.add(new Book( 2021,"Book2",2));
        bookList.add(new Book(2022,"Book3",3));
    }

    //Create a book (CREATE)
    @PostMapping()
    public ResponseEntity<Void> createTodo(@RequestBody Book book){
        bookList.add(book);
        return ResponseEntity.status(HttpStatus.CREATED).build(); // Return 201 Created status
    }

    //Get all created books (READ)
    @GetMapping()
    public ResponseEntity<List<Book>> getBooks(){

        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    //Update a specific book (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book book){
        for(int i = 0; i<bookList.size();i++){
            if(bookList.get(i).getId()==id){
                bookList.set(i,book);
                return ResponseEntity.status(HttpStatus.OK).body(bookList.get(i));

            }
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    //Delete a Book (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        for(Book b : bookList){
            if(b.getId()==id){
                bookList.remove(b);
                return ResponseEntity.status(HttpStatus.OK).build();
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //Search a book by id (SEARCH)
    @GetMapping("/{id}")
    public ResponseEntity<Book> searchBook(@PathVariable Long id){
        for(Book b : bookList){
            if(b.getId()==id){
                return  ResponseEntity.status(HttpStatus.OK).body(b);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
