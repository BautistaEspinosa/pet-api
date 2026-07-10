package com.baersolutions.petapi.dto.response;

/**
 * Representa la información de una mascota devuelta por la API.
 *
 * @param id identificador de la mascota
 * @param name nombre de la mascota
 * @param status estado de la mascota
 */

public record PetResponse(
    Long id,
    String name,
    String status
) {}
