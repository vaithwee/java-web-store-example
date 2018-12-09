<%--
  Created by IntelliJ IDEA.
  User: vaith
  Date: 2018/12/9
  Time: 下午3:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
<form action="/user/register" method="post">
    用户名:<input type="text" name="username" /><br />
    密码:<input type="password" name="password" /><br />
    重复密码:<input type="password" name="repeat" /><br />
    昵称:<input type="text" name="name" /><br />
    邮箱:<input type="text" name="email" /><br />
    手机:<input type="text" name="telephone" /><br />
    生日:<input type="date" name="birthday" /><br />
    性别:<select name="sex">
        <option value="male">男</option>
        <option value="female">女</option>
</select><br />
    <input type="submit" value="Register" />
</form>
</body>
</html>
