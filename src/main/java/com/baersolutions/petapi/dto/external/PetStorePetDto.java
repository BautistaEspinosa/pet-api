package com.baersolutions.petapi.dto.external;

/**
 * Representa la información de una mascota intercambiada con Swagger Petstore.
 *
 * @param id identificador de la mascota
 * @param name nombre de la mascota
 * @param status estado de la mascota
 */

public record PetStorePetDto(

    Long id,
    String name,
    String status
) {}
