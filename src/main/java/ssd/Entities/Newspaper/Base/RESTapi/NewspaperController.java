package ssd.Entities.Newspaper.Base.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityController;
import ssd.Entities.Newspaper.Base.Newspaper;
import ssd.Entities.Newspaper.Base.NewspaperRepository;
import ssd.Entities.Newspaper.Base.RESTapi.DTO.NewspaperGetDTO;

import java.util.List;

@RestController
@RequestMapping("/newspapers")
public class NewspaperController extends BaseEntityController<Newspaper,NewspaperRepository,NewspaperGetDTO,NewspaperMapper>{
  public NewspaperController(NewspaperRepository repository,NewspaperMapper mapper){
    super(repository, mapper);
  }
}
