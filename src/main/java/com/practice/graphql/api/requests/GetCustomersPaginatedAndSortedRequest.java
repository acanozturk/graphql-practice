package com.practice.graphql.api.requests;

import lombok.Data;

@Data
public class GetCustomersPaginatedAndSortedRequest {

    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;
    private String sortDirection;

}
