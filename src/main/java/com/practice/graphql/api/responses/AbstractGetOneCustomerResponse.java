package com.practice.graphql.api.responses;

import com.practice.graphql.api.dtos.Customer;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public abstract class AbstractGetOneCustomerResponse extends AbstractBaseResponse {

    private Customer customer;

}
