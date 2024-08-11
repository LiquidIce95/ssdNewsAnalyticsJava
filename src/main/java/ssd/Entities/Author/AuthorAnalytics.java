package ssd.Entities.Author;

import javax.persistence.*;
import ssd.Entities.Analytics;


@Entity
@Table(name = "author_analytics")
public class AuthorAnalytics extends Analytics {
  // possibility of adding entity specific analytics

}
