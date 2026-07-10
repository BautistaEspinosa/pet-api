package com.baersolutions.petapi.controller;

import com.baersolutions.petapi.dto.request.CreatePetRequest;
import com.baersolutions.petapi.dto.response.CreatePetResponse;
import com.baersolutions.petapi.dto.response.PetResponse;
import com.baersolutions.petapi.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Expone las operaciones REST relacionadas con mascotas.
 */
@RestController
@RequestMapping("/api/pet")
public class PetController {

  private final PetService petService;

  public PetController(PetService petService) {
    this.petService = petService;
  }

  /**
   * Obtiene una mascota por su identificador.
   *
   * @param petId identificador de la mascota
   * @return información de la mascota
   */
  @GetMapping("/{petId}")
  public ResponseEntity<PetResponse> getPetById(
      @PathVariable Long petId) {

    PetResponse response = petService.getPetById(petId);

    return ResponseEntity.ok(response);
  }

  /**
   * Registra una mascota.
   *
   * @param request información de la mascota
   * @return resultado de la operación
   */
  @PostMapping
  public ResponseEntity<CreatePetResponse> createPet(
      @RequestBody CreatePetRequest request) {

    CreatePetResponse response = petService.createPet(request);

    return ResponseEntity.ok(response);
  }
}