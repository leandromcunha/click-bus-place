package br.com.cunha.clickbus.services.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import br.com.cunha.clickbus.services.dto.PlaceDTO;
import br.com.cunha.clickbus.services.entities.Place;

/**
 * Interface Mapper : Responsable for converting Entity Place to PlaceDTO and
 * inverse
 *
 * @author Leandro
 */
@Mapper( componentModel = "spring", uses = {} )
public interface PlaceMapper extends EntityMapper<PlaceDTO,Place> {
    
    @Override
    @InheritInverseConfiguration
    @Mappings( {@Mapping( target = "id", source = "id" )} )
    Place toEntity( final PlaceDTO place );
}
