package ssd.Entities.Article.Raw;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Raw.EntityRawRepository;

@Repository("articleRawRepository")
public interface ArticleRawRepository extends EntityRawRepository<ArticleRaw> {

}
