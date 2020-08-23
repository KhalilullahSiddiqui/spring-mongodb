package com.springboot.springmongodb.controller;

import com.springboot.springmongodb.model.Book;
import com.springboot.springmongodb.repository.BookRepository;
import com.springboot.springmongodb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    //display all books
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("listBooks", bookService.getAllBooks());
        return "index";
    }

    @GetMapping("/showNewBookForm")
    public String showNewBookForm(Model model){
        //Create a model attribute to bind the form data
        Book book = new Book();
        model.addAttribute("book", book);
        return "new_book";
    }

    @PostMapping("/saveBook")
    public String saveBook(@ModelAttribute("book") Book book){
        //save book to database
        bookService.saveBook(book);
        return "redirect:/";

    }

    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value ="id") long id, Model model){
        //get book from the service
        Book book = bookService.getBookById(id);
        //set book as a model attributes to pre-populate the form
        model.addAttribute("book", book);
        return "update_book";

    }

    @GetMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable (value = "id") long id){
        //call delete book method
        this.bookService.deleteBookById(id);
        return "redirect:/";
    }
/*    //Create and Update
    @PostMapping("/addBook")
    public String saveBook(@RequestBody Book book){
        repository.save(book);
        return "Added book with id "+ book.getId();

    }



    //Read
    @GetMapping("/findAllBooks")
    public List<Book> getBook(){
        return repository.findAll();
    }

    @GetMapping("/findAllBooks/{id}")
    public Optional<Book> getBook(@PathVariable int id){
        return repository.findById(id);

    }


    //Delete
    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        repository.deleteById(id);
        return "book deleted with id: "+id;
    }*/



}
