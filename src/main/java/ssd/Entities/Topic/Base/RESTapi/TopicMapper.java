package ssd.Entities.Topic.Base.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.Entities.Topic.Base.Topic;
import ssd.Entities.Topic.Base.RESTapi.DTO.TopicGetDTO;

@Mapper
public interface TopicMapper {

    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    TopicGetDTO convertEntityToTopicGetDTO(Topic topic);

    // Add more mappings as needed
}
