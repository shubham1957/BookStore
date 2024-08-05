package com.example.bookstore;

import jakarta.websocket.server.PathParam;
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
    public final String BOOK_NOT_FOUND = "Book Not Found";
    public  BookController(){
        bookList = new ArrayList<>();
        bookList.add(new Book(1,"Book1",2000, true));
        bookList.add(new Book( 2,"Book2",2021,true));
        bookList.add(new Book(3,"Book3",2022,false));
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
    public ResponseEntity<?> updateBook(@PathVariable Long id,@RequestBody Book book){
        for(int i = 0; i<bookList.size();i++){
            if(bookList.get(i).getId()==id){
                bookList.set(i,book);
                return ResponseEntity.status(HttpStatus.OK).body(bookList.get(i));

            }
        }
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(BOOK_NOT_FOUND);
    }

    //Delete a Book (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id){
        for(Book b : bookList){
            if(b.getId()==id){
                bookList.remove(b);
                return ResponseEntity.status(HttpStatus.OK).body(new String("Book deleted Successfully."));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BOOK_NOT_FOUND);
    }

    //Search a book by id (SEARCH)
    @GetMapping("/{id}")
    public ResponseEntity<?> searchBook(@PathVariable Long id){
        for(Book b : bookList){
            if(b.getId()==id){
                return  ResponseEntity.status(HttpStatus.OK).body(b);
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(BOOK_NOT_FOUND);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<?> updateBookPartially (@PathVariable Long id, @RequestBody Book book){
        for(Book b : bookList){
            if(b.getId()==id){
                System.out.println(b);
                if(book.getBookName()!=null){
                    b.setBookName(book.getBookName());
                }
                if(book.getYear()!=0){
                    b.setYear(book.getYear());
                }
                if(book.isAvailable()==true){
                    b.setAvailable(true);
                }
                return ResponseEntity.status(HttpStatus.OK).body(b);
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(BOOK_NOT_FOUND);
    }



    //Get BookList based on availability
//    @GetMapping()
//    public ResponseEntity<List<Book>> getBooksByFilter(@RequestParam(required = false, defaultValue = "true") Boolean isAvailable){
//
//        List<Book> filteredBookList = new ArrayList<>();
//        for(Book b :bookList ){
//            if(b.isAvailable()==isAvailable){
//                filteredBookList.add(b);
//            }
//        }
//        return ResponseEntity.status(HttpStatus.OK).body(filteredBookList);
//    }

}
