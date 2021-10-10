package com.lujun61.ajax;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class OneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=UTF-8");

        //接收参数
        String name = request.getParameter("name");
        float weight = Float.parseFloat(request.getParameter("weight"));
        float high = Float.parseFloat(request.getParameter("high"));
        float bmi = weight / (high * high);

        //业务处理
        String msg = null;
        if (bmi <= 18.5) {
            msg = "您比较瘦";
        } else if (bmi >= 18.5 && bmi <= 23.9) {
            msg = "您的体重是正常的";
        } else if (bmi >= 24 && bmi <= 27) {
            msg = "您的体重比较胖";
        } else {
            msg = "您的体重已超重";
        }

        PrintWriter out = response.getWriter();
        out.println(name + "先生您好！您的体重是：" + weight + "公斤" +
                "；您的身高是：" + high + "米" + "；您的健康状况是：" + msg);

        out.flush();
        out.close();
    }
}
