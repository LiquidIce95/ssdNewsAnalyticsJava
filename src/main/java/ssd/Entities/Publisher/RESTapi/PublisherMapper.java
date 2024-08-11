package ssd.Entities.Publisher.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.Entities.Publisher.Publisher;
import ssd.Entities.Publisher.RESTapi.DTO.PublisherGetDTO;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    PublisherGetDTO convertEntityToPublisherGetDTO(Publisher publisher);

    // Add more mappings as needed
}
