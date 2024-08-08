package ssd.Entities.Author;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "analytics", target = "analytics")
    AuthorGetDTO convertEntityToAuthorGetDTO(Author author);

    // Add more mappings as needed
}
