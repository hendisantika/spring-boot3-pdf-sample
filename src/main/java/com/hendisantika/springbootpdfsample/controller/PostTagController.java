package com.hendisantika.springbootpdfsample.controller;

import com.hendisantika.springbootpdfsample.entity.Tag;
import com.hendisantika.springbootpdfsample.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/10/24
 * Time: 07:29
 * To change this template use File | Settings | File Templates.
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class PostTagController {

    private final PostService service;

    @GetMapping("/v1/posts/{id}/tags")
    public ResponseEntity<List<Tag>> getAllTagsByPostId(@PathVariable(value = "id") Long id) {
        List<Tag> tagList = service.getAllTagsByPostId(id);
        return new ResponseEntity<>(tagList, HttpStatus.OK);
    }
}
