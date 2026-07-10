package com.baersolutions.petapi.dto.request;

/**
 * Representa la información recibida para registrar una mascota.
 *
 * @param id identificador de la mascota
 * @param status estado actual de la mascota
 * @param name nombre de la mascota
 */

public record CreatePetRequest(
    Long id,
    String status,
    String name
) {}
