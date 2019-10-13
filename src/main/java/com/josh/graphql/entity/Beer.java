package com.josh.graphql.entity;

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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Data
@EqualsAndHashCode
@Entity
public class Beer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "style", nullable = false)
    private String style;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Brewery.class)
    private Brewery brewery;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name="beer_id")
    private List<Ingredient> ingredients;

    private transient  String formattedDate;

}
