package ssd.Entities.Publisher;

import javax.persistence.*;
import java.io.Serializable;
import ssd.Entities.Analytics;


@Entity
@Table(name = "publisher_analytics")
public class PublisherAnalytics implements Analytics,Serializable {

    private String bias;
    private int views;
    private int shares;
    private int likes;
    private double engagementRate;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_analytics_id")
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
