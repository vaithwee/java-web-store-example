package xyz.vaith.store.web.servlet.User;

import xyz.vaith.store.service.Impl.UserServiceImpl;
import xyz.vaith.store.service.UserService;
import xyz.vaith.store.utils.JspPathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UserActiveServlet", urlPatterns = {"/user/active"})
public class UserActiveServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String code = request.getParameter("code");
        UserService service = new UserServiceImpl();
        try {
            boolean isActive = service.active(code);
            if (isActive) {
                request.setAttribute("message", "激活成功");
            } else  {
                request.setAttribute("message", "激活失败或者此链接已失效");
            }
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
        } catch (Exception e) {
            e.printStackTrace();
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            request.setAttribute("message", e.getMessage());
        }
        request.getRequestDispatcher(JspPathUtil.getJspRealPath("info")).forward(request, response);
    }
}
