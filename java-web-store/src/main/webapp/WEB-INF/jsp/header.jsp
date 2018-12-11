<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/11
  Time: 下午8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div style="width: 100%">
    <c:if test="${empty user}">
        <a href="<c:url value="/user/login" />" >登录</a>
        <a href="<c:url value="/user/register" />" >注册</a>
    </c:if>
    <c:if test="${not empty user}">
        欢迎 ${user.username}
        <a href="<c:url value="/user/logout" />" >注销</a>
    </c:if>
</div>