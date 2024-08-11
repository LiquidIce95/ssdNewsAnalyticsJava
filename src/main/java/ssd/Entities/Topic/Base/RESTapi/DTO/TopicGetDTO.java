package ssd.Entities.Topic.Base.RESTapi.DTO;

import ssd.Entities.Topic.Analytics.TopicAnalytics;

public class TopicGetDTO {
    private Long topicId;
    private String name;
    private TopicAnalytics analytics;

    // Getters and Setters

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TopicAnalytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(TopicAnalytics analytics) {
        this.analytics = analytics;
    }
}
