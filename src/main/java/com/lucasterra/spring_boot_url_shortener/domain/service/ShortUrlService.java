package com.lucasterra.spring_boot_url_shortener.domain.service;

import com.lucasterra.spring_boot_url_shortener.domain.entities.ShortUrl;
import com.lucasterra.spring_boot_url_shortener.domain.repositories.ShortUrlRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortUrlService {

    private final ShortUrlRepository shortUrlRepository;

    public ShortUrlService(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    public List<ShortUrl> findAllPublicShortUrls() {
        return shortUrlRepository.findPublicShortUrls();
    }
}
