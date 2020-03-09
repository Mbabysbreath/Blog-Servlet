package exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zhaomin
 * @date 2020/3/8 16:18
 */
@Getter
@Setter
public class BaseException extends RuntimeException {

    private String code;

    private String message;

    public BaseException(String code,String message) {
        super(message);
        this.code=code;
        this.message=message;
    }

    public BaseException(String code,String message, Throwable cause) {
        super(message, cause);
        this.code=code;
        this.message=message;
    }
}
