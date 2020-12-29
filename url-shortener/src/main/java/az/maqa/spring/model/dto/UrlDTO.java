package az.maqa.spring.model.dto;

public class UrlDTO {
    private String url;
    private String shortUrl;

    public UrlDTO(String url, String shortUrl) {
        this.url = url;
        this.shortUrl = shortUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }
}
