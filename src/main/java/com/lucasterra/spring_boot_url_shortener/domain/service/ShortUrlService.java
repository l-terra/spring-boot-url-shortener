package com.lucasterra.spring_boot_url_shortener.domain.service;

import com.lucasterra.spring_boot_url_shortener.domain.entities.ShortUrl;
import com.lucasterra.spring_boot_url_shortener.domain.models.ShortUrlDto;
import com.lucasterra.spring_boot_url_shortener.domain.repositories.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;
    private final EntityMapper entityMapper;

    public ShortUrlService(ShortUrlRepository shortUrlRepository, EntityMapper entityMapper) {
        this.shortUrlRepository = shortUrlRepository;
        this.entityMapper = entityMapper;
    }

    public List<ShortUrlDto> findAllPublicShortUrls() {
        return shortUrlRepository.findPublicShortUrls()
                .stream().map(entityMapper::toShortUrlDto).toList();
    }
}
