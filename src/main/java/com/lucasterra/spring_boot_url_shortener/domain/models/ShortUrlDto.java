package com.lucasterra.spring_boot_url_shortener.domain.models;

import java.io.Serializable;

public record ShortUrlDto(Long id, String shortKey, String originalUrl, Boolean isPrivate, java.time.LocalDateTime expiresAt,
                          UserDto createdBy, Long clickCount, java.time.LocalDateTime createdAt) implements Serializable {
}
