package br.com.clickbus.placems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import br.com.clickbus.placems.domain.repository.PlaceRepository;
import br.com.clickbus.placems.domain.service.PlaceService;

@Configuration
@EnableR2dbcAuditing
public class PlaceConfig {
    @Bean
    PlaceService placeService(PlaceRepository placeRespository) {
        return new PlaceService(placeRespository);
    }

}
