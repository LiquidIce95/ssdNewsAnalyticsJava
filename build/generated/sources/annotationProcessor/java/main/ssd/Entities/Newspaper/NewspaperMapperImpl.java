package ssd.Entities.Newspaper;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-08T20:32:30+0200",
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
        newspaperGetDTO.setNewspaperId( newspaper.getNewspaperId() );

        return newspaperGetDTO;
    }
}
