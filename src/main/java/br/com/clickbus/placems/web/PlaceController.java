package br.com.clickbus.placems.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clickbus.placems.domain.entity.Place;
import br.com.clickbus.placems.domain.service.PlaceService;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Mono<Place>> create(@RequestBody Place place) {
        var createdPlace = placeService.create(place);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPlace);
    }

}
