package com.tecsup.petclinic.services;

import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.VisitNotFoundException;

import java.sql.Date;
import java.util.List;

public interface VisitService {
    Visit create(Visit visit);
    Visit update(int id, Visit visitDetails) throws VisitNotFoundException;
    void delete(Integer id) throws VisitNotFoundException;
    Visit findById(Integer id) throws VisitNotFoundException;
    List<Visit> findByVisitDate(Date date);
    List<Visit> findByPet(Pet pet);
    List<Visit> findByPetId(Integer petId);
    List<Visit> findAll();
}