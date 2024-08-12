package ssd.Entities.Article.Base.RESTapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ssd.AbstractClasses.Base.RESTapi.BaseEntityController;
import ssd.Entities.Article.Base.Article;
import ssd.Entities.Article.Base.ArticleRepository;
import ssd.Entities.Article.Base.RESTapi.DTO.ArticleGetDTO;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController extends BaseEntityController<Article,ArticleRepository,ArticleGetDTO,ArticleMapper>{

  public ArticleController(ArticleRepository repository, ArticleMapper mapper) {
    super(repository, mapper);
  }
    
}
