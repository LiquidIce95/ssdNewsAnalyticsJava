package ssd.Entities.Article.Base.RESTapi;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import ssd.AbstractClasses.Base.RESTapi.BaseEntityMapper;
import ssd.Entities.Article.Base.Article;
import ssd.Entities.Article.Base.RESTapi.DTO.ArticleGetDTO;

@Mapper(componentModel = "spring")
public interface ArticleMapper extends BaseEntityMapper<Article, ArticleGetDTO> {

    ArticleMapper INSTANCE = Mappers.getMapper(ArticleMapper.class);

    @Override
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "author", target = "author")
    @Mapping(source = "publisher", target = "publisher")
    @Mapping(source = "topic", target = "topic")
    @Mapping(source = "owner", target = "owner")
    @Mapping(source = "newspaper", target = "newspaper")
    @Mapping(source = "content", target = "content")
    @Mapping(source = "analytics", target = "analytics")
    ArticleGetDTO convertEntityToGetDTO(Article article);

}
