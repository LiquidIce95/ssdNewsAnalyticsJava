package ssd.AbstractClasses.Raw;

import javax.persistence.*;

import com.fasterxml.jackson.databind.JsonSerializable.Base;

import ssd.AbstractClasses.Base.BaseEntity;
import ssd.AbstractClasses.Analytics.Analytics;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
public abstract class EntityRaw<T extends BaseEntity<? extends Analytics>> implements Serializable {

    @Column(name = "scrape_content", nullable = false)
    private String scrapeContent;

    @Column(name = "date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "url", nullable = false)
    private String url;

    @ManyToOne
    @JoinColumn(name = "entity_id",nullable = false)
    private T baseEntity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entity_raw_id")
    private Long id;

    // Getters and Setters

    public Long getId() {
      return id;
    }

    public void setId(Long id) {
      this.id = id;
    }

    public String getScrapeContent() {
        return scrapeContent;
    }

    public void setScrapeContent(String scrapeContent) {
        this.scrapeContent = scrapeContent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public T getBaseEntity() {
        return baseEntity;
    }

    public void setBaseEntity(T baseEntity) {
        this.baseEntity = baseEntity;
    }
}
