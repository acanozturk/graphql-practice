package com.practice.graphql.api.responses;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
public abstract class AbstractBaseResponse {

    private String message;

}
