package com.josh.graphql.controller;

import com.josh.graphql.entity.Beer;
import com.josh.graphql.service.BeerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Controller
public class BeerController {

    @Autowired
    private BeerService beerService;

    @PostMapping(value = "/v1/beers", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Beer> createBeer(@RequestBody Beer beer) {
//        how to do brewery id on here?
        Beer createdBeer = beerService.createBeer(beer, null);
        return new ResponseEntity<>(createdBeer, HttpStatus.CREATED);
    }

//    plain old rest how do you determine that you are adding
    @GetMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Beer> getBeer(@PathVariable int beerId) {
        Optional<Beer> beerOpt = beerService.getBeer(beerId);
        return beerOpt.map(beer -> new ResponseEntity<>(beer, HttpStatus.CREATED))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }
}
