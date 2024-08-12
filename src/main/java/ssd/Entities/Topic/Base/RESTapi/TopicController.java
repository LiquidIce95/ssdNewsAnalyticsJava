package ssd.Entities.Topic.Base.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityController;
import ssd.Entities.Topic.Base.Topic;
import ssd.Entities.Topic.Base.TopicRepository;
import ssd.Entities.Topic.Base.RESTapi.DTO.TopicGetDTO;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController extends BaseEntityController<Topic,TopicRepository,TopicGetDTO,TopicMapper>{
  public TopicController(TopicRepository repository,TopicMapper mapper){
    super(repository, mapper);
  }
}
