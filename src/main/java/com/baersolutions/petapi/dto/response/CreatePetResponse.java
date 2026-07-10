package com.baersolutions.petapi.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Representa la respuesta generada al registrar una mascota.
 *
 * @param transactionId identificador único de la transacción
 * @param dateCreated fecha y hora de creación de la transacción
 * @param status estado de la mascota
 * @param name nombre de la mascota
 */

public record CreatePetResponse(
    UUID transactionId,
    LocalDateTime dateCreated,
    String status,
    String name
) {}
