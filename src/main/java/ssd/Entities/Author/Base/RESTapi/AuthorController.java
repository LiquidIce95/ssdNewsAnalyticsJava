package ssd.Entities.Author.Base.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityController;
import ssd.Entities.Author.Base.Author;
import ssd.Entities.Author.Base.AuthorRepository;
import ssd.Entities.Author.Base.RESTapi.DTO.AuthorGetDTO;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController extends BaseEntityController<Author, AuthorRepository,AuthorGetDTO,AuthorMapper>{

   public AuthorController(AuthorRepository repository, AuthorMapper mapper){
    super(repository, mapper);
   } 
}
