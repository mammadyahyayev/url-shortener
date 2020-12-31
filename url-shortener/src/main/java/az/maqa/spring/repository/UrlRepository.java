package az.maqa.spring.repository;

import az.maqa.spring.domain.Url;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<Url, String> {

    Url findByUrl(String url);

    Url findUrlByShortUrl(String shortUrl);

}
