package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.ProjetDto;
import com.exo2.Exercice2.entity.Projet;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-25T11:28:22+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.11 (Amazon.com Inc.)"
)
@Component
public class ProjetMapperImpl implements ProjetMapper {

    @Override
    public ProjetDto toDto(Projet projet) {
        if ( projet == null ) {
            return null;
        }

        ProjetDto projetDto = new ProjetDto();

        projetDto.setId( projet.getId() );
        projetDto.setNomProjet( projet.getNomProjet() );

        return projetDto;
    }

    @Override
    public Projet toEntity(ProjetDto projetDto) {
        if ( projetDto == null ) {
            return null;
        }

        Projet projet = new Projet();

        projet.setId( projetDto.getId() );
        projet.setNomProjet( projetDto.getNomProjet() );

        return projet;
    }

    @Override
    public List<ProjetDto> toDtos(List<Projet> projets) {
        if ( projets == null ) {
            return null;
        }

        List<ProjetDto> list = new ArrayList<ProjetDto>( projets.size() );
        for ( Projet projet : projets ) {
            list.add( toDto( projet ) );
        }

        return list;
    }

    @Override
    public List<Projet> toEntities(List<ProjetDto> projetDtos) {
        if ( projetDtos == null ) {
            return null;
        }

        List<Projet> list = new ArrayList<Projet>( projetDtos.size() );
        for ( ProjetDto projetDto : projetDtos ) {
            list.add( toEntity( projetDto ) );
        }

        return list;
    }
}
