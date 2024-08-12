package ssd.Entities.Topic.Base.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityMapper;
import ssd.Entities.Topic.Base.Topic;
import ssd.Entities.Topic.Base.RESTapi.DTO.TopicGetDTO;

@Mapper(componentModel = "spring")
public interface TopicMapper extends BaseEntityMapper<Topic,TopicGetDTO>{

    TopicMapper INSTANCE = Mappers.getMapper(TopicMapper.class);

    @Override
    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    TopicGetDTO convertEntityToGetDTO(Topic topic);

    // Add more mappings as needed
}
