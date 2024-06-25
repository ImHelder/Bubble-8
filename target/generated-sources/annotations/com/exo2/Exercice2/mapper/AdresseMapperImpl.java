package com.exo2.Exercice2.mapper;

import com.exo2.Exercice2.dto.AdresseDto;
import com.exo2.Exercice2.entity.Adresse;
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
public class AdresseMapperImpl implements AdresseMapper {

    @Override
    public AdresseDto toDto(Adresse adresse) {
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

    @Override
    public Adresse toEntity(AdresseDto adresseDto) {
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

    @Override
    public List<AdresseDto> toDtos(List<Adresse> adresses) {
        if ( adresses == null ) {
            return null;
        }

        List<AdresseDto> list = new ArrayList<AdresseDto>( adresses.size() );
        for ( Adresse adresse : adresses ) {
            list.add( toDto( adresse ) );
        }

        return list;
    }

    @Override
    public List<Adresse> toEntities(List<AdresseDto> adressesDto) {
        if ( adressesDto == null ) {
            return null;
        }

        List<Adresse> list = new ArrayList<Adresse>( adressesDto.size() );
        for ( AdresseDto adresseDto : adressesDto ) {
            list.add( toEntity( adresseDto ) );
        }

        return list;
    }
}
