package ssd.Entities.Topic.Analytics;

import org.springframework.stereotype.Repository;

import ssd.AbstractClasses.Analytics.AnalyticsRepository;

@Repository("topicAnalyticsRepository")
public interface TopicAnalyticsRepository extends AnalyticsRepository<TopicAnalytics>{
}
