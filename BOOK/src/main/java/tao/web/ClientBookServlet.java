package tao.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tao.bean.Book;
import tao.bean.Page;
import tao.service.BookService;

public class ClientBookServlet extends BaseServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private BookService bookService=new BookService();
    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageNow=1;
        if(req.getParameter("pageNow")!=null)pageNow=Integer.valueOf(req.getParameter("pageNow")); 
        int pageSize=Page.PAGE_SIZE;
        Page<Book> page=bookService.page(pageNow, pageSize);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    public void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageNow=1;
        if(req.getParameter("pageNow")!=null)pageNow=Integer.valueOf(req.getParameter("pageNow")); 
        int min=Integer.valueOf(req.getParameter("min"));
        int max=Integer.valueOf(req.getParameter("max"));
        int pageSize=Page.PAGE_SIZE;
        Page<Book> page=bookService.pageByPrice(pageNow, pageSize,min,max);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);      
    }
}