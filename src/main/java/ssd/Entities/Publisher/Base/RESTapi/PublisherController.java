package ssd.Entities.Publisher.Base.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.AbstractClasses.Base.BaseEntity;
import ssd.AbstractClasses.Base.RESTapi.BaseEntityController;
import ssd.Entities.Publisher.Base.Publisher;
import ssd.Entities.Publisher.Base.PublisherRepository;
import ssd.Entities.Publisher.Base.RESTapi.DTO.PublisherGetDTO;

import java.util.List;

@RestController
@RequestMapping("/publishers")
public class PublisherController extends BaseEntityController<Publisher,PublisherRepository,PublisherGetDTO,PublisherMapper>{
  public PublisherController(PublisherRepository repository,PublisherMapper mapper){
    super(repository, mapper);
  }
}
