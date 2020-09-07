package tao.web;

import java.io.IOException;
import java.math.BigDecimal;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tao.bean.Book;
import tao.bean.Page;
import tao.service.BookService;

public class BookServlet extends BaseServlet{

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private BookService bookService = new BookService();
    
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name=req.getParameter("name");
        BigDecimal price=new BigDecimal(req.getParameter("price"));
        String author=req.getParameter("author");
        Integer sales=Integer.valueOf(req.getParameter("sales"));
        Integer stock=Integer.valueOf(req.getParameter("stock"));
        bookService.addBook(new Book(name, author, price, sales, stock,null));
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page&pageNow="+req.getParameter("pageNow"));
    }

    public void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        req.setAttribute("books", bookService.queryBooks());
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

    public void remove(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id=req.getParameter("id");
        bookService.removeBook(Integer.valueOf(id));
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }

    public void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String id=req.getParameter("id");
        Book book= bookService.queryBook(Integer.valueOf(id));
        req.setAttribute("book", book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Integer id=Integer.valueOf(req.getParameter("id"));
        String name=req.getParameter("name");
        BigDecimal price=new BigDecimal(req.getParameter("price"));
        String author=req.getParameter("author");
        Integer sales=Integer.valueOf(req.getParameter("sales"));
        Integer stock=Integer.valueOf(req.getParameter("stock"));
        bookService.updateBook(new Book(id,name, author, price, sales, stock, null));
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=page");
    }

    public void page(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int pageNow=1;
        if(req.getParameter("pageNow")!=null)pageNow=Integer.valueOf(req.getParameter("pageNow")); 
        int pageSize=Page.PAGE_SIZE;
        Page<Book> page=bookService.page(pageNow, pageSize);
        req.setAttribute("page", page);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req, resp);
    }

}