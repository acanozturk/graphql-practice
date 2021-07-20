package com.practice.graphql.api.responses;

import com.practice.graphql.api.dtos.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractGetMultipleCustomersResponse extends AbstractBaseResponse {

    private Integer count;
    private List<Customer> customers;

}
