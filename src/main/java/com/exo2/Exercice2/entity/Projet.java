package com.exo2.Exercice2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.BatchSize;

import java.util.List;

@Entity
@Table(name = "projet", indexes = @Index(name = "idx_nom_projet", columnList = "nom_projet"))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projet_id")
    private Long id;

    @Column(name = "nom_projet")
    private String nomProjet;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @Column(name = "etudiants")
    @JoinTable(name = "etudiant_projet", joinColumns = @JoinColumn(name = "projet_id"), inverseJoinColumns = @JoinColumn(name = "etudiant_id"), indexes = {
            @Index(name = "idx_etudiant_projet_projet", columnList = "projet_id"),
            @Index(name = "idx_etudiant_projet_etudiant", columnList = "etudiant_id")
    })
    @BatchSize(size = 10)
    private List<Etudiant> etudiants;
}
