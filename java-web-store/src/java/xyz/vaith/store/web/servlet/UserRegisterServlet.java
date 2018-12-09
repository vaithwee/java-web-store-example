package xyz.vaith.store.web.servlet;

import xyz.vaith.store.domain.User;
import xyz.vaith.store.service.Impl.UserServiceImpl;
import xyz.vaith.store.service.UserService;
import xyz.vaith.store.utils.DomainBeanUtil;
import xyz.vaith.store.utils.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserRegisterServlet", urlPatterns = {"/user/register"})
public class UserRegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspPathUtil.getJspRealPath("register")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        DomainBeanUtil.populate(user, req.getParameterMap());
        UserService service = new UserServiceImpl();
        try {
            service.register(user);
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            req.setAttribute("message", "注册成功!");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            req.setAttribute("message", e.getMessage());
        }

        req.getRequestDispatcher(JspPathUtil.getJspRealPath("info")).forward(req, resp);
    }
}
