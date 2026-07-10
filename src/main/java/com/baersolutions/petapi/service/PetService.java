package com.baersolutions.petapi.service;

import com.baersolutions.petapi.dto.request.CreatePetRequest;
import com.baersolutions.petapi.dto.response.CreatePetResponse;
import com.baersolutions.petapi.dto.response.PetResponse;

/**
 * Define las operaciones disponibles para consultar y registrar mascotas.
 */
public interface PetService {

  /**
   * Obtiene una mascota por su identificador.
   *
   * @param petId identificador de la mascota
   * @return información de la mascota
   */
  PetResponse getPetById(Long petId);

  /**
   * Registra una mascota.
   *
   * @param request información recibida para registrar la mascota.
   * @return resultado de la operación de registro
   */
  CreatePetResponse createPet(CreatePetRequest request);
}
