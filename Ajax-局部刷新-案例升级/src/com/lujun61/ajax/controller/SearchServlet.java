package com.lujun61.ajax.controller;

import com.lujun61.ajax.dao.ProvinceDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.color.ProfileDataException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");
        String id = request.getParameter("id");
        String provinceName = null;

        ProvinceDAO dao = new ProvinceDAO();
        if ((provinceName = dao.searchById(id)) == null) {
            provinceName = "未查询到数据";
        }

        PrintWriter out = response.getWriter();
        out.println(provinceName);
        out.flush();
        out.close();
    }
}
