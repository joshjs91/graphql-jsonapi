package com.josh.graphql.service;

import com.josh.graphql.entity.Brewery;
import com.josh.graphql.repository.BreweryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BreweryService {

    private final BreweryRepository breweryRepository;

    public BreweryService(final BreweryRepository breweryRepository) {
        this.breweryRepository = breweryRepository;
    }

    @Transactional
    public Brewery createBrewery(Brewery brewery) {
        return this.breweryRepository.save(brewery);
    }

    @Transactional(readOnly = true)
    public List<Brewery> getAllBreweries() {
        return this.breweryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Optional<Brewery> getBrewery(final int id) {
        return this.breweryRepository.findById(id);
    }
}
