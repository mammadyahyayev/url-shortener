package az.maqa.spring.service.impl;

import az.maqa.spring.domain.Url;
import az.maqa.spring.exception.UrlNotFoundException;
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
        return mapToDto(savedUrl);
    }

    @Override
    public UrlDTO getUrl(String url) {
        Url foundedUrl = urlRepository.findByUrl(url);
        if (foundedUrl == null) {
            throw new UrlNotFoundException("Url Not Found!!!");
        }
        return mapToDto(foundedUrl);
    }

    @Override
    public UrlDTO getFullUrl(final String slug) {
        Url url = urlRepository.findUrlByShortUrl(slug);
        if (url == null)
            throw new UrlNotFoundException("Url not found for this slug:  " + slug);
        return mapToDto(url);
    }

    private UrlDTO mapToDto(Url foundedUrl) {
        return new UrlDTO(foundedUrl.getUrl(), foundedUrl.getShortUrl());
    }
}
