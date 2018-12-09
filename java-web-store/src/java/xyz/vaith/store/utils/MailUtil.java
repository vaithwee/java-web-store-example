package xyz.vaith.store.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class MailUtil {
    public static void sendMail(String code, String to) {
        final String from = "developforjavaee";
        final String password = "abcde12345";
        String object = "邮箱验证";
        String c = code;

        StringBuilder content = new StringBuilder();

        content.append("<body>");
        content.append("<span style=\"font-size:15px\">Hi. This is the New Grade·Inform.</span>");
        content.append("<hr>");
        //简单版本
        /*String text;
        for (Grade grade:arrayList) {
            text = "";
            text += grade.toString();
            content.append(text);
            content.append("<br>");
        }*/
        //表格版本
        content.append("<table>");
        content.append("<thead>");
        content.append("<tr>");
        content.append("<th>课程名</th>");
        content.append("<th>分数</th>");
        content.append("<th>绩点</th>");
        content.append("<th>学分</th>");
        content.append("<th>属性</th>");
        content.append("</tr>");
        content.append("</thead>");
        content.append("<tbody>");
        for (int i = 0; i < 10; ++i) {
            content.append("<tr>");
            content.append("<td style=\"text-align:center\">"+c+"</td>");
            content.append("<td>"+i+"</td>");
            content.append("<td>"+i+"</td>");
            content.append("<td>"+i+"</td>");
            content.append("<td>"+i+"</td>");
            content.append("</tr>");
        }
        content.append("</tbody>");
        content.append("</table>");

        content.append("<hr>");
        content.append("<span style=\"font-size:17px\">Thank you! </span><a href='http://localhost:8080/user/active?code="+code+"' >Please Click To Active</a></body>");

        // 0.1 服务器的设置
        Properties props = new Properties();
        props.setProperty("mail.host", "smtp.163.com");
        props.setProperty("mail.smtp.auth", "true");
        // 0.2 账号和密码
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // 126账号和密码（模拟账号，需要自己注册）
                //return new PasswordAuthentication("itcast", "123456");
                return new PasswordAuthentication(from, password);
            }
        };

        // 1 与126服务器建立连接：Session
        Session session = Session.getDefaultInstance(props, authenticator);

        try {
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from + "@163.com"));

            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setRecipient(Message.RecipientType.CC, new InternetAddress(from+"@163.com"));

            message.setSubject(object);

            message.setContent(content.toString(), "text/html;charset=UTF-8");

            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
