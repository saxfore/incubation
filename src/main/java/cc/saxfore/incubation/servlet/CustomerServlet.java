package cc.saxfore.incubation.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称：incubation
 * 类 名 称：CustomerServlet
 * 类 描 述：TODO
 * 创建时间：2019/8/11 11:44 AM
 * 创 建 人：wangjiang
 */
@WebServlet(name = "customerServlet", urlPatterns = "/api/servlet/customer")
public class CustomerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
