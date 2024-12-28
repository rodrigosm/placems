package br.com.clickbus.placems.domain.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import br.com.clickbus.placems.domain.entity.Place;


public interface PlaceRepository extends ReactiveCrudRepository<Place, Long> {


}
