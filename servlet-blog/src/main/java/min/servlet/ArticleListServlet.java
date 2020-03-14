package min.servlet;

import min.dao.ArticleDAO;
import min.model.Article;
import min.model.Result;
import min.util.JSONUtil;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaomin
 * @date 2020/3/8 12:09
 */
@WebServlet("/articleList")
public class ArticleListServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //解析请求数据id=1
        Integer id=Integer.parseInt(req.getParameter("id"));
        //数据库查询id=1的用户，该用户发表的所有文章数据返回给客户端
        List<Article> articles= ArticleDAO.queryByUserId(id);
        System.out.println(articles);
        //TODO
        return articles;
    }
}
