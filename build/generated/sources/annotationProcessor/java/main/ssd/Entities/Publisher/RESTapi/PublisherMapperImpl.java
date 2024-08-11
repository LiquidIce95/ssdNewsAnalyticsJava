package ssd.Entities.Publisher.RESTapi;

import javax.annotation.processing.Generated;
import ssd.Entities.Publisher.Publisher;
import ssd.Entities.Publisher.RESTapi.DTO.PublisherGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-11T13:24:20+0200",
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
