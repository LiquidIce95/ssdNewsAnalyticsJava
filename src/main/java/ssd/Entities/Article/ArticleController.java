package ssd.Entities.Article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/")
    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    @GetMapping("/{articleId}")
    public Article getArticleById(@PathVariable Long articleId) {
        return articleRepository.findById(articleId).orElse(null);
    }

    @GetMapping("/title/{title}")
    public List<Article> getArticlesByTitle(@PathVariable String title) {
        return articleRepository.findByTitle(title);
    }
}
