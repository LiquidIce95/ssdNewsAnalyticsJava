package ssd.Entities.Newspaper.Base.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.Entities.Newspaper.Base.Newspaper;
import ssd.Entities.Newspaper.Base.RESTapi.DTO.NewspaperGetDTO;

@Mapper
public interface NewspaperMapper {

    NewspaperMapper INSTANCE = Mappers.getMapper(NewspaperMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    NewspaperGetDTO convertEntityToNewspaperGetDTO(Newspaper newspaper);

    // Add more mappings as needed
}
