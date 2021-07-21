package com.practice.graphql.entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

@Data
@MappedSuperclass
public abstract class AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_at")
    private String createdAt = Timestamp.from(ZonedDateTime.now().toInstant().truncatedTo(ChronoUnit.SECONDS)).toString();

}
