package ssd.Entities.Newspaper.Raw;

import javax.persistence.Entity;
import javax.persistence.Table;

import ssd.AbstractClasses.Raw.EntityRaw;
import ssd.Entities.Newspaper.Base.Newspaper;

@Entity
@Table(name = "newspaper_raw")
public class NewspaperRaw extends EntityRaw<Newspaper> {
    // Additional fields or methods specific to ArticleRaw can be added here if needed
}
