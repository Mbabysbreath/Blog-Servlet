package exception;

/**
 * @author zhaomin
 * @date 2020/3/8 16:17
 */
public class SystemException extends BaseException {
    public SystemException(String code, String message) {
        super(code, message);
    }

    public SystemException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
