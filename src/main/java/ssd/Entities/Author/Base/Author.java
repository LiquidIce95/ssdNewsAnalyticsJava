package ssd.Entities.Author.Base;

import javax.persistence.*;

import ssd.AbstractClasses.BaseEntity;
import ssd.Entities.Author.Analytics.AuthorAnalytics;

@Entity
@Table(name = "author")
public class Author extends BaseEntity<AuthorAnalytics>{

    
}
