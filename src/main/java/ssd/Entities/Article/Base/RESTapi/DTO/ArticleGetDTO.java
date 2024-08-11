package ssd.Entities.Article.Base.RESTapi.DTO;

import ssd.Entities.Article.Analytics.ArticleAnalytics;
import ssd.Entities.Author.Base.RESTapi.DTO.AuthorGetDTO;
import ssd.Entities.Newspaper.Base.RESTapi.DTO.NewspaperGetDTO;
import ssd.Entities.Owner.Base.RESTapi.DTO.OwnerGetDTO;
import ssd.Entities.Publisher.Base.RESTapi.DTO.PublisherGetDTO;
import ssd.Entities.Topic.Base.RESTapi.DTO.TopicGetDTO;

public class ArticleGetDTO {
    private Long articleId;
    private String name;
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

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
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
