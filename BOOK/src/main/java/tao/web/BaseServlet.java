package tao.web;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BaseServlet extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8"); // 需解决响应中文乱码问题
        req.setCharacterEncoding("utf-8");
        
        String action = req.getParameter("action");

        try {
            Method method= this.getClass().getDeclaredMethod(action, HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this, req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
}