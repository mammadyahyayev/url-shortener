package az.maqa.spring.exception;

public class UrlNotFound extends RuntimeException {

    public UrlNotFound(String message) {
        super(message);
    }
}
