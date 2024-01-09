package com.hendisantika.springbootpdfsample.exception;

import com.hendisantika.springbootpdfsample.exception.base.ServiceException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/9/24
 * Time: 08:49
 * To change this template use File | Settings | File Templates.
 */
public class TooManyRequestsException extends ServiceException {

    public TooManyRequestsException() {
        super();
    }

    public TooManyRequestsException(String message) {
        super(message);
    }

    public TooManyRequestsException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
