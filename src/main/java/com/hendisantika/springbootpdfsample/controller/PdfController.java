package com.hendisantika.springbootpdfsample.controller;

import com.hendisantika.springbootpdfsample.service.PdfService;
import com.itextpdf.text.DocumentException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-pdf-sample
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 1/10/24
 * Time: 07:26
 * To change this template use File | Settings | File Templates.
 */
@RestController
@CrossOrigin
@RequiredArgsConstructor
public class PdfController {

    private final PdfService service;

    @GetMapping("/v1/pdf/write-text")
    public ResponseEntity<Void> writeText() throws DocumentException, FileNotFoundException {
        service.writeText();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/v1/pdf/write-image")
    public ResponseEntity<Void> writeImage()
            throws DocumentException, URISyntaxException, IOException {

        service.writeImage();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/v1/pdf/write-table")
    public ResponseEntity<Void> writeTable()
            throws DocumentException, IOException, URISyntaxException {

        service.writeTable();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/v1/pdf/stamper")
    public ResponseEntity<Void> stamper() throws DocumentException, IOException {
        service.stamper();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
