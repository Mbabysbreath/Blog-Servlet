package min.servlet;

import exception.BusinessException;
import min.dao.ArticleDAO;
import min.model.Article;
import min.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaomin
 * @date 2020/3/14 17:36
 */
@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        Article article = JSONUtil.deserialize(req.getInputStream(), Article.class);
        if (!ArticleDAO.update(article)) {
            throw new BusinessException("aupdate001", "修改文章出错");
        }
        return null;
    }
}
