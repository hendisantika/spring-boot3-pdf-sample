package com.hendisantika.springbootpdfsample.exception.base;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Timestamp;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/9/24
 * Time: 08:47
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@RestControllerAdvice
public class BaseControllerAdvice {

    public static final Timestamp TIMESTAMP = new Timestamp(System.currentTimeMillis());

}
