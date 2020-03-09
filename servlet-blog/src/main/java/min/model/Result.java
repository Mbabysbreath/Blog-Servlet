package min.model;

/**
 * @author zhaomin
 * @date 2020/3/8 11:33
 */

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 返回给前端
 */
@Getter
@Setter
@ToString
public class Result {

    //是否请求成功
    private boolean success;

    //错误码
    private String code;

    //错误信息
    private String message;

    //返回数据
    private Object data;
}
