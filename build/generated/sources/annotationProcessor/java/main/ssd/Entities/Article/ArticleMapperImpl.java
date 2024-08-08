package ssd.Entities.Article;

import javax.annotation.processing.Generated;
import ssd.Entities.Author.Author;
import ssd.Entities.Author.AuthorGetDTO;
import ssd.Entities.Newspaper.Newspaper;
import ssd.Entities.Newspaper.NewspaperGetDTO;
import ssd.Entities.Owner.Owner;
import ssd.Entities.Owner.OwnerGetDTO;
import ssd.Entities.Publisher.Publisher;
import ssd.Entities.Publisher.PublisherGetDTO;
import ssd.Entities.Topic.Topic;
import ssd.Entities.Topic.TopicGetDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-08-08T20:32:29+0200",
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
        articleGetDTO.setPublisher( publisherToPublisherGetDTO( article.getPublisher() ) );
        articleGetDTO.setTopic( topicToTopicGetDTO( article.getTopic() ) );
        articleGetDTO.setTitle( article.getTitle() );
        articleGetDTO.setContent( article.getContent() );
        articleGetDTO.setArticleId( article.getArticleId() );

        return articleGetDTO;
    }

    protected OwnerGetDTO ownerToOwnerGetDTO(Owner owner) {
        if ( owner == null ) {
            return null;
        }

        OwnerGetDTO ownerGetDTO = new OwnerGetDTO();

        ownerGetDTO.setOwnerId( owner.getOwnerId() );
        ownerGetDTO.setName( owner.getName() );
        ownerGetDTO.setAnalytics( owner.getAnalytics() );

        return ownerGetDTO;
    }

    protected NewspaperGetDTO newspaperToNewspaperGetDTO(Newspaper newspaper) {
        if ( newspaper == null ) {
            return null;
        }

        NewspaperGetDTO newspaperGetDTO = new NewspaperGetDTO();

        newspaperGetDTO.setNewspaperId( newspaper.getNewspaperId() );
        newspaperGetDTO.setName( newspaper.getName() );
        newspaperGetDTO.setAnalytics( newspaper.getAnalytics() );

        return newspaperGetDTO;
    }

    protected AuthorGetDTO authorToAuthorGetDTO(Author author) {
        if ( author == null ) {
            return null;
        }

        AuthorGetDTO authorGetDTO = new AuthorGetDTO();

        authorGetDTO.setAuthorId( author.getAuthorId() );
        authorGetDTO.setName( author.getName() );
        authorGetDTO.setAge( author.getAge() );
        authorGetDTO.setAnalytics( author.getAnalytics() );

        return authorGetDTO;
    }

    protected PublisherGetDTO publisherToPublisherGetDTO(Publisher publisher) {
        if ( publisher == null ) {
            return null;
        }

        PublisherGetDTO publisherGetDTO = new PublisherGetDTO();

        publisherGetDTO.setPublisherId( publisher.getPublisherId() );
        publisherGetDTO.setName( publisher.getName() );
        publisherGetDTO.setAnalytics( publisher.getAnalytics() );

        return publisherGetDTO;
    }

    protected TopicGetDTO topicToTopicGetDTO(Topic topic) {
        if ( topic == null ) {
            return null;
        }

        TopicGetDTO topicGetDTO = new TopicGetDTO();

        topicGetDTO.setTopicId( topic.getTopicId() );
        topicGetDTO.setName( topic.getName() );
        topicGetDTO.setAnalytics( topic.getAnalytics() );

        return topicGetDTO;
    }
}
