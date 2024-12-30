package br.com.clickbus.placems.domain.service;

import com.github.slugify.Slugify;

import br.com.clickbus.placems.api.PlaceRequest;
import br.com.clickbus.placems.domain.entity.Place;
import br.com.clickbus.placems.domain.repository.PlaceRepository;
import reactor.core.publisher.Mono;

public class PlaceService {
    private PlaceRepository placeRepository;
    private Slugify slug;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
        this.slug = Slugify.builder().build();
    }

    // Retonar Mono<*> (Para uma única entidade utilizar, para uma lista utilizar
    // Flux) devido ao uso do SpringBoot Reativo para melhorar o perfomance.
    // Referência:
    // https://projectreactor.io/docs/core/release/reference/apdx-operatorChoice.html
    public Mono<Place> create(PlaceRequest placeRequest) {
        var place = new Place(null, placeRequest.name(), slug.slugify(placeRequest.name()), placeRequest.city(),
                placeRequest.state(), null, null); //Campos nulos gerados pelo Spring Data anotado no Place.java
        return placeRepository.save(place);
    }
}
