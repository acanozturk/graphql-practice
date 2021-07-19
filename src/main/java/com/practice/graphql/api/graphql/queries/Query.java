package com.practice.graphql.api.graphql.queries;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    public String testQuery() {

        return "Test";
    }

}
