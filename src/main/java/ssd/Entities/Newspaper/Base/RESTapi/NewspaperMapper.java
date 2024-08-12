package ssd.Entities.Newspaper.Base.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityMapper;
import ssd.Entities.Newspaper.Base.Newspaper;
import ssd.Entities.Newspaper.Base.RESTapi.DTO.NewspaperGetDTO;

@Mapper(componentModel = "spring")
public interface NewspaperMapper extends BaseEntityMapper<Newspaper,NewspaperGetDTO> {

    NewspaperMapper INSTANCE = Mappers.getMapper(NewspaperMapper.class);

    @Override
    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    NewspaperGetDTO convertEntityToGetDTO(Newspaper newspaper);

    // Add more mappings as needed
}
