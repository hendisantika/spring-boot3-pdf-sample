package com.hendisantika.springbootpdfsample.service;

import com.hendisantika.springbootpdfsample.dto.PostDTO;
import com.hendisantika.springbootpdfsample.entity.Author;
import com.hendisantika.springbootpdfsample.entity.Post;
import com.hendisantika.springbootpdfsample.entity.Tag;
import com.hendisantika.springbootpdfsample.exception.DataNotFoundException;
import com.hendisantika.springbootpdfsample.repository.AuthorRepository;
import com.hendisantika.springbootpdfsample.repository.PostRepository;
import com.hendisantika.springbootpdfsample.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
 * Time: 07:19
 * To change this template use File | Settings | File Templates.
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final ModelMapper modelMapper;

    private final PostRepository postRepository;

    private final AuthorRepository authorRepository;

    private final TagRepository tagRepository;

    @Cacheable(value = "posts")
    public Page<Post> getAllPosts(Pageable pageable, String title) {
        Page<Post> postList;
        if (title == null) {
            postList = postRepository.findAll(pageable);
        } else {
            postList = postRepository.findByTitleContainingIgnoreCase(title, pageable);
        }
        return postList;
    }

    public Post getById(Long id) {
        return postRepository
                .findById(id)
                .orElseThrow(
                        () ->
                                new DataNotFoundException(
                                        MessageFormat.format("Post id {0} not found", String.valueOf(id))));
    }

    public Post createOrUpdate(PostDTO postRequest) {
        Optional<Post> existingPost = postRepository.findById(postRequest.getId());

        if (existingPost.isPresent()) {
            Post postUpdate = existingPost.get();

            postUpdate.setTitle(postRequest.getTitle());
            postUpdate.setBody(postRequest.getBody());
            if (postRequest.getAuthorId() != 0) {
                Optional<Author> author = authorRepository.findById(postRequest.getAuthorId());
                author.ifPresent(postUpdate::setAuthor);
            }

            return postRepository.save(postUpdate);
        } else {
            return postRepository.save(modelMapper.map(postRequest, Post.class));
        }
    }

    public List<Tag> getAllTagsByPostId(Long id) {
        if (!postRepository.existsById(id)) {
            throw new DataNotFoundException(
                    MessageFormat.format("Post id {0} not found", String.valueOf(id)));
        }

        List<Tag> tagList = postRepository.findById(id).get().getTagList();
        return tagList;
    }
}
