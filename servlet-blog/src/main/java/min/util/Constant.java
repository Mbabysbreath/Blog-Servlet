package min.util;

/**
 * @author zhaomin
 * @date 2020/3/8 16:26
 */

/**
 * 自定义异常状态码
 */
public interface Constant {
    //数据异常状态码
    String DB_ERROR_CODE="500A";
    //JSON序列化异常状态码
    String JSON_ERROR_CODE="500B";

    String QUERY_USER_ERROR_CODE="500xx1";

    String USER_NULL_ERROR_CODE = "500xx2";

    String INSERT_ARTICLE_ERROR_CODE = "500yy1";
}
