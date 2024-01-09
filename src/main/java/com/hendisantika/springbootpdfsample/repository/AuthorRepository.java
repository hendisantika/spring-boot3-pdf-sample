package com.hendisantika.springbootpdfsample.repository;

import com.hendisantika.springbootpdfsample.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
