package com.practice.graphql.api.responses;

import com.practice.graphql.api.dtos.Customer;
import lombok.Data;

import java.util.List;

@Data
public abstract class AbstractGetAllResponse {

    private Integer count;
    private List<Customer> customers;

}
