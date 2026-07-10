package com.baersolutions.petapi.exception;

/**
 * Representa un error ocurrido al comunicarse con un servicio externo.
 */
public class ExternalServiceException extends RuntimeException{

  public ExternalServiceException(String message){
    super(message);
  }

  public ExternalServiceException(String message, Throwable cause){
    super(message,cause);
  }
}
