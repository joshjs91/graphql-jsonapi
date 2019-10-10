package com.josh.graphql.graphQl.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.josh.graphql.entity.Brewery;
import com.josh.graphql.service.BreweryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BreweryMutation implements GraphQLMutationResolver {

    @Autowired
    private BreweryService breweryService;

    public Brewery createBrewery(final String name, final String location) {
        Brewery brewery = new Brewery();
        brewery.setName(name);
        brewery.setLocation(location);
        return this.breweryService.createBrewery(brewery);
    }

}
