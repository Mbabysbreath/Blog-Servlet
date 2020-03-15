package min.servlet;

import min.util.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

/**
 * @author zhaomin
 * @date 2020/3/14 19:50
 */
@WebServlet("/ueditor")
public class UeditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String rootPath = getClass().getClassLoader().getResource("config.json").getPath();
        String path= URLDecoder.decode(rootPath,"UTF-8");//反编译
        System.out.println(path);
        MyActionEnter actionEnter = new MyActionEnter(req, path);
        String exe = actionEnter.exec();
        PrintWriter pw = resp.getWriter();
        pw.println(exe);
        pw.flush();
    }
}
