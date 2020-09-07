package tao.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tao.bean.User;
import tao.service.UserService;

public class UserServlet extends BaseServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private UserService userService = new UserService();

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User loginUser=userService.login(new User(username, password));
        if(loginUser!=null){
            //登录成功
            //保存登录用户信息到session
            req.getSession().setAttribute("user", loginUser);
            req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
        }
        else {
            req.setAttribute("msg", "用户名或密码错误");
            req.setAttribute("username", username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req, resp);
        }
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.getSession().invalidate();
        resp.sendRedirect(req.getContextPath());
    }

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        resp.setContentType("text/html;charset=utf-8");        //需解决响应中文乱码问题
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String code=req.getParameter("code");
        String realCode=(String)req.getSession().getAttribute("KAPTCHA_SESSION_KEY");

        if(realCode.equalsIgnoreCase(code)){
            Boolean flag=userService.regist(new User(username,password,email));
            if(flag){
                req.getRequestDispatcher("pages/user/login_success.jsp").forward(req, resp);
            }
            else {
                req.setAttribute("username","用户名已存在");
                req.setAttribute("password",password);
                req.setAttribute("email",email);
                req.setAttribute("codeMsg",code);
                req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
            }
        }
        else{
            req.setAttribute("username",username);
            req.setAttribute("password",password);
            req.setAttribute("email",email);
            req.setAttribute("codeMsg","验证码错误");
            req.getRequestDispatcher("pages/user/regist.jsp").forward(req, resp);
        }
    }

}