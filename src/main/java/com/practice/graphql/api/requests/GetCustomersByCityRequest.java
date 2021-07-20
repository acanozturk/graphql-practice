package com.practice.graphql.api.requests;

import lombok.Data;

import java.util.List;

@Data
public class GetCustomersByCityRequest {

    private List<String> cities;

}
