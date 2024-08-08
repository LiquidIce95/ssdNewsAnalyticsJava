package ssd.Entities.Publisher;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id")
    private Long publisherId;

    @Column(name = "publisher_name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "publisher_analytics_id",nullable = false)
    private PublisherAnalytics analytics;

    // Getters and Setters

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return name;
    }

    public void setPublisherName(String publisherName) {
        this.name = publisherName;
    }

    public PublisherAnalytics getPublisherAnalytics() {
        return analytics;
    }

    public void setPublisherAnalytics(PublisherAnalytics analytics) {
        this.analytics = analytics;
    }
}
