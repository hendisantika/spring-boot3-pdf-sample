package com.hendisantika.springbootpdfsample.repository;

import com.hendisantika.springbootpdfsample.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/9/24
 * Time: 08:42
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    Page<Post> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    @Modifying
    @Query(value = "SELECT p FROM Post p WHERE lower(p.title) LIKE lower(concat('%', ?1,'%'))")
    List<Post> selectPosts(String title);

    @Modifying
    @Query("DELETE FROM Post p WHERE p.title = :title OR p.body = :body")
    int deletePosts(@Param("title") String title, @Param("body") String body);
}
