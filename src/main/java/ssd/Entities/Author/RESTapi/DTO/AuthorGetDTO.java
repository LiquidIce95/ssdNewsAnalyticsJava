package ssd.Entities.Author.RESTapi.DTO;

import ssd.Entities.Author.Analytics.AuthorAnalytics;

public class AuthorGetDTO {
    private Long authorId;
    private String name;
    private int age;
    private AuthorAnalytics analytics;

    // Getters and Setters

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AuthorAnalytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(AuthorAnalytics analytics) {
        this.analytics = analytics;
    }
}
