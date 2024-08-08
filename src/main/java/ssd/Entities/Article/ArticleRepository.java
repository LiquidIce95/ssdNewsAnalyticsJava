package ssd.Entities.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("articleRepository")
public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findByTitle(String title);

    Article findById(long articleId);
}
