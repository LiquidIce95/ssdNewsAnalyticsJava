package ssd.Entities.Publisher.Analytics;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Analytics.AnalyticsRepository;

@Repository("publisherAnalyticsRepository")
public interface PublisherAnalyticsRepository extends AnalyticsRepository<PublisherAnalytics>{
}
