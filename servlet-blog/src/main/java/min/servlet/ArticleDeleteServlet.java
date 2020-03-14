package min.servlet;

import exception.BusinessException;
import exception.SystemException;
import min.dao.ArticleDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaomin
 * @date 2020/3/14 17:55
 */
@WebServlet("/articleDelete")
public class ArticleDeleteServlet extends BaseServlet {
    @Override
    public Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String[] idsStr = req.getParameter("ids").split(",");
        int[] ids = new int[idsStr.length];
        for(int i=0;i<idsStr.length;i++) {
            ids[i]=Integer.parseInt(idsStr[i]);
        }
        if(!ArticleDAO.delete(ids)){
            throw new BusinessException("adelete001", "文章删除失败");
        }
        return null;
    }
}
