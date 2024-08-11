package ssd.Entities.Article.Analytics;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Analytics.AnalyticsRepository;

@Repository("articleAnaylticsRepository")
public interface ArticleAnalyticsRepository extends AnalyticsRepository<ArticleAnalytics> {
    // Additional custom methods specific to ArticleAnalytics can be added here
}
