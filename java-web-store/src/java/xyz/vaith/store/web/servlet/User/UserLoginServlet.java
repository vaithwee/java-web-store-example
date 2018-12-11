package xyz.vaith.store.web.servlet.User;

import xyz.vaith.store.domain.User;
import xyz.vaith.store.service.Impl.UserServiceImpl;
import xyz.vaith.store.service.UserService;
import xyz.vaith.store.utils.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "UserLoginServlet", urlPatterns = {"/user/login"})
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(JspPathUtil.getJspRealPath("login")).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        UserService service = new UserServiceImpl();
        try {
            User user = service.login(username, password);
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            req.setAttribute("message", "登录成功!");
        } catch (Exception e) {
            e.printStackTrace();
            resp.setCharacterEncoding("utf-8");
            resp.setContentType("text/html;charset=utf-8");
            req.setAttribute("message", e.getMessage());
        }
        req.getRequestDispatcher(JspPathUtil.getJspRealPath("info")).forward(req, resp);
    }
}
