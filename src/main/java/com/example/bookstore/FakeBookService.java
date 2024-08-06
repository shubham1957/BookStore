package com.example.bookstore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class FakeBookService implements BookService{
    @Override
    public String doSomething() {
        return "Something";
    }
}
