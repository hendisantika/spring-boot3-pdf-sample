package com.hendisantika.springbootpdfsample.service;

import com.hendisantika.springbootpdfsample.entity.Tag;
import com.hendisantika.springbootpdfsample.exception.DataNotFoundException;
import com.hendisantika.springbootpdfsample.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/10/24
 * Time: 07:22
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
public class TagService {

    private final TagRepository tagRepository;

    public List<Tag> getAllTags() {
        List<Tag> tagList = tagRepository.findAll();
        return tagList;
    }

    public Tag getById(Long id) {
        return tagRepository
                .findById(id)
                .orElseThrow(
                        () ->
                                new DataNotFoundException(
                                        MessageFormat.format("Tag id {0} not found", String.valueOf(id))));
    }
}
