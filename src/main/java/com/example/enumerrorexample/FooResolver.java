package com.example.enumerrorexample;

import graphql.kickstart.tools.GraphQLResolver;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class FooResolver implements GraphQLResolver<Foo> {

    public Bar bar(Foo foo, DataFetchingEnvironment dataFetchingEnvironment) {
        List<StatusEnum> status = dataFetchingEnvironment.getExecutionStepInfo().getParent().getArgument("fooStatus");
        status.forEach(System.out::println);

        List<Bar> result = new ArrayList<>();
        result.add(new Bar());
        return new Bar();
    }
}