package min.dao;

import exception.SystemException;
import min.model.Article;
import min.model.User;
import min.util.Constant;
import min.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.Date;

/**
 * @author zhaomin
 * @date 2020/3/9 17:06
 */
public class Arti {
    public static boolean insert(Article article){
        Connection connection=null;
        PreparedStatement ps=null;
        try{
            connection= DBUtil.getConnection();
            String sql="insert into article(title,content,user_id,create_time) " +
                    "values(?,?,?,?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,article.getTitle());
            ps.setString(2,article.getContent());
            ps.setInt(3,article.getUserId());
            ps.setTimestamp(4,new Timestamp(new Date().getTime()));
            int num=ps.executeUpdate();
            return num>=1;
        }catch(Exception e){
            throw new SystemException(Constant.INSERT_ARTICLE_ERROR_CODE,"插入文章出错",e);
        }finally {
            DBUtil.close(connection,ps);
        }
    }
}
