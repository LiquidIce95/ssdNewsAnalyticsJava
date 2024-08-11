package ssd.Entities.Article.Raw;

import javax.persistence.Entity;
import javax.persistence.Table;

import ssd.AbstractClasses.Raw.EntityRaw;
import ssd.Entities.Article.Base.Article;

@Entity
@Table(name = "article_raw")
public class ArticleRaw extends EntityRaw<Article> {
    // Additional fields or methods specific to ArticleRaw can be added here if needed
}
