package com.josh.graphql.service;

import com.josh.graphql.entity.Beer;
import com.josh.graphql.entity.Brewery;
import com.josh.graphql.exception.ResourceNotFoundException;
import com.josh.graphql.repository.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BeerService {

    private final BeerRepository beerRepository ;

    private final BreweryService breweryService;

    @Transactional
    public Beer createBeer(Beer beer, Integer breweryId) {

        if (!(breweryId == null)) {
            Brewery brewery = breweryService.getBrewery(breweryId).orElseThrow(() -> new ResourceNotFoundException("Brewery provided does not exist!!!"));
            beer.setBrewery(brewery);
        }

        return this.beerRepository.saveAndFlush(beer);
    }

    @Transactional(readOnly = true)
    public List<Beer> getAllBeers() {
        return this.beerRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Beer> getBeer(final int id) {
        return this.beerRepository.findById(id);
    }
}
