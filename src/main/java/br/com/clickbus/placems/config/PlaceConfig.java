package br.com.clickbus.placems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.clickbus.placems.domain.repository.PlaceRepository;
import br.com.clickbus.placems.domain.service.PlaceService;

@Configuration
public class PlaceConfig {
    @Bean
    PlaceService placeService(PlaceRepository placeRespository) {
        return new PlaceService(placeRespository);
    }

}
