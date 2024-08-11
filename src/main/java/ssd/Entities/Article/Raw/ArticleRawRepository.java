package ssd.Entities.Article.Raw;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("articleRawRepository")
public interface ArticleRawRepository extends JpaRepository<ArticleRaw, Long> {
}
