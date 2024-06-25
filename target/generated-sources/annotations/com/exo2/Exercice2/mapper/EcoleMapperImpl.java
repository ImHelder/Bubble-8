package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.AdresseDto;
import com.exo2.Exercice2.dto.EcoleDto;
import com.exo2.Exercice2.entity.Adresse;
import com.exo2.Exercice2.entity.Ecole;
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
public class EcoleMapperImpl implements EcoleMapper {

    @Autowired
    private EtudiantMapper etudiantMapper;

    @Override
    public Ecole toEntity(EcoleDto ecoleDto) {
        if ( ecoleDto == null ) {
            return null;
        }

        Ecole ecole = new Ecole();

        ecole.setId( ecoleDto.getId() );
        ecole.setNom( ecoleDto.getNom() );
        ecole.setDomaine( ecoleDto.getDomaine() );
        ecole.setEtudiants( etudiantMapper.toEntities( ecoleDto.getEtudiants() ) );
        ecole.setAdresse( adresseDtoToAdresse( ecoleDto.getAdresse() ) );

        return ecole;
    }

    @Override
    public EcoleDto toDto(Ecole ecole) {
        if ( ecole == null ) {
            return null;
        }

        EcoleDto ecoleDto = new EcoleDto();

        ecoleDto.setId( ecole.getId() );
        ecoleDto.setNom( ecole.getNom() );
        ecoleDto.setDomaine( ecole.getDomaine() );
        ecoleDto.setEtudiants( etudiantMapper.toDtos( ecole.getEtudiants() ) );
        ecoleDto.setAdresse( adresseToAdresseDto( ecole.getAdresse() ) );

        return ecoleDto;
    }

    @Override
    public List<Ecole> toEntities(List<EcoleDto> ecoleDtos) {
        if ( ecoleDtos == null ) {
            return null;
        }

        List<Ecole> list = new ArrayList<Ecole>( ecoleDtos.size() );
        for ( EcoleDto ecoleDto : ecoleDtos ) {
            list.add( toEntity( ecoleDto ) );
        }

        return list;
    }

    @Override
    public List<EcoleDto> toDtos(List<Ecole> ecoles) {
        if ( ecoles == null ) {
            return null;
        }

        List<EcoleDto> list = new ArrayList<EcoleDto>( ecoles.size() );
        for ( Ecole ecole : ecoles ) {
            list.add( toDto( ecole ) );
        }

        return list;
    }

    protected Adresse adresseDtoToAdresse(AdresseDto adresseDto) {
        if ( adresseDto == null ) {
            return null;
        }

        Adresse adresse = new Adresse();

        adresse.setId( adresseDto.getId() );
        adresse.setVille( adresseDto.getVille() );
        adresse.setComplementAdresse( adresseDto.getComplementAdresse() );
        adresse.setCodePostal( adresseDto.getCodePostal() );

        return adresse;
    }

    protected AdresseDto adresseToAdresseDto(Adresse adresse) {
        if ( adresse == null ) {
            return null;
        }

        AdresseDto adresseDto = new AdresseDto();

        adresseDto.setId( adresse.getId() );
        adresseDto.setVille( adresse.getVille() );
        adresseDto.setComplementAdresse( adresse.getComplementAdresse() );
        adresseDto.setCodePostal( adresse.getCodePostal() );

        return adresseDto;
    }
}
