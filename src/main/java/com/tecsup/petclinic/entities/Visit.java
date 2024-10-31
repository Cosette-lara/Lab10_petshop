package com.tecsup.petclinic.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

/**
 *
 * @author jgomezm
 *
 */
@Entity
@Table(name = "visits")
@Data
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false) // No necesitas insertable = false y updatable = false aquí
    private Pet pet;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "visit_date")
    private Date visitDate;

    @Column(name = "description", length = 255)
    private String description;

    public Visit() {
    }

    public Visit(Integer id, Pet pet, Date visitDate, String description) {
        this.id = id;
        this.pet = pet;
        this.visitDate = visitDate;
        this.description = description;
    }

    public Visit(Pet pet, Date visitDate, String description) {
        this.pet = pet;
        this.visitDate = visitDate;
        this.description = description;
    }
}