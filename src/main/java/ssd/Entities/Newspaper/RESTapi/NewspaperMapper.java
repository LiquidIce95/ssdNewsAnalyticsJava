package ssd.Entities.Newspaper.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.Entities.Newspaper.Newspaper;
import ssd.Entities.Newspaper.RESTapi.DTO.NewspaperGetDTO;

@Mapper
public interface NewspaperMapper {

    NewspaperMapper INSTANCE = Mappers.getMapper(NewspaperMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    NewspaperGetDTO convertEntityToNewspaperGetDTO(Newspaper newspaper);

    // Add more mappings as needed
}
