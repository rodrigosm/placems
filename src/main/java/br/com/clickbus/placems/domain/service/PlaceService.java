package br.com.clickbus.placems.domain.service;

import br.com.clickbus.placems.domain.entity.Place;
import br.com.clickbus.placems.domain.repository.PlaceRepository;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    // Retonar Mono<*> (Para uma única entidade utilizar, para uma lista utilizar
    // Flux) devido ao uso do SpringBoot Reativo para melhorar o perfomance.
    // Referência:
    // https://projectreactor.io/docs/core/release/reference/apdx-operatorChoice.html
    public Mono<Place> create(Place place) {
        return placeRepository.save(place);
    }
}
