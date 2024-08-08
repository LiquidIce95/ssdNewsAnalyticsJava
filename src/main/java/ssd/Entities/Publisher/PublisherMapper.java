package ssd.Entities.Publisher;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PublisherMapper {

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    PublisherGetDTO convertEntityToPublisherGetDTO(Publisher publisher);

    // Add more mappings as needed
}
