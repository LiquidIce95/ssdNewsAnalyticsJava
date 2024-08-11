package ssd.Entities.Publisher;

import javax.annotation.processing.Generated;

import ssd.Entities.Publisher.RESTapi.PublisherMapper;
import ssd.Entities.Publisher.RESTapi.DTO.PublisherGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-11T11:46:09+0200",
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
        publisherGetDTO.setPublisherId( publisher.getPublisherId() );

        return publisherGetDTO;
    }
}
