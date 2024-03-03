package bookManager.controller;

import bookManager.*;
import bookManager.dto.BookAddOrUpdateRequest;
import bookManager.dto.BookIdResponse;
import bookManager.dto.BookListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class bookController {

    private Integer id;
    private String name;
    private Integer year;

    @PostMapping("/book")
    public BookIdResponse createBook(@RequestBody BookAddOrUpdateRequest request){
        Book book = new Book(request.getName(), request.getYear());
        int id = bookStorage.addBook(book);
        return new BookIdResponse(id);
    }

    @GetMapping("/book")
    public BookListResponse getBookList() {
    return new BookListResponse(bookStorage.getBookList());
    }

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id){
        Optional<Book> book = bookStorage.getBook(id);
        return book.isPresent() ?
                new ResponseEntity<>(book.get(), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/book/{id}")
    public void deleteBook(@PathVariable Integer id) {
        bookStorage.deleteBook(id);
    }

    @PutMapping("/book/{id}")
    public void updateBook(@PathVariable Integer id, @RequestBody BookAddOrUpdateRequest request){
        Book book = new Book(request.getName(), request.getYear());
        bookStorage.updateBook(id, book);

    }
}

