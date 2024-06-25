package com.exo2.Exercice2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(name = "etudiant", indexes = @Index(name = "idx_nom_etudiant", columnList = "nom"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "etudiant_id")
    private Long id;

    @Column(name="etudiant_nom")
    private String nom;
    @Column(nullable = false, length = 50)
    private String prenom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ecole_id")
    private Ecole ecole;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "projets", nullable = false, length = 50)
    @JoinTable(name = "etudiant_projet", joinColumns = @JoinColumn(name = "etudiant_id"), inverseJoinColumns = @JoinColumn(name = "projet_id"), indexes = {
            @Index(name = "idx_etudiant_projet_etudiant", columnList = "etudiant_id"),
            @Index(name = "idx_etudiant_projet_projet", columnList = "projet_id")
    })
    @BatchSize(size = 10)
    private List<Projet> projets;
}
