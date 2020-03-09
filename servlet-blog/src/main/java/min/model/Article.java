package min.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author zhaomin
 * @date 2020/3/8 15:05
 */
@Getter
@Setter
@ToString
public class Article {
    private Integer id;
    private String title;
    private String content;
    private Integer userId;
    private Date createTime;
    private String userAccout;
}
