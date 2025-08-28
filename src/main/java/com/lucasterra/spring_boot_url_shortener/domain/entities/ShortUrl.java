package com.lucasterra.spring_boot_url_shortener.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "short_urls")
public class ShortUrl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(unique = true, nullable = false)
    private String shortKey;

    @Column(nullable = false)
    private String originalUrl;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private Boolean isPrivate;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime expiresAt;

    private Long clickCount;

    public void setId(Long id) {
        Id = id;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setExpiresAt(LocalDateTime expiresAt) {
        this.expiresAt = expiresAt;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }
}
