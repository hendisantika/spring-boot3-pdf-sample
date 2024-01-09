package com.hendisantika.springbootpdfsample.midlleware;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/9/24
 * Time: 08:30
 * To change this template use File | Settings | File Templates.
 */
public class ThrottlingMiddleware extends Middleware {

    private final int requestPerMinute;
    private int request;
    private final long currentTime;

    public ThrottlingMiddleware(int requestPerMinute) {
        this.requestPerMinute = requestPerMinute;
        this.currentTime = System.currentTimeMillis();
    }
}
