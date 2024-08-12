package ssd.AbstractClasses.Base.RESTapi.DTO;

import ssd.AbstractClasses.Analytics.Analytics;

public class BaseEntityGetDTO<T extends Analytics> {

    private Long id;
    private String name;
    private T analytics;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getAnalytics() {
        return analytics;
    }

    public void setAnalytics(T analytics) {
        this.analytics = analytics;
    }
}
