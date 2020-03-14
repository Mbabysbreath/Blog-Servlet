package min.servlet;

import min.dao.ArticleDAO;
import min.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaomin
 * @date 2020/3/14 16:55
 */
/*这个注解是做什么的*/
@WebServlet("/articleDetail")
public class ArticleDetailServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Integer id=Integer.parseInt(req.getParameter("id"));
        Article article=ArticleDAO.queryByArticleId(id);
        return article;
    }
}
