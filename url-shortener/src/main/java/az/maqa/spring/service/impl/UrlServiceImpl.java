package az.maqa.spring.service.impl;

import az.maqa.spring.controller.UrlController;
import az.maqa.spring.domain.Url;
import az.maqa.spring.exception.UrlNotFound;
import az.maqa.spring.model.dto.UrlDTO;
import az.maqa.spring.repository.UrlRepository;
import az.maqa.spring.service.UrlService;
import com.google.common.hash.Hashing;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    public UrlServiceImpl(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    @Override
    public UrlDTO clipUrl(String validUrl) {
        Url url = new Url();
        String shortUrl = Hashing.murmur3_32().hashString(validUrl, StandardCharsets.UTF_8).toString();
        url.setUrl(validUrl);
        url.setShortUrl(shortUrl);

        Url savedUrl = urlRepository.save(url);
        return new UrlDTO(savedUrl.getUrl(), savedUrl.getShortUrl());
    }

    @Override
    public UrlDTO getUrl(String url) {
        Url foundedUrl = urlRepository.findByUrl(url);
        if (foundedUrl == null) {
            throw new UrlNotFound("Url Not Found!!!");
        }
        return new UrlDTO(foundedUrl.getUrl(), foundedUrl.getShortUrl());
    }
}
