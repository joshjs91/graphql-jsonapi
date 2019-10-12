package com.josh.graphql.entity;

import com.yahoo.elide.annotation.Include;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
@EqualsAndHashCode
@Entity
@Include(type = "ingredient")
public class Ingredient {

    @Id
    private int id;

    @ManyToOne
    private Beer beer;

    private String name;

    private Double amount;

    private String measurement;
}
