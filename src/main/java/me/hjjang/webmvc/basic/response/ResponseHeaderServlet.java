package me.hjjang.webmvc.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // [status-line]
        response.setStatus(HttpServletResponse.SC_OK);

        // [response-headers]
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header","hello");

        // [Header 편의메서드]
//        content(response);
//        cookie(response);
        redirect(response);

        // [messageBody]
        PrintWriter writer = response.getWriter();
        writer.print("ok");
    }

    private void redirect(HttpServletResponse response) throws IOException {
        //Status Code 302
        // Location: /basic/hello-form.html

//        response.setStatus(HttpServletResponse.SC_FOUND);
//        response.setHeader("Location","/basic/hello-form.html");
        response.sendRedirect("/basic/hello-form.html");
    }

    private void content(HttpServletResponse response) {
        // Content-Type : "text/plain;charset=utf-8"
        // Content-Length : 2
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");

        // Content-Length 생략시 자동생성
        // println 으로 하면 마지막에 엔터가 들어가서 content-length가 3이 됨
    }

    private void cookie(HttpServletResponse response) {

        // Set-Cookie myCookie=good; Max-Age=600;
//        response.setHeader("Set-Cookie", "myCookue=good; Max-Age=600");
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600); // 600초
        response.addCookie(cookie);
    }
}
