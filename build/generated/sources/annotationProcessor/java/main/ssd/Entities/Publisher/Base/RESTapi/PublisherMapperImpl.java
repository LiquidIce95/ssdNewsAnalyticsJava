package ssd.Entities.Publisher.Base.RESTapi;

import javax.annotation.processing.Generated;
import ssd.Entities.Publisher.Base.Publisher;
import ssd.Entities.Publisher.Base.RESTapi.DTO.PublisherGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-11T14:35:15+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
public class PublisherMapperImpl implements PublisherMapper {

    @Override
    public PublisherGetDTO convertEntityToPublisherGetDTO(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherGetDTO publisherGetDTO = new PublisherGetDTO();

        publisherGetDTO.setAnalytics( publisher.getAnalytics() );
        publisherGetDTO.setName( publisher.getName() );

        return publisherGetDTO;
    }
}
