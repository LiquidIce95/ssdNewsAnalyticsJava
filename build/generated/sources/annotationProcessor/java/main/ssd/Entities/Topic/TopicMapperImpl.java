package ssd.Entities.Topic;

import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-09T09:30:11+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
public class TopicMapperImpl implements TopicMapper {

    @Override
    public TopicGetDTO convertEntityToTopicGetDTO(Topic topic) {
        if ( topic == null ) {
            return null;
        }

        TopicGetDTO topicGetDTO = new TopicGetDTO();

        topicGetDTO.setAnalytics( topic.getAnalytics() );
        topicGetDTO.setName( topic.getName() );
        topicGetDTO.setTopicId( topic.getTopicId() );

        return topicGetDTO;
    }
}
