package com.hendisantika.springbootpdfsample.controller;

import com.hendisantika.springbootpdfsample.entity.Tag;
import com.hendisantika.springbootpdfsample.service.TagService;
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
 * Time: 07:31
 * To change this template use File | Settings | File Templates.
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    @GetMapping("/v1/tags")
    public ResponseEntity<List<Tag>> getAllTags() {
        List<Tag> list = tagService.getAllTags();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/v1/tags/{id}")
    public ResponseEntity<Tag> getTagById(@PathVariable("id") Long id) {
        Tag entity = tagService.getById(id);
        return new ResponseEntity<>(entity, HttpStatus.OK);
    }

    @PostMapping("/v1/tags")
    public ResponseEntity<Tag> createOrUpdate(@RequestBody Tag Tag) {
        Tag updated = tagService.createOrUpdate(Tag);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/v1/tags/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        tagService.deleteById(id);
    }
}
