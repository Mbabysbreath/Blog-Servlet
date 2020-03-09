package min.servlet;

import exception.BusinessException;
import min.dao.ArticleDAO;
import min.dao.UserDAO;
import min.model.Article;
import min.model.Result;
import min.model.User;
import min.util.Constant;
import min.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author zhaomin
 * @date 2020/3/8 15:11
 */
@WebServlet("/articleAdd")
public class ArticleAddServlet extends BaseServlet {

    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //从请求输入流中获取json数据
        InputStream is = req.getInputStream();
        Article article = JSONUtil.deserialize(is, Article.class);
       //根据传入数据userAccount
        User user = UserDAO.queryByName(article.getUserAccout());
        if (user == null) {//自己插入用户数据到数据库，name=stu
            throw new BusinessException(
                    Constant.USER_NULL_ERROR_CODE, "该用户不存在，无法发表文章");
        }
        //如果用户存在，就插入文章数据
        article.setUserId(user.getId());
        if (!ArticleDAO.insert(article)) {
            throw new BusinessException(Constant.INSERT_ARTICLE_ERROR_CODE,"文章插入0条数据");
        }
        //System.out.println(article);
        //新增文章操作：userAccount=stu
        //TODO
        return null;
    }
}
