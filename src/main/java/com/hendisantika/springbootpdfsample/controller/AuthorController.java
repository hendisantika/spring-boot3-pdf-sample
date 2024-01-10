package com.hendisantika.springbootpdfsample.controller;

import com.hendisantika.springbootpdfsample.entity.Author;
import com.hendisantika.springbootpdfsample.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/10/24
 * Time: 07:24
 * To change this template use File | Settings | File Templates.
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService service;

    @GetMapping("/v1/authors")
    public ResponseEntity<List<Author>> getAllAuthors() {
        List<Author> list = service.getAllAuthors();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/v1/authors/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable("id") Long id) {
        Author entity = service.getById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/v1/authors")
    public ResponseEntity<Author> createOrUpdate(@RequestBody Author Author) {
        Author updated = service.createOrUpdate(Author);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/v1/authors/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
