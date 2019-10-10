package com.josh.graphql.entity;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode
@Entity
public class Ingredient {

    @Id
    @JsonApiId
    private int id;

    @ManyToOne
    private Beer beer;

    private String name;

    private Double amount;

    private String measurement;
}
