package com.example.enumerrorexample;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class Query implements GraphQLQueryResolver{

    public List<Foo> foos(Set<StatusEnum> status) {
        List<Foo> result = new ArrayList<>();
        result.add(new Foo());
        return result;
    }

    public Bar bars() {
        return new Bar();
    }
}
