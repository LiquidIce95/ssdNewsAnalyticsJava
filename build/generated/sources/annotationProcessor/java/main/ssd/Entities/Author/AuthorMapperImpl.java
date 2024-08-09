package ssd.Entities.Author;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-09T17:10:01+0200",
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
        authorGetDTO.setAge( author.getAge() );
        authorGetDTO.setAuthorId( author.getAuthorId() );

        return authorGetDTO;
    }
}
