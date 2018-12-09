package xyz.vaith.store.web.base;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getParameter("method");
        if (null==method || ""==method || "".equals(method.trim())) {
            method = "execute";
        }

        Class clazz = this.getClass();
        try {
            Method md = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            if (md!=null) {
                String jspPath = (String) md.invoke(this, req, resp);
                if (null!=jspPath) {
                    req.getRequestDispatcher(jspPath).forward(req, resp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String execute(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }
}
