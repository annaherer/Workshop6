package pl.coderslab.app.controller;

import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.Book;
import pl.coderslab.app.repository.BookRepository;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @GetMapping("/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookRepository.findById(bookId).get();
    }

    @PutMapping
    public void changeBook(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @DeleteMapping ("/{book}")
    public void deleteBook(@PathVariable Book book) {
        bookRepository.delete(book);
    }
}