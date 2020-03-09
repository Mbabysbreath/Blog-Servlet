package exception;

/**
 * @author zhaomin
 * @date 2020/3/8 16:16
 */
public class BusinessException extends BaseException {
    public BusinessException(String code, String message) {
        super(code, message);
    }

    public BusinessException(String code, String message, Throwable cause) {

        super(code, message, cause);
    }
}
