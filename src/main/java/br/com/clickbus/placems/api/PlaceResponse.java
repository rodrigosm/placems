package br.com.clickbus.placems.api;

import java.time.LocalDateTime;

public record PlaceResponse  (
    Long id,
    String name,
    String slug,
    String city,
    String state,
    LocalDateTime createdAt,
    LocalDateTime updatedAt) {
}