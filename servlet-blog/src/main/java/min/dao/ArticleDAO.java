package min.dao;

import exception.SystemException;
import min.model.Article;
import min.model.Result;
import min.model.User;
import min.util.Constant;
import min.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author zhaomin
 * @date 2020/3/8 19:42
 */
public class ArticleDAO {

    public static boolean insert(Article article) {
        Connection connection = null;
        PreparedStatement ps = null;


        try {
            connection= DBUtil.getConnection();
            String sql = "insert into article(title, content, user_id,create_time)" +
                    " values (?,?,?,?)";
            ps = connection.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getUserId());
            ps.setTimestamp(4, new Timestamp(new Date().getTime()));
            int num = ps.executeUpdate();
            return num>=1;
        } catch (Exception e) {
            throw new SystemException(Constant.INSERT_ARTICLE_ERROR_CODE,"插入文章出错",e);
        }finally {
            DBUtil.close(connection,ps);
        }
    }

    public static List<Article> queryByUserId(Integer id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        List<Article> articles=new ArrayList<>();
        try {
            connection=DBUtil.getConnection();
            String sql = "select id,title,content,user_id,create_time from article where user_id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet=ps.executeQuery();
            while (resultSet.next()) {
                Article article = new Article();
                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(id);
                //将sql的date转为java的util
                article.setCreateTime(new java.util.Date(
                        resultSet.getTimestamp("create_time").getTime()));
                articles.add(article);
            }
            return articles;
        } catch (Exception e) {
            throw new SystemException(Constant.QUERY_USER_ERROR_CODE,"查询文章列表出错",e);
        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
    }

    public static Article queryByArticleId(Integer id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection=DBUtil.getConnection();
            String sql = "select id,title,content,user_id,create_time from article where id=?";
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id);
            resultSet=ps.executeQuery();
            Article article = new Article();
            while (resultSet.next()) {

                article.setId(resultSet.getInt("id"));
                article.setTitle(resultSet.getString("title"));
                article.setContent(resultSet.getString("content"));
                article.setUserId(id);
                //将sql的date转为java的util
                article.setCreateTime(new java.util.Date(
                        resultSet.getTimestamp("create_time").getTime()));
            }
            return article;
        } catch (Exception e) {
            throw new SystemException(Constant.QUERY_USER_ERROR_CODE,"查询文章详情出错",e);
        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
    }

    public static boolean update(Article article) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection= DBUtil.getConnection();
            String sql = "update article set title=?,content=? where id=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1, article.getTitle());
            ps.setString(2, article.getContent());
            ps.setInt(3, article.getId());
            int num = ps.executeUpdate();
            return num>=1;
        } catch (Exception e) {
            throw new SystemException("update002","修改文章出错",e);
        }finally {
            DBUtil.close(connection,ps);
        }
    }

    public static boolean delete(int[] ids) {
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection= DBUtil.getConnection();
            //可以调整为StirngBuilder来提高效率
            String sql = "DELETE from article where id in(";
            for(int i=0;i<ids.length;i++) {
                if(i==0){
                    sql+="?";
                }else{
                    sql+=", ?";
                }
            }
            sql+=")";
            ps = connection.prepareStatement(sql);
            for(int i=0;i<ids.length;i++){
                ps.setInt(i+1,ids[i]);
            }
            int num = ps.executeUpdate();
            return num>=1;
        } catch (Exception e) {
            throw new SystemException("update002","删除文章出错",e);
        }finally {
            DBUtil.close(connection,ps);
        }
    }
}
