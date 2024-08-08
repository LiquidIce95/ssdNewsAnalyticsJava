package ssd.Entities.Publisher;

public class PublisherGetDTO {
    private Long publisherId;
    private String name;
    private PublisherAnalytics analytics;

    // Getters and Setters

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return name;
    }

    public void setPublisherName(String publisherName) {
        this.name = publisherName;
    }

    public PublisherAnalytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(PublisherAnalytics analytics) {
        this.analytics = analytics;
    }
}
