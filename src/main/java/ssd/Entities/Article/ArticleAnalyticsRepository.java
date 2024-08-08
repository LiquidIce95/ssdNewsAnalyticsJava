package ssd.Entities.Article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("articleAnalyticsRepository")
public interface ArticleAnalyticsRepository extends JpaRepository<ArticleAnalytics, Long> {
}
