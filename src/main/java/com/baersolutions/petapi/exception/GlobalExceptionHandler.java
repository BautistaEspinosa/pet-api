package com.baersolutions.petapi.exception;


import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Maneja de forma centralizada las excepciones de la API.
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

  /**
   * Maneja errores ocurridos al consumir Swagger Petstore.
   *
   * @param exception excepción lanzada por el cliente externo
   * @param request petición HTTP actual
   * @return respuesta de error estandarizada
   */
  @ExceptionHandler(ExternalServiceException.class)
  ResponseEntity<ErrorResponse> handleExternalServiceException(ExternalServiceException exception,
      HttpServletRequest request){
    LOGGER.error("External service error on path {}:{}",request.getRequestURI(),exception.getMessage(),exception);
    HttpStatus status = HttpStatus.BAD_GATEWAY;

    ErrorResponse response = new ErrorResponse(
        LocalDateTime.now(),status.value(),
        status.getReasonPhrase(),exception.getMessage(),
        request.getRequestURI()
    );
    return ResponseEntity.status(status).body(response);
    }
  }

