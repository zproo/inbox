package com.example.web;

import com.example.model.BeerExpert;
import servlet.HelloServlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by zproo on 2017/6/12.
 */
public class BeerSelect extends HelloServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String c = req.getParameter("color");
        // 调用model
        BeerExpert be = new BeerExpert();
        List result = be.getBrands(c);

        // 使用Jsp生成
        /*resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("Beer Selection Advice<br>");

        Iterator it = result.iterator();
        while (it.hasNext()) {
            out.print("<br>try: " + it.next());
        }*/
        // out.println("<br>Got Beer Color " + c);

        req.setAttribute("styles", result);

        RequestDispatcher view = req.getRequestDispatcher("result.jsp");
        view.forward(req, resp);
    }
}
