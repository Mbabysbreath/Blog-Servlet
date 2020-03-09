package min.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhaomin
 * @date 2020/3/8 15:03
 */
@Getter
@Setter
@ToString
public class User {
    private Integer id;
    private String name;
    private Date createTime;
}
