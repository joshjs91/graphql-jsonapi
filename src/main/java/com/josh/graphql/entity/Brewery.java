package com.josh.graphql.entity;

import io.crnk.core.resource.annotations.JsonApiId;
import io.crnk.core.resource.annotations.JsonApiResource;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Data
@JsonApiResource(type = "breweries")
@EqualsAndHashCode
@Entity
public class Brewery {

    @Id
    @JsonApiId
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "brewery")
    private List<Beer> beers;

    private transient  String formattedDate;

}
