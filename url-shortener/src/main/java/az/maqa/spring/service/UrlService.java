package az.maqa.spring.service;

import az.maqa.spring.model.dto.UrlDTO;

public interface UrlService {

    UrlDTO clipUrl(String validUrl);

    UrlDTO getUrl(String url);

}
