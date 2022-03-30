package com.example.appmanytomany.taller.rest;

import com.example.appmanytomany.taller.entidades.Author;
import com.example.appmanytomany.taller.entidades.Book;
import com.example.appmanytomany.taller.negocio.NegocioBiblioteca;
import com.example.appmanytomany.taller.repositorio.AuthorRepository;
import com.example.appmanytomany.taller.repositorio.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api")
public class ServiceRest {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private NegocioBiblioteca negocioBiblioteca;

    @PostMapping("/books")
    public List<Book> saveBook(@RequestBody List<Book> bookList) {
        List<Book> bookResponse = bookRepository.saveAll(bookList);
        return bookResponse;
    }

    @PostMapping("/book/addBook")
    public Book addUpdate(@RequestBody Book book) {
        Book b = null;
        b = negocioBiblioteca.registrar(book);
        return b;
    }

    @GetMapping("/books")
    public List<Book> demo() {
        List<Book> list = (List<Book>) bookRepository.findAll();
        return list;
    }

    @PostMapping("/author")
    public Author add(@RequestBody Author author){
        return authorRepository.save(author);
    }

    @GetMapping("/authors")
    public List<Author> listar(){
        return authorRepository.findAll();
    }
}
