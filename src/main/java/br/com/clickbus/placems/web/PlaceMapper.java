package br.com.clickbus.placems.web;

import br.com.clickbus.placems.api.PlaceResponse;
import br.com.clickbus.placems.domain.entity.Place;

public class PlaceMapper {
    public static PlaceResponse fromPlaceToResponse(Place place) {
        return new PlaceResponse(                
                place.id(),
                place.name(),
                place.slug(),
                place.city(),
                place.state(),
                place.createdAt(),
                place.updatedAt()
        );
    }
    
}
