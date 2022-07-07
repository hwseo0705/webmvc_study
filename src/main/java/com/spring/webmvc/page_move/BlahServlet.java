package com.spring.webmvc.page_move;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/blah")
public class BlahServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // resp.sendRedirect("WEB-INF/blah.jsp"); // WEB-INF는 클라이언트에서 접근 안됨, URL 노출 됨

        RequestDispatcher dp = req.getRequestDispatcher("/WEB-INF/blah.jsp"); // WEB-INF 접근 됨, URL 노출 안됨
        dp.forward(req, resp);

    }
}
