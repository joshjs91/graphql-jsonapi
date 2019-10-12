package com.josh.graphql.entity;

import com.yahoo.elide.annotation.Include;
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

@Include(rootLevel = true, type = "beer")
@Data
@EqualsAndHashCode
@Entity
public class Beer {

    @Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;

    @Column(name = "style", nullable = false)
    private String style = "";

    @Column(name = "name")
    private String name;

//    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Brewery.class)
//    private Brewery brewery;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "beer")
    private List<Ingredient> ingredients;

    private transient String formattedDate;

}
