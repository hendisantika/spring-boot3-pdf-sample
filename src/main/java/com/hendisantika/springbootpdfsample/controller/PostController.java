package com.hendisantika.springbootpdfsample.controller;

import com.hendisantika.springbootpdfsample.entity.Post;
import com.hendisantika.springbootpdfsample.service.PostService;
import com.hendisantika.springbootpdfsample.util.PageUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/10/24
 * Time: 07:27
 * To change this template use File | Settings | File Templates.
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @GetMapping("/v1/posts")
    public ResponseEntity<Page<Post>> getAllPosts(
            Pageable pageable, @RequestParam(required = false) String title) {

        Page<Post> list = service.getAllPosts(PageUtils.pageable(pageable), title);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
