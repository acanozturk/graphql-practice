package com.practice.graphql.api.responses;

import lombok.Data;

import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Data
public abstract class AbstractBaseResponse {

    private String message = "success";
    private String timestamp = Timestamp.from(ZonedDateTime.now().toInstant().truncatedTo(ChronoUnit.SECONDS)).toString();

}
