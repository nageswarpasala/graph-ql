package com.example.demo.query;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class Query{

    @QueryMapping
    public String firstName() {
        return "Nageswar";
    }

    @QueryMapping
    public String lastName() {
        return "Pasala";
    }
}
