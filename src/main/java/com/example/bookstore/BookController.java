package com.example.bookstore;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/books") //API Versioning (Parent URL)
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
    public ResponseEntity<Book> createTodo(@RequestBody Book newBook){
        bookList.add(newBook);
        return ResponseEntity.status(HttpStatus.CREATED).body(newBook); // Return 201 Created status
    }

    //Get all created books (READ)
    @GetMapping()
    public ResponseEntity<List<Book>> getBooks(){

        return ResponseEntity.status(HttpStatus.OK).body(bookList);
    }

    //Update a specific book (UPDATE)
    @PutMapping("/{id}")
    public ResponseEntity<Object> updateBook(@PathVariable Long id,@RequestBody Book book){
        for(int i = 0; i<bookList.size();i++){
            if(bookList.get(i).getId()==id){
                bookList.set(i,book);
                return ResponseEntity.status(HttpStatus.OK).body(bookList.get(i));

            }
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(new String("Book id:" +id+" Not Found !!"));
    }

    //Delete a Book (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTodo(@PathVariable Long id){
        for(Book b : bookList){
            if(b.getId()==id){
                bookList.remove(b);
                return ResponseEntity.status(HttpStatus.OK).body(new String("Book deleted Successfully."));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new String("Book id:" +id+" Not Found !!"));
    }

    //Search a book by id (SEARCH)
    @GetMapping("/{id}")
    public ResponseEntity<Object> searchBook(@PathVariable Long id){
        for(Book b : bookList){
            if(b.getId()==id){
                return  ResponseEntity.status(HttpStatus.OK).body(b);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(new String ("Book id:" +id+" Not Found !!"));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Object> updateBookPartially (@PathVariable Long id, @RequestBody Book book){
        for(Book b : bookList){
            if(b.getId()==id){
                System.out.println(b);
                if(book.getAuthor()!=null){
                    b.setAuthor(book.getAuthor());
                }
                if(book.getYear()!=0){
                    b.setYear(book.getYear());
                }
                return ResponseEntity.status(HttpStatus.OK).body(b);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book id:" +id+" Not Found !!");
    }

}
