package ssd.Entities.Article.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.Entities.Article.Article;
import ssd.Entities.Article.RESTapi.DTO.ArticleGetDTO;
import ssd.Entities.Author.RESTapi.DTO.AuthorGetDTO;
import ssd.Entities.Newspaper.RESTapi.DTO.NewspaperGetDTO;
import ssd.Entities.Owner.RESTapi.DTO.OwnerGetDTO;
import ssd.Entities.Publisher.RESTapi.DTO.PublisherGetDTO;
import ssd.Entities.Topic.RESTapi.DTO.TopicGetDTO;

@Mapper
public interface ArticleMapper {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    @Mapping(source = "name", target = "name")
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
