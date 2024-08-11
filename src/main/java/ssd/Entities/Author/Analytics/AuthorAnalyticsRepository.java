package ssd.Entities.Author.Analytics;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Analytics.AnalyticsRepository;

@Repository("authorAnalyticsRepository")
public interface AuthorAnalyticsRepository extends AnalyticsRepository<AuthorAnalytics> {
}
