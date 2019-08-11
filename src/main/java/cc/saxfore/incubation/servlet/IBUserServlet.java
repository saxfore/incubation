package cc.saxfore.incubation.servlet;

import cc.saxfore.incubation.common.IBRespResult;
import cc.saxfore.incubation.entity.IBUser;
import cc.saxfore.incubation.service.IBUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 项目名称：incubation
 * 类 名 称：IBUserServlet
 * 类 描 述：TODO
 * 创建时间：2019/8/11 11:44 AM
 * 创 建 人：wangjiang
 */
@WebServlet(name = "ibUserServlet", urlPatterns = "/servlet/user")
public class IBUserServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(IBUserServlet.class);

    @Autowired
    IBUserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("IBUserServlet /servlet/user ...");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        IBUser user = userService.findByUsernameAndPassword(username, password);
        IBRespResult.success(resp, user);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}