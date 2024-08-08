package ssd.Entities.Newspaper;

public class NewspaperGetDTO {
    private Long newspaperId;
    private String name;
    private NewspaperAnalytics analytics;

    // Getters and Setters

    public Long getNewspaperId() {
        return newspaperId;
    }

    public void setNewspaperId(Long newspaperId) {
        this.newspaperId = newspaperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewspaperAnalytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(NewspaperAnalytics analytics) {
        this.analytics = analytics;
    }
}
