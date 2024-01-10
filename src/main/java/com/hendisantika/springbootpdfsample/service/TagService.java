package com.hendisantika.springbootpdfsample.service;

import com.hendisantika.springbootpdfsample.entity.Tag;
import com.hendisantika.springbootpdfsample.exception.BadRequestException;
import com.hendisantika.springbootpdfsample.exception.DataNotFoundException;
import com.hendisantika.springbootpdfsample.repository.TagRepository;
import com.hendisantika.springbootpdfsample.util.Translator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Optional;

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

    public Tag createOrUpdate(Tag tagRequest) {
        Optional<Tag> existingTag = tagRepository.findById(tagRequest.getId());

        if (existingTag.isPresent()) {
            Tag tagUpdate = existingTag.get();

            tagUpdate.setName(tagRequest.getName());

            return tagRepository.save(tagUpdate);
        } else {
            return tagRepository.save(tagRequest);
        }
    }

    public void deleteById(Long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (tag.isPresent()) {
            tagRepository.deleteById(id);
        } else {
            throw new BadRequestException(Translator.toLocale("DELETE_ERROR_PLEASE_CHECK_ID"));
        }
    }
}
