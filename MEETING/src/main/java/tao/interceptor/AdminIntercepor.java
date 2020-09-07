package tao.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.HandlerInterceptor;

import tao.model.Employee;

public class AdminIntercepor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        HttpSession session = request.getSession();
        Employee user = (Employee) session.getAttribute("user");
        if(user!=null){
            if(user.getRole().equals("1")){
                return true;
            }
            else if(user.getRole().equals("2")){
                response.getWriter().append("无管理员权限");
                return false; 
            }
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");
        return false;
    }
}