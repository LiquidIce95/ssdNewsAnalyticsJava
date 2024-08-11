package ssd.Entities.Author;

import javax.persistence.*;
import java.io.Serializable;

import ssd.Entities.BaseEntity;
import ssd.Entities.Article.*;
import ssd.Entities.Author.Analytics.AuthorAnalytics;
import ssd.Entities.Newspaper.*;
import ssd.Entities.Owner.*;
import ssd.Entities.Publisher.*;
import ssd.Entities.Topic.*;

@Entity
@Table(name = "author")
public class Author extends BaseEntity<AuthorAnalytics>{

    
}
