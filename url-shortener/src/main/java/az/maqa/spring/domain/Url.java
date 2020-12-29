package az.maqa.spring.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Url {

    @Id
    private String id;
    private String url;
    private String shortUrl;

    public Url() {

    }

    public Url(String url, String shortUrl) {
        this.url = url;
        this.shortUrl = shortUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Url{" +
                "id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", shortUrl='" + shortUrl + '\'' +
                '}';
    }
}
