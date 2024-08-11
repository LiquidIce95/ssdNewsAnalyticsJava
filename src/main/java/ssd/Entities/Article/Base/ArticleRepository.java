package ssd.Entities.Article.Base;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.BaseEntityRepository;

@Repository
public interface ArticleRepository extends BaseEntityRepository<Article> {
    // Additional custom query methods specific to Article can be added here
}
