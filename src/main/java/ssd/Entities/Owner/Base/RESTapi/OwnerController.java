package ssd.Entities.Owner.Base.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityController;
import ssd.Entities.Owner.Base.Owner;
import ssd.Entities.Owner.Base.OwnerRepository;
import ssd.Entities.Owner.Base.RESTapi.DTO.OwnerGetDTO;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController extends BaseEntityController<Owner,OwnerRepository,OwnerGetDTO,OwnerMapper>{

  public OwnerController(OwnerRepository repository,OwnerMapper mapper){
    super(repository, mapper);
  }
}
