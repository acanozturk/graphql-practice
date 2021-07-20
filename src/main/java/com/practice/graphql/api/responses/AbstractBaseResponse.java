package com.practice.graphql.api.responses;

import lombok.Data;

import java.time.Instant;

@Data
public abstract class AbstractBaseResponse {

    private String message = "success";
    private String timestamp = Instant.now().toString();

}
