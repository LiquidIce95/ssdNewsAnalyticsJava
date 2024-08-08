package ssd.Entities.Topic;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TopicMapper {

    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    TopicGetDTO convertEntityToTopicGetDTO(Topic topic);

    // Add more mappings as needed
}
