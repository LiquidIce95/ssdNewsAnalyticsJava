package ssd.Entities.Author.Base.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityMapper;
import ssd.Entities.Author.Base.Author;
import ssd.Entities.Author.Base.RESTapi.DTO.AuthorGetDTO;

@Mapper(componentModel = "spring")
public interface AuthorMapper extends BaseEntityMapper<Author,AuthorGetDTO>{

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    @Override
    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    AuthorGetDTO convertEntityToGetDTO(Author author);

    // Add more mappings as needed
}
