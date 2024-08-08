package ssd.Entities.Owner;

public class OwnerGetDTO {
    private Long ownerId;
    private String name;
    private OwnerAnalytics analytics;

    // Getters and Setters

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OwnerAnalytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(OwnerAnalytics analytics) {
        this.analytics = analytics;
    }
}
