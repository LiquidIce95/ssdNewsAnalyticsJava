package ssd.Entities.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public ResponseEntity<List<Article>> getAllArticles() {
        List<Article> articles = articleRepository.findAll();
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @GetMapping("/{articleId}")
    public ResponseEntity<ArticleGetDTO> getArticleById(@PathVariable Long articleId) {
        return articleRepository.findById(articleId)
                .map(article -> new ResponseEntity<>(ArticleMapper.INSTANCE.convertEntityToArticleGetDTO(article), HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<Article>> getArticlesByTitle(@PathVariable String title) {
        List<Article> articles = articleRepository.findByTitle(title);
        if (articles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(articles, HttpStatus.OK);
        }
    }

    @GetMapping("/popular/{amount}")
    public ResponseEntity<List<Article>> getPopularArticles(@PathVariable int amount) {
        List<Article> articles = articleRepository.findAll();
        if (articles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            int size = articles.size();
            List<Article> popularArticles = articles.subList(Math.max(size - amount, 0), size);
            return new ResponseEntity<>(popularArticles, HttpStatus.OK);
        }
    }
}
