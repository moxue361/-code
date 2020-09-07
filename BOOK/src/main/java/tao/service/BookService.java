package tao.service;

import java.util.List;

import tao.bean.Book;
import tao.bean.Page;
import tao.dao.BookDao;

public class BookService {

    private BookDao bookDao= new BookDao();
    public void addBook(Book book){
        bookDao.addBook(book);
    }
    public void removeBook(int id) {
        bookDao.removeBook(id);
    }
    public Book queryBook(Integer id) {
       return bookDao.queryBook(id);
    }
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    public Page<Book> page(int pageNow,int pageSize) {
        Page<Book> page=new Page<Book>();
        page.setPageNow(pageNow);
        page.setPageSize(pageSize);
        page.setRecordCount(bookDao.countBooks());
        page.setPageList(bookDao.queryForPageBooks(pageNow, pageSize));
        int pageCount=bookDao.countBooks()/pageSize;
        if(bookDao.countBooks()%pageSize!=0)pageCount++;
        page.setPageCount(pageCount);
        return page;
    }

	public Page<Book> pageByPrice(int pageNow, int pageSize, int min, int max) {
        Page<Book> page=new Page<Book>();
        page.setPageNow(pageNow);
        page.setPageSize(pageSize);
        page.setRecordCount(bookDao.countBooksByPrice(min,max));
        page.setPageList(bookDao.queryForPageBooksByPrice(pageNow,pageSize,min,max));
        int pageCount=bookDao.countBooksByPrice(min,max)/pageSize;
        if(bookDao.countBooksByPrice(min,max)%pageSize!=0)pageCount++;
        page.setPageCount(pageCount);
        return page;
    }

}