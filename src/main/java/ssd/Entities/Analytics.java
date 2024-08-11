package ssd.Entities;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Analytics implements Serializable {

    @Column(name = "bias", nullable = false)
    private String bias;

    @Column(name = "views", nullable = false)
    private int views;

    @Column(name = "shares", nullable = false)
    private int shares;

    @Column(name = "likes", nullable = false)
    private int likes;

    @Column(name = "engagement_rate", nullable = false)
    private double engagementRate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "analytics_id")
    private Long id;

    // Getters and Setters

    public String getBias() {
        return bias;
    }

    public void setBias(String bias) {
        this.bias = bias;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getShares() {
        return shares;
    }

    public void setShares(int shares) {
        this.shares = shares;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public double getEngagementRate() {
        return engagementRate;
    }

    public void setEngagementRate(double engagementRate) {
        this.engagementRate = engagementRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
