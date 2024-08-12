package ssd.Entities.Article.Base.RESTapi.DTO;

import ssd.AbstractClasses.Base.RESTapi.DTO.BaseEntityGetDTO;
import ssd.Entities.Article.Analytics.ArticleAnalytics;
import ssd.Entities.Author.Base.RESTapi.DTO.AuthorGetDTO;
import ssd.Entities.Newspaper.Base.RESTapi.DTO.NewspaperGetDTO;
import ssd.Entities.Owner.Base.RESTapi.DTO.OwnerGetDTO;
import ssd.Entities.Publisher.Base.RESTapi.DTO.PublisherGetDTO;
import ssd.Entities.Topic.Base.RESTapi.DTO.TopicGetDTO;

public class ArticleGetDTO extends BaseEntityGetDTO<ArticleAnalytics> {

    private AuthorGetDTO author;
    private PublisherGetDTO publisher;
    private TopicGetDTO topic;
    private OwnerGetDTO owner;
    private NewspaperGetDTO newspaper;
    private String content;

    // Getters and Setters

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
}
