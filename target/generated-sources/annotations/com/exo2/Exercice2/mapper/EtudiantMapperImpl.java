package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.EtudiantDto;
import com.exo2.Exercice2.dto.ProjetDto;
import com.exo2.Exercice2.entity.Etudiant;
import com.exo2.Exercice2.entity.Projet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-25T11:28:22+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class EtudiantMapperImpl implements EtudiantMapper {

    @Autowired
    private ProjetMapper projetMapper;

    @Override
    public Etudiant toEntity(EtudiantDto etudiantDto) {
        if ( etudiantDto == null ) {
            return null;
        }

        Etudiant etudiant = new Etudiant();

        etudiant.setId( etudiantDto.getId() );
        etudiant.setNom( etudiantDto.getNom() );
        etudiant.setPrenom( etudiantDto.getPrenom() );
        etudiant.setProjets( projetMapper.toEntities( etudiantDto.getProjets() ) );

        return etudiant;
    }

    @Override
    public EtudiantDto toDto(Etudiant etudiant) {
        if ( etudiant == null ) {
            return null;
        }

        EtudiantDto etudiantDto = new EtudiantDto();

        etudiantDto.setId( etudiant.getId() );
        etudiantDto.setNom( etudiant.getNom() );
        etudiantDto.setPrenom( etudiant.getPrenom() );
        etudiantDto.setProjets( projetListToProjetDtoList( etudiant.getProjets() ) );

        return etudiantDto;
    }

    @Override
    public List<Etudiant> toEntities(List<EtudiantDto> etudiantsDto) {
        if ( etudiantsDto == null ) {
            return null;
        }

        List<Etudiant> list = new ArrayList<Etudiant>( etudiantsDto.size() );
        for ( EtudiantDto etudiantDto : etudiantsDto ) {
            list.add( toEntity( etudiantDto ) );
        }

        return list;
    }

    @Override
    public List<EtudiantDto> toDtos(List<Etudiant> etudiants) {
        if ( etudiants == null ) {
            return null;
        }

        List<EtudiantDto> list = new ArrayList<EtudiantDto>( etudiants.size() );
        for ( Etudiant etudiant : etudiants ) {
            list.add( toDto( etudiant ) );
        }

        return list;
    }

    protected List<ProjetDto> projetListToProjetDtoList(List<Projet> list) {
        if ( list == null ) {
            return null;
        }

        List<ProjetDto> list1 = new ArrayList<ProjetDto>( list.size() );
        for ( Projet projet : list ) {
            list1.add( projetMapper.toDto( projet ) );
        }

        return list1;
    }
}
