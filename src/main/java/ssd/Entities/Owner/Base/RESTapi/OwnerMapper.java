package ssd.Entities.Owner.Base.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.Entities.Owner.Base.Owner;
import ssd.Entities.Owner.Base.RESTapi.DTO.OwnerGetDTO;

@Mapper
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    OwnerGetDTO convertEntityToOwnerGetDTO(Owner owner);

    // Add more mappings as needed
}
