package ssd.Entities.Newspaper;

import javax.persistence.*;
import java.io.Serializable;
import ssd.Entities.Analytics;


@Entity
@Table(name = "newspaper_analytics")
public class NewspaperAnalytics implements Analytics,Serializable {

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
    @Column(name = "newspaper_analytics_id")
    private Long id;
    // Getters and Setters

    @Override
    public String getBias() {
        return bias;
    }

    @Override
    public void setBias(String bias) {
        this.bias = bias;
    }

    @Override
    public int getViews() {
        return views;
    }

    @Override
    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public int getShares() {
        return shares;
    }

    @Override
    public void setShares(int shares) {
        this.shares = shares;
    }

    @Override
    public int getLikes() {
        return likes;
    }

    @Override
    public void setLikes(int likes) {
        this.likes = likes;
    }

    @Override
    public double getEngagementRate() {
        return engagementRate;
    }

    @Override
    public void setEngagementRate(double engagementRate) {
        this.engagementRate = engagementRate;
    }
}
