package ssd.Entities.Newspaper;

import javax.persistence.*;

import ssd.Entities.Newspaper.Analytics.NewspaperAnalytics;

import java.io.Serializable;

@Entity
@Table(name = "newspaper")
public class Newspaper implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "newspaper_id")
    private Long newspaperId;

    @Column(name = "newspaper_name",nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "newspaper_analytics_id",nullable = false)
    private NewspaperAnalytics analytics;

    // Getters and Setters

    public Long getNewspaperId() {
        return newspaperId;
    }

    public void setNewspaperId(Long newspaperId) {
        this.newspaperId = newspaperId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public NewspaperAnalytics getAnalytics() {
        return analytics;
    }

    public void setAnalytics(NewspaperAnalytics NewspaperAnalytics) {
        this.analytics = NewspaperAnalytics;
    }
}
