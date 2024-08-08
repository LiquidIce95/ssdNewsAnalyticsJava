package ssd.Entities.Owner;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "owner")
public class Owner implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    private Long ownerId;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_analytics_id",nullable = false)
    private OwnerAnalytics analytics;

    // Getters and Setters

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OwnerAnalytics getOwnerAnalytics() {
        return analytics;
    }

    public void setOwnerAnalytics(OwnerAnalytics analytics) {
        this.analytics = analytics;
    }
}
