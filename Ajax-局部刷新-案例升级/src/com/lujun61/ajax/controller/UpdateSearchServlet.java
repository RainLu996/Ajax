package com.lujun61.ajax.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lujun61.ajax.dao.ProvinceDAO;
import com.lujun61.ajax.dao.UpdateProvinceDAO;
import com.lujun61.ajax.entity.Province;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class UpdateSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String id = request.getParameter("id");

        //将JSON格式字符串默认值赋值为“{}”，即空JSON数据；以此来遵循JSON数据的规范
        String json = "{}";

        UpdateProvinceDAO dao = new UpdateProvinceDAO();
        Province province = dao.searchById(id);

        //使用jackson把province对象转换为json
        ObjectMapper om = new ObjectMapper();
        json = om.writeValueAsString(province);


        /* 指定服务器端（servlet）返回给浏览器的是json格式的数据 */
        response.setContentType("application/json;charset=utf-8");

        //把获取的数据通过网络返回给ajax中的异步对象
        PrintWriter out = response.getWriter();
        out.println(json);
        out.flush();
        out.close();
    }
}
