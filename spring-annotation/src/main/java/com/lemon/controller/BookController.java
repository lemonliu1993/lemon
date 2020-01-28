package com.lemon.controller;

import com.lemon.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by lemoon on 20/1/25 下午5:44
 */
@Controller
public class BookController {

    @Autowired
    BookService bookService;
}
