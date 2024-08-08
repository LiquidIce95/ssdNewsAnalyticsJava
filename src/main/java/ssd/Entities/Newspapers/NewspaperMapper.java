package ssd.Entities.Newspapers;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NewspaperMapper {

    NewspaperMapper INSTANCE = Mappers.getMapper(NewspaperMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    NewspaperGetDTO convertEntityToNewspaperGetDTO(Newspaper newspaper);

    // Add more mappings as needed
}
