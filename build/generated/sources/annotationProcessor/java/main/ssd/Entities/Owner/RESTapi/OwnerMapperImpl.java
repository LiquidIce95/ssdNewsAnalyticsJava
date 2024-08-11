package ssd.Entities.Owner.RESTapi;

import javax.annotation.processing.Generated;
import ssd.Entities.Owner.Owner;
import ssd.Entities.Owner.RESTapi.DTO.OwnerGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-11T13:24:20+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
public class OwnerMapperImpl implements OwnerMapper {

    @Override
    public OwnerGetDTO convertEntityToOwnerGetDTO(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerGetDTO ownerGetDTO = new OwnerGetDTO();

        ownerGetDTO.setAnalytics( owner.getAnalytics() );
        ownerGetDTO.setName( owner.getName() );

        return ownerGetDTO;
    }
}
