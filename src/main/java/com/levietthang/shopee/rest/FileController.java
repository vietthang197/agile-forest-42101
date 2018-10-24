package com.levietthang.shopee.rest;

import com.sun.jersey.core.header.*;
import com.sun.jersey.multipart.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.*;
import javax.servlet.http.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@ComponentScan(basePackages = {"com.levietthang.eeshopserver", "com.levietthang.eeshopserver.rest"})
@RequestMapping("/api/files/uploads")
public class FileController {
    Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private final Path rootLocation = Paths.get("upload-dir");

    @GetMapping
    public String uploadOneFile() {
        return rootLocation.toString();
    }
}
