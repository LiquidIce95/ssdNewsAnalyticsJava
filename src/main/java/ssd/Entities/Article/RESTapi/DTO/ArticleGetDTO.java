package ssd.Entities.Article.RESTapi.DTO;

import ssd.Entities.Article.Analytics.ArticleAnalytics;
import ssd.Entities.Author.RESTapi.DTO.AuthorGetDTO;
import ssd.Entities.Newspaper.RESTapi.DTO.NewspaperGetDTO;
import ssd.Entities.Owner.RESTapi.DTO.OwnerGetDTO;
import ssd.Entities.Publisher.RESTapi.DTO.PublisherGetDTO;
import ssd.Entities.Topic.RESTapi.DTO.TopicGetDTO;

public class ArticleGetDTO {
    private Long articleId;
    private String title;
    private AuthorGetDTO author;
    private PublisherGetDTO publisher;
    private TopicGetDTO topic;
    private OwnerGetDTO owner;
    private NewspaperGetDTO newspaper;
    private String content;
    private ArticleAnalytics analytics;

    // Getters and Setters

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorGetDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorGetDTO author) {
        this.author = author;
    }

    public PublisherGetDTO getPublisher() {
        return publisher;
    }

    public void setPublisher(PublisherGetDTO publisher) {
        this.publisher = publisher;
    }

    public TopicGetDTO getTopic() {
        return topic;
    }

    public void setTopic(TopicGetDTO topic) {
        this.topic = topic;
    }

    public OwnerGetDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerGetDTO owner) {
        this.owner = owner;
    }

    public NewspaperGetDTO getNewspaper() {
        return newspaper;
    }

    public void setNewspaper(NewspaperGetDTO newspaper) {
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
