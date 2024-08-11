package ssd.Entities.Author.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.Entities.Author.Author;
import ssd.Entities.Author.RESTapi.DTO.AuthorGetDTO;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    AuthorGetDTO convertEntityToAuthorGetDTO(Author author);

    // Add more mappings as needed
}
