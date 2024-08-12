package ssd.Entities.Topic.Base.RESTapi;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ssd.Entities.Topic.Base.RESTapi.DTO.TopicGetDTO;
import ssd.Entities.Topic.Base.Topic;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-12T17:24:38+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
@Component
public class TopicMapperImpl implements TopicMapper {

    @Override
    public TopicGetDTO convertEntityToGetDTO(Topic topic) {
        if ( topic == null ) {
            return null;
        }

        TopicGetDTO topicGetDTO = new TopicGetDTO();

        topicGetDTO.setAnalytics( topic.getAnalytics() );
        topicGetDTO.setName( topic.getName() );
        topicGetDTO.setId( topic.getId() );

        return topicGetDTO;
    }
}
