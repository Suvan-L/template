package com.template.controller;


import com.template.service.dao.StudentDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * hello
 * </p>
 *
 * @author amdin
 * @since 2022-04-04
 */
@RestController
@RequestMapping()
public class HelloController {


    @Autowired
    private StudentDAOService studentDAOService;


    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
