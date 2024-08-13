package ssd.Entities.Newspaper.Base.RESTapi;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ssd.Entities.Newspaper.Base.Newspaper;
import ssd.Entities.Newspaper.Base.RESTapi.DTO.NewspaperGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-13T10:52:08+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
@Component
public class NewspaperMapperImpl implements NewspaperMapper {

    @Override
    public NewspaperGetDTO convertEntityToGetDTO(Newspaper newspaper) {
        if ( newspaper == null ) {
            return null;
        }

        NewspaperGetDTO newspaperGetDTO = new NewspaperGetDTO();

        newspaperGetDTO.setAnalytics( newspaper.getAnalytics() );
        newspaperGetDTO.setName( newspaper.getName() );
        newspaperGetDTO.setId( newspaper.getId() );

        return newspaperGetDTO;
    }
}
