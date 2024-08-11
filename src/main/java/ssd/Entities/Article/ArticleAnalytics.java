package ssd.Entities.Article;
import ssd.Entities.Analytics;

import javax.persistence.*;

@Entity
@Table(name = "article_analytics")
public class ArticleAnalytics extends Analytics {
  // possibility of adding entity specific analytics

}
