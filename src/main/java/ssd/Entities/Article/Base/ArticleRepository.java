package ssd.Entities.Article.Base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("articleRepository")
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByName(String title);

    Article findById(long articleId);
}
