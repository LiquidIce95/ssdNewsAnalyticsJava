package ssd.Entities.Publisher.Raw;

import javax.persistence.Entity;
import javax.persistence.Table;

import ssd.AbstractClasses.Raw.EntityRaw;
import ssd.Entities.Publisher.Base.Publisher;

@Entity
@Table(name = "publisher_raw")
public class PublisherRaw extends EntityRaw<Publisher> {
    // Additional fields or methods specific to ArticleRaw can be added here if needed
}
