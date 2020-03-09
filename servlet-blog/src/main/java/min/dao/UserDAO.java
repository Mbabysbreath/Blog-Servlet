package min.dao;

import exception.SystemException;
import min.model.User;
import min.util.Constant;
import min.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

/**
 * @author zhaomin
 * @date 2020/3/8 19:16
 */
public class UserDAO {

    /**
     * 通过姓名查找数据库是否存在该姓名
     * @param name
     * @return
     */
    public static User queryByName(String name){

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;
        try {
            connection=DBUtil.getConnection();
            String sql = "select id,name,create_time from user where name=?";
            ps=connection.prepareStatement(sql);
            ps.setString(1, name);
            resultSet=ps.executeQuery();
            while (resultSet.next()) {
                User user=new User();
                user.setId(resultSet.getInt("id"));
                user.setName(name);
                user.setCreateTime(
                        new Date(resultSet.getTimestamp("create_time").getTime()));
                return user;
            }
            return null;
        } catch (Exception e) {
            throw new SystemException(Constant.QUERY_USER_ERROR_CODE,"查询用户信息出错",e);
        }finally {
            DBUtil.close(connection,ps,resultSet);
        }
    }
}
