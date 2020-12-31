package az.maqa.spring.controller;

import az.maqa.spring.exception.UrlNotFoundException;
import az.maqa.spring.model.dto.UrlDTO;
import az.maqa.spring.service.UrlService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

@CrossOrigin(value = "http://localhost:3000")
@RestController
public class UrlController {

    private final UrlService urlService;

    public UrlController(UrlService urlService) {
        this.urlService = urlService;
    }

    @PostMapping
    public UrlDTO saveUrl(@RequestParam String url) {
        String validUrl = checkUrlIsValid(url);
        return urlService.clipUrl(validUrl);
    }

    @GetMapping
    public UrlDTO getUrl(@RequestParam String url) {
        return urlService.getUrl(url);
    }

    @GetMapping("/slug/{slug}")
    public UrlDTO getFullUrl(@PathVariable String slug){
        if(slug != null && !slug.isEmpty())
            return urlService.getFullUrl(slug);
        throw new RuntimeException("Slug can not be empty");
    }

    private String checkUrlIsValid(String url) {
        try {
            if (url.startsWith("http") || url.startsWith("https")) {
                URL urlObject = new URL(url);
                HttpURLConnection urlConnection = (HttpURLConnection) urlObject.openConnection();

                if (urlConnection.getResponseCode() == 404) {
                    throw new UrlNotFoundException("Url not found");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return url;
    }

}
