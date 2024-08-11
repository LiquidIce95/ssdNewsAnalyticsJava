package ssd.Entities.Article.Base;

import javax.persistence.*;

import ssd.AbstractClasses.Base.BaseEntity;
import ssd.Entities.Article.Analytics.ArticleAnalytics;
import ssd.Entities.Author.Base.Author;
import ssd.Entities.Newspaper.Base.Newspaper;
import ssd.Entities.Owner.Base.Owner;
import ssd.Entities.Publisher.Base.Publisher;
import ssd.Entities.Topic.Base.Topic;
/*  */
@Entity
@Table(name = "article")
public class Article extends BaseEntity<ArticleAnalytics> {

    
    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;

    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = false)
    private Publisher publisher;

    @ManyToOne
    @JoinColumn(name = "topic_id", nullable = false)
    private Topic topic;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @ManyToOne
    @JoinColumn(name = "newspaper_id", nullable = false)
    private Newspaper newspaper;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "article_analytics_id", nullable = false)
    private ArticleAnalytics analytics;

    // Getters and Setters

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Newspaper getNewspaper() {
        return newspaper;
    }

    public void setNewspaper(Newspaper newspaper) {
        this.newspaper = newspaper;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArticleAnalytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(ArticleAnalytics articleAnalytics) {
        this.analytics = articleAnalytics;
    }
}
