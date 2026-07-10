package com.baersolutions.petapi.service.impl;

import com.baersolutions.petapi.client.PetStoreClient;
import com.baersolutions.petapi.dto.external.PetStorePetDto;
import com.baersolutions.petapi.dto.request.CreatePetRequest;
import com.baersolutions.petapi.dto.response.CreatePetResponse;
import com.baersolutions.petapi.dto.response.PetResponse;
import com.baersolutions.petapi.service.PetService;
import java.time.LocalDateTime;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class PetServiceImpl implements PetService {

  private static final Logger LOGGER = LoggerFactory.getLogger(PetServiceImpl.class);

  private final PetStoreClient petStoreClient;

  public PetServiceImpl(PetStoreClient petStoreClient) {
    this.petStoreClient = petStoreClient;
  }

  @Override
  public PetResponse getPetById(Long petId) {

    PetStorePetDto pet = petStoreClient.getPetById(petId);

    LOGGER.info(
        "Pet obtained from Petstore: id={}, name={}, status={}",
        pet.id(),
        pet.name(),
        pet.status()
    );
    return new PetResponse(pet.id(), pet.name(), pet.status());
  }

  @Override
  public CreatePetResponse createPet(CreatePetRequest request) {

    PetStorePetDto petToCreate = new PetStorePetDto(request.id(), request.name(), request.status());

    PetStorePetDto createdPet = petStoreClient.createPet(petToCreate);

    LOGGER.info(
        "Pet created in Petstore: id={}, name={}, status={}",
        createdPet.id(),
        createdPet.name(),
        createdPet.status()
    );

    return new CreatePetResponse(
        UUID.randomUUID(), LocalDateTime.now(), createdPet.status(), createdPet.name());
  }
}
