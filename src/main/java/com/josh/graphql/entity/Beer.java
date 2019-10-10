package com.josh.graphql.entity;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@EqualsAndHashCode
@Entity
@JsonApiResource(type = "beers")
public class Beer {

    @Id
    @JsonApiId
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "style", nullable = false)
    private String style;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Brewery.class)
    private Brewery brewery;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "beer")
    private List<Ingredient> ingredients;

    private transient  String formattedDate;

}
