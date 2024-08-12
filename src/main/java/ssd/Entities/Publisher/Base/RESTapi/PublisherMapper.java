package ssd.Entities.Publisher.Base.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityMapper;
import ssd.Entities.Publisher.Base.Publisher;
import ssd.Entities.Publisher.Base.RESTapi.DTO.PublisherGetDTO;

@Mapper(componentModel = "spring")
public interface PublisherMapper extends BaseEntityMapper<Publisher,PublisherGetDTO>{

    PublisherMapper INSTANCE = Mappers.getMapper(PublisherMapper.class);

    @Override
    @Mapping(source = "name", target = "name")
    @Mapping(source = "analytics", target = "analytics")
    PublisherGetDTO convertEntityToGetDTO(Publisher publisher);

    // Add more mappings as needed
}
