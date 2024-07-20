package help.help.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)

public class YaziNotFoundException extends RuntimeException {

    public YaziNotFoundException(String message) {
        super(message);
    }

}
