package com.josh.graphql.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.josh.graphql.entity.Beer;
import com.josh.graphql.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BeerQuery implements GraphQLQueryResolver {

    @Autowired
    private BeerService beerService;

    public List<Beer> getBeers() {
        return this.beerService.getAllBeers();
    }

    public Optional<Beer> getBeer(final int id) {
        return this.beerService.getBeer(id);
    }
}
