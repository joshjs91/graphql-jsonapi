package com.josh.graphql.graphQl.query;

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

    public List<Beer> getBeers(final int count) {
        return this.beerService.getAllBeers(count);
    }

    public Optional<Beer> getBeer(final int id) {
        return this.beerService.getBeer(id);
    }
}
