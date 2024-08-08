package ssd.Entities.Owner;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OwnerMapper {

    OwnerMapper INSTANCE = Mappers.getMapper(OwnerMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    OwnerGetDTO convertEntityToOwnerGetDTO(Owner owner);

    // Add more mappings as needed
}
