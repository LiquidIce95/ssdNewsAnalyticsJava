package ssd.Entities.Article.Base.RESTapi;

import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import ssd.Entities.Article.Base.Article;
import ssd.Entities.Article.Base.RESTapi.DTO.ArticleGetDTO;

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
