package com.baersolutions.petapi.client;

import com.baersolutions.petapi.dto.external.PetStorePetDto;
import com.baersolutions.petapi.exception.ExternalServiceException;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestClientException;

/** Cliente encargado de la comunicación con la API de Swagger Petstore. */
@Component
public class PetStoreClient {

  private final RestClient restClient;

  public PetStoreClient(RestClient restClient) {
    this.restClient = restClient;
  }

  /**
   * Obtiene una mascota por su identificador.
   *
   * @param petId identificador de la mascota
   * @return información de la mascota
   */
  public PetStorePetDto getPetById(Long petId) {

    try {
      return restClient.get().uri("/pet/{petId}", petId).retrieve().body(PetStorePetDto.class);
    } catch (RestClientException ex) {
      throw new ExternalServiceException("Error retrieving pet from Swagger Petstore.", ex);
    }
  }

  /**
   * Registra una mascota en Swagger Petstore.
   *
   * @param pet información de la mascota
   * @return mascota registrada
   */
  public PetStorePetDto createPet(PetStorePetDto pet) {

    try{
    return restClient.post().uri("/pet").body(pet).retrieve().body(PetStorePetDto.class);
    }catch (RestClientException ex){
      throw new ExternalServiceException("Error creating pet in Swagger Petstore.",ex);
    }
  }
}
