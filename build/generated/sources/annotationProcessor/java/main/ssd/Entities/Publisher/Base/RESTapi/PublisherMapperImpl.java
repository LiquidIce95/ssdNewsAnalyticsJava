package ssd.Entities.Publisher.Base.RESTapi;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ssd.Entities.Publisher.Base.Publisher;
import ssd.Entities.Publisher.Base.RESTapi.DTO.PublisherGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T17:24:38+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
@Component
public class PublisherMapperImpl implements PublisherMapper {

    @Override
    public PublisherGetDTO convertEntityToGetDTO(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherGetDTO publisherGetDTO = new PublisherGetDTO();

        publisherGetDTO.setAnalytics( publisher.getAnalytics() );
        publisherGetDTO.setName( publisher.getName() );
        publisherGetDTO.setId( publisher.getId() );

        return publisherGetDTO;
    }
}
