package com.josh.graphql.graphQl.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.josh.graphql.entity.Beer;
import com.josh.graphql.entity.Ingredient;
import com.josh.graphql.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BeerMutation implements GraphQLMutationResolver {

    @Autowired
    private BeerService beerService;

    public Beer createBeer(final String style, final String name, final Integer breweryId) {
        Beer beer = new Beer();
        beer.setName(name);
        beer.setStyle(style);
        return this.beerService.createBeer(beer, breweryId);
    }

    public Beer createBeerWithIngredients(final String style, final String name, final Integer breweryId, final List<Ingredient> ingredients) {
        Beer beer = new Beer();
        beer.setName(name);
        beer.setStyle(style);
        beer.setIngredients(ingredients);
        return this.beerService.createBeer(beer, breweryId);
    }

}
