package ssd.Entities.Newspaper.RESTapi;

import javax.annotation.processing.Generated;
import ssd.Entities.Newspaper.Newspaper;
import ssd.Entities.Newspaper.RESTapi.DTO.NewspaperGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-11T13:24:20+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
public class NewspaperMapperImpl implements NewspaperMapper {

    @Override
    public NewspaperGetDTO convertEntityToNewspaperGetDTO(Newspaper newspaper) {
        if ( newspaper == null ) {
            return null;
        }

        NewspaperGetDTO newspaperGetDTO = new NewspaperGetDTO();

        newspaperGetDTO.setAnalytics( newspaper.getAnalytics() );
        newspaperGetDTO.setName( newspaper.getName() );

        return newspaperGetDTO;
    }
}
