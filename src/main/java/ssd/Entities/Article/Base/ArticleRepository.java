package ssd.Entities.Article.Base;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Base.BaseEntityRepository;

@Repository("articleRepository")
public interface ArticleRepository extends BaseEntityRepository<Article> {
    // Additional custom query methods specific to Article can be added here
}
