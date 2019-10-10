// Copyright (c) 2019 Travelex Ltd

package com.josh.graphql.repository;

import com.josh.graphql.entity.Beer;
import io.crnk.core.queryspec.QuerySpec;
import io.crnk.core.repository.ResourceRepositoryBase;
import io.crnk.core.resource.list.ResourceList;
import org.springframework.beans.factory.annotation.Autowired;

public class BeerRepository extends ResourceRepositoryBase<Beer, Long> {

    @Autowired
    private BeerJpaRepository beerJpaRepository;

    public BeerRepository() {
        super(Beer.class);
    }

    @Override
    public synchronized void delete(Long id) {
        beerJpaRepository.deleteById(id);
    }

    @Override
    public synchronized <S extends Beer> S save(S beer) {
        //Note if you want to differentiate between post and patch, filters can be added
        return beerJpaRepository.save(beer);
    }

    @Override
    public synchronized ResourceList<Beer> findAll(QuerySpec querySpec) {
        //Note currently reads everything in memory then does filtering, but filters can be converted query expressions if really needed
        return querySpec.apply(beerJpaRepository.findAll());
    }
}
