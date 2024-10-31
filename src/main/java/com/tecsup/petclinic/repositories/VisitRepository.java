package com.tecsup.petclinic.repositories;

import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.entities.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface VisitRepository extends JpaRepository<Visit, Integer> {
    // Buscar visitas por fecha
    List<Visit> findByVisitDate(Date visitDate);

    // Buscar visitas por pet (mascota)
    List<Visit> findByPet(Pet pet);

    // Buscar visitas por pet ID
    List<Visit> findByPetId(Integer petId);
}