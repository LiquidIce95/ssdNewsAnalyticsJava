package ssd.Entities;

import java.io.Serializable;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity<T extends Analytics> implements Serializable{

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "analytics_id",nullable = false)
    private T analytics;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

   
    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getAnalytics() {
        return analytics;
    }

    public void setAnalytics(T analytics) {
        this.analytics = analytics;
    }
}
