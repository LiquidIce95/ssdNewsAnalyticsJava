package ssd.Entities.Owner.Raw;

import javax.persistence.Entity;
import javax.persistence.Table;

import ssd.AbstractClasses.Raw.EntityRaw;
import ssd.Entities.Owner.Base.Owner;

@Entity
@Table(name = "owner_raw")
public class OwnerRaw extends EntityRaw<Owner> {
    // Additional fields or methods specific to ArticleRaw can be added here if needed
}
