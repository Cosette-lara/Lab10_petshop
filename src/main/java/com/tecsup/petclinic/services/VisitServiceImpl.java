package com.tecsup.petclinic.services;

import java.sql.Date;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import com.tecsup.petclinic.entities.Visit;
import com.tecsup.petclinic.entities.Pet;
import com.tecsup.petclinic.exception.VisitNotFoundException;
import com.tecsup.petclinic.repositories.VisitRepository;

@Service
@Slf4j
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    /**
     * Creates a new visit.
     *
     * @param visit Visit object to be saved
     * @return Saved visit
     */
    @Override
    public Visit create(Visit visit) {
        return visitRepository.save(visit);
    }

    /**
     * Updates an existing visit by ID.
     *
     * @param id ID of the visit to update
     * @param visitDetails Updated visit details
     * @return Updated visit
     * @throws VisitNotFoundException if the visit is not found
     */
    @Override
    public Visit update(int id, Visit visitDetails) throws VisitNotFoundException {
        Visit visit = findById(id);

        visit.setDescription(visitDetails.getDescription());
        visit.setVisitDate(visitDetails.getVisitDate());

        return visitRepository.save(visit);
    }

    /**
     * Deletes a visit by ID.
     *
     * @param id ID of the visit to delete
     * @throws VisitNotFoundException if the visit is not found
     */
    @Override
    public void delete(Integer id) throws VisitNotFoundException {
        Visit visit = findById(id);
        visitRepository.delete(visit);
    }

    /**
     * Finds a visit by ID.
     *
     * @param id ID of the visit
     * @return Found visit
     * @throws VisitNotFoundException if the visit is not found
     */
    @Override
    public Visit findById(Integer id) throws VisitNotFoundException {
        return visitRepository.findById(id)
                .orElseThrow(() -> new VisitNotFoundException("Visit not found with id: " + id));
    }

    /**
     * Finds visits by visit date.
     *
     * @param date Date of the visits
     * @return List of visits with the specified date
     */
    @Override
    public List<Visit> findByVisitDate(Date date) {
        List<Visit> visits = visitRepository.findByVisitDate(date);
        visits.forEach(visit -> log.info(visit.toString()));
        return visits;
    }

    /**
     * Finds visits by pet.
     *
     * @param pet Pet object
     * @return List of visits for the specified pet
     */
    @Override
    public List<Visit> findByPet(Pet pet) {
        List<Visit> visits = visitRepository.findByPet(pet);
        visits.forEach(visit -> log.info(visit.toString()));
        return visits;
    }

    /**
     * Finds visits by pet ID.
     *
     * @param petId ID of the pet
     * @return List of visits for the specified pet ID
     */
    @Override
    public List<Visit> findByPetId(Integer petId) {
        List<Visit> visits = visitRepository.findByPetId(petId);
        visits.forEach(visit -> log.info(visit.toString()));
        return visits;
    }

    /**
     * Retrieves all visits.
     *
     * @return List of all visits
     */
    @Override
    public List<Visit> findAll() {
        return visitRepository.findAll();
    }
}
