package ssd.Entities.Topic;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "topic")
public class Topic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "topic_id")
    private Long topicId;

    @Column(name = "topic_name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "topic_analytics_id",nullable = false)
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
