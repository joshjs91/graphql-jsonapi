package com.josh.graphql.graphQl.query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.josh.graphql.entity.Brewery;
import com.josh.graphql.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BreweryQuery implements GraphQLQueryResolver {

    @Autowired
    private BreweryService breweryService;

    public List<Brewery> getBreweries(final int count) {
        return this.breweryService.getAllBreweries(count);
    }

    public Optional<Brewery> getBrewery(final int id) {
        return this.breweryService.getBrewery(id);
    }
}
