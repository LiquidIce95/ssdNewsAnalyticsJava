package ssd.Entities.Author;

import javax.persistence.*;
import java.io.Serializable;
import ssd.Entities.Article.*;
import ssd.Entities.Author.Analytics.AuthorAnalytics;
import ssd.Entities.Newspaper.*;
import ssd.Entities.Owner.*;
import ssd.Entities.Publisher.*;
import ssd.Entities.Topic.*;

@Entity
@Table(name = "author")
public class Author implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private Long authorId;

    @Column(name = "author_name",nullable = false)
    private String name;

    @Column(name = "author_age",nullable = false)
    private int age;

    @ManyToOne
    @JoinColumn(name = "author_analytics_id",nullable = false)
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

    public void setAnalytics(AuthorAnalytics AuthorAnalytics) {
        this.analytics = AuthorAnalytics;
    }
}
