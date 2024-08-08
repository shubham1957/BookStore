package com.example.bookstore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service("fakeBookService")
public class FakeBookService implements BookService{
    @Override
    @TimeMonitor
    public String doSomething() {

        for(long i = 0;i<10000000000L;i++){}

        return "Something";
    }
}
