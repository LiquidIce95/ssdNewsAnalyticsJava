package ssd.Entities.Article;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;
import ssd.Entities.Author.AuthorGetDTO;
import ssd.Entities.Newspapers.NewspaperGetDTO;
import ssd.Entities.Owner.OwnerGetDTO;
import ssd.Entities.Publisher.PublisherGetDTO;
import ssd.Entities.Topic.TopicGetDTO;

@Mapper
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "publisher", target = "publisher")
    @Mapping(source = "topic", target = "topic")
    @Mapping(source = "owner", target = "owner")
    @Mapping(source = "newspaper", target = "newspaper")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "analytics", target = "analytics")
    ArticleGetDTO convertEntityToArticleGetDTO(Article article);

    // Add more mappings as needed
}
