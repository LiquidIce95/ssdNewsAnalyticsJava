package ssd.Entities.Article.Base.RESTapi;

import javax.annotation.processing.Generated;
import ssd.Entities.Article.Base.Article;
import ssd.Entities.Article.Base.RESTapi.DTO.ArticleGetDTO;
import ssd.Entities.Author.Base.Author;
import ssd.Entities.Author.Base.RESTapi.DTO.AuthorGetDTO;
import ssd.Entities.Newspaper.Base.Newspaper;
import ssd.Entities.Newspaper.Base.RESTapi.DTO.NewspaperGetDTO;
import ssd.Entities.Owner.Base.Owner;
import ssd.Entities.Owner.Base.RESTapi.DTO.OwnerGetDTO;
import ssd.Entities.Publisher.Base.Publisher;
import ssd.Entities.Publisher.Base.RESTapi.DTO.PublisherGetDTO;
import ssd.Entities.Topic.Base.RESTapi.DTO.TopicGetDTO;
import ssd.Entities.Topic.Base.Topic;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-11T13:40:10+0200",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 17.0.10 (Debian)"
)
public class ArticleMapperImpl implements ArticleMapper {

    @Override
    public ArticleGetDTO convertEntityToArticleGetDTO(Article article) {
        if ( article == null ) {
            return null;
        }

        ArticleGetDTO articleGetDTO = new ArticleGetDTO();

        articleGetDTO.setOwner( ownerToOwnerGetDTO( article.getOwner() ) );
        articleGetDTO.setNewspaper( newspaperToNewspaperGetDTO( article.getNewspaper() ) );
        articleGetDTO.setAnalytics( article.getAnalytics() );
        articleGetDTO.setAuthor( authorToAuthorGetDTO( article.getAuthor() ) );
        articleGetDTO.setName( article.getName() );
        articleGetDTO.setPublisher( publisherToPublisherGetDTO( article.getPublisher() ) );
        articleGetDTO.setTopic( topicToTopicGetDTO( article.getTopic() ) );
        articleGetDTO.setContent( article.getContent() );

        return articleGetDTO;
    }

    protected OwnerGetDTO ownerToOwnerGetDTO(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerGetDTO ownerGetDTO = new OwnerGetDTO();

        ownerGetDTO.setName( owner.getName() );
        ownerGetDTO.setAnalytics( owner.getAnalytics() );

        return ownerGetDTO;
    }

    protected NewspaperGetDTO newspaperToNewspaperGetDTO(Newspaper newspaper) {
        if ( newspaper == null ) {
            return null;
        }

        NewspaperGetDTO newspaperGetDTO = new NewspaperGetDTO();

        newspaperGetDTO.setName( newspaper.getName() );
        newspaperGetDTO.setAnalytics( newspaper.getAnalytics() );

        return newspaperGetDTO;
    }

    protected AuthorGetDTO authorToAuthorGetDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorGetDTO authorGetDTO = new AuthorGetDTO();

        authorGetDTO.setName( author.getName() );
        authorGetDTO.setAnalytics( author.getAnalytics() );

        return authorGetDTO;
    }

    protected PublisherGetDTO publisherToPublisherGetDTO(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherGetDTO publisherGetDTO = new PublisherGetDTO();

        publisherGetDTO.setName( publisher.getName() );
        publisherGetDTO.setAnalytics( publisher.getAnalytics() );

        return publisherGetDTO;
    }

    protected TopicGetDTO topicToTopicGetDTO(Topic topic) {
        if ( topic == null ) {
            return null;
        }

        TopicGetDTO topicGetDTO = new TopicGetDTO();

        topicGetDTO.setName( topic.getName() );
        topicGetDTO.setAnalytics( topic.getAnalytics() );

        return topicGetDTO;
    }
}
