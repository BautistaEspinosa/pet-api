package com.baersolutions.petapi.exception;

import java.time.LocalDateTime;

/**
 * Representa la respuesta estándar cuando ocurre un error.
 *
 * @param timestamp fecha y hora en que ocurrió el error
 * @param status código HTTP
 * @param error descripción breve del error
 * @param message detalle del problema
 * @param path ruta donde ocurrió el error
 */

public record ErrorResponse (
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    String path
) {
  }
