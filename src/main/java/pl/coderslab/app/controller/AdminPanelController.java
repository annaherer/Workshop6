package pl.coderslab.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.model.Book;
import pl.coderslab.app.repository.BookRepository;
import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/adminPanel")
public class AdminPanelController {

    private final BookRepository bookRepository;

    public AdminPanelController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @ModelAttribute("allBooks")
    public Collection<Book> allBooks() {
        return this.bookRepository.findAll();
    }

    @GetMapping(value = "addBook")
    public String addBook(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "/addEditBook";
    }

    @PostMapping(value = "addBook")
    public String processAddBook(@Valid @ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/addEditBook";
        }
        bookRepository.save(book);
        return "redirect:/adminPanel";
    }

    @GetMapping(value = "/editBook/{book}")
    public String editBook(@PathVariable Book book, Model model) {
        model.addAttribute("book", book);
        return "/addEditBook";
    }

    @PostMapping(value = "/editBook/{id}")
    public String processEditBook(@Valid @ModelAttribute Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "/addEditBook";
        }
        bookRepository.save(book);
        return "redirect:/adminPanel";
    }

    @GetMapping(value = "/deleteBook/{book}")
    public String deleteBook(@PathVariable Book book) {
        bookRepository.delete(book);
        return "redirect:/adminPanel";
    }

    @GetMapping("displayBook/{book}")
    String displayBook(@PathVariable @ModelAttribute Book book) {
        return "/displayBook";
    }

    @GetMapping
    public String listBooks() {
        return "/adminPanel";
    }
}