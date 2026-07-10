package com.baersolutions.petapi.client;

import com.baersolutions.petapi.dto.external.PetStorePetDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * Cliente encargado de la comunicación con la API de Swagger Petstore.
 */
@Component
public class PetStoreClient {

  private final RestClient restClient;

  public PetStoreClient(RestClient restClient){
    this.restClient = restClient;
  }

  /**
   * Obtiene una mascota por su identificador.
   *
   * @param petId identificador de la mascota
   * @return información de la mascota
   */
  public PetStorePetDto getPetById(Long petId){

    return restClient.get()
        .uri("/pet/{petId}",petId)
        .retrieve()
        .body(PetStorePetDto.class);
  }

  /**
   * Registra una mascota en Swagger Petstore.
   *
   * @param pet información de la mascota
   * @return mascota registrada
   */
  public PetStorePetDto createPet(PetStorePetDto pet) {

    return restClient.post()
        .uri("/pet")
        .body(pet)
        .retrieve()
        .body(PetStorePetDto.class);
  }

  }
