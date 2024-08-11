package ssd.Entities.Author.RESTapi;

import javax.annotation.processing.Generated;
import ssd.Entities.Author.Author;
import ssd.Entities.Author.RESTapi.DTO.AuthorGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-11T13:24:20+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorGetDTO convertEntityToAuthorGetDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorGetDTO authorGetDTO = new AuthorGetDTO();

        authorGetDTO.setAnalytics( author.getAnalytics() );
        authorGetDTO.setName( author.getName() );

        return authorGetDTO;
    }
}
