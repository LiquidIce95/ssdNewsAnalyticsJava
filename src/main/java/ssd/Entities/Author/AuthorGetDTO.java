package ssd.Entities.Author;

public class AuthorGetDTO {
    private Long authorId;
    private String name;
    private int age;
    private AuthorAnalytics authorAnalytics;

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
        return authorAnalytics;
    }

    public void setAnalytics(AuthorAnalytics analytics) {
        this.authorAnalytics = analytics;
    }
}
