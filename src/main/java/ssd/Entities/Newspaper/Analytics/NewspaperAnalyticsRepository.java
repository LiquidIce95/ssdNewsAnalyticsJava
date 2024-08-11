package ssd.Entities.Newspaper.Analytics;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Analytics.AnalyticsRepository;

@Repository("newspaperAnalyticsRepository")
public interface NewspaperAnalyticsRepository extends AnalyticsRepository<NewspaperAnalytics> {
}
