package com.hendisantika.springbootpdfsample.controller;

import com.hendisantika.springbootpdfsample.dto.PostDTO;
import com.hendisantika.springbootpdfsample.entity.Post;
import com.hendisantika.springbootpdfsample.service.PostService;
import com.hendisantika.springbootpdfsample.util.PageUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    private final PostService postService;

    @GetMapping("/v1/posts")
    public ResponseEntity<Page<Post>> getAllPosts(
            Pageable pageable, @RequestParam(required = false) String title) {

        Page<Post> list = postService.getAllPosts(PageUtils.pageable(pageable), title);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/v1/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
        Post entity = postService.getById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/v1/posts")
    public ResponseEntity<Post> createOrUpdate(@Valid @RequestBody PostDTO postDTO) {
        Post updated = postService.createOrUpdate(postDTO);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/v1/posts/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        postService.deleteById(id);
    }
}
