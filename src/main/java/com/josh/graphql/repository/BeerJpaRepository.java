// Copyright (c) 2019 Travelex Ltd

package com.josh.graphql.repository;

import com.josh.graphql.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

interface BeerJpaRepository extends JpaRepository<Beer, Long> {

}
