package ssd.Entities.Owner.Base.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityMapper;
import ssd.Entities.Owner.Base.Owner;
import ssd.Entities.Owner.Base.RESTapi.DTO.OwnerGetDTO;

@Mapper(componentModel = "spring")
public interface OwnerMapper extends BaseEntityMapper<Owner,OwnerGetDTO>{

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    @Override
    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    OwnerGetDTO convertEntityToGetDTO(Owner owner);

    // Add more mappings as needed
}
