package ingjulianvega.ximic.msscasusystemcheck.exception;

import lombok.Getter;

@Getter
public class SystemCheckException extends RuntimeException {

    private final String code;

    public SystemCheckException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

