package ssd.Entities.Author.Base.RESTapi;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ssd.Entities.Author.Base.Author;
import ssd.Entities.Author.Base.RESTapi.DTO.AuthorGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-13T10:52:08+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorGetDTO convertEntityToGetDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorGetDTO authorGetDTO = new AuthorGetDTO();

        authorGetDTO.setAnalytics( author.getAnalytics() );
        authorGetDTO.setName( author.getName() );
        authorGetDTO.setId( author.getId() );

        return authorGetDTO;
    }
}
