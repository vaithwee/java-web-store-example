package xyz.vaith.store.utils;

public class JspPathUtil {
    public static String getJspRealPath(String name) {
        return "/WEB-INF/jsp/" + name + ".jsp";
    }
}
