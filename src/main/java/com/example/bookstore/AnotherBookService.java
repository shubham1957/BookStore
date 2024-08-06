package com.example.bookstore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
@Primary //making this class bean as primary
public class AnotherBookService implements BookService{
    @Override
    public String doSomething() {
        return "Something from another class";
    }
}



