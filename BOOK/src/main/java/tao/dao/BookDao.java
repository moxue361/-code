package tao.dao;

import java.util.List;

import tao.bean.Book;

public class BookDao extends BaseDao{
    public Book queryBook(Integer id){
        return queryOneObj("select * from t_book where id=?", Book.class, id);
    }

    public int addBook(Book book){
        return update("insert into t_book(author,name,price,sales,stock,img_path) values(?,?,?,?,?,?)", book.getAuthor(),
        book.getName(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath());
    }

    public Integer removeBook(Integer id){
        return update("delete from t_book where id=?", id);
    }


    public int updateBook(Book book){
      return update("update t_book set name=?,author=?,price=?,sales=?,stock=?,img_path=? where id=?", 
      book.getName(),book.getAuthor(),book.getPrice(),book.getSales(),book.getStock(),book.getImgPath(),book.getId());
    }
    public List<Book> queryBooks(){
        return queryObjs("select id,name,author,price,sales,stock from t_book",Book.class);
    }

    public int countBooks() {
        return queryBooks().size();
    }

    public List<Book> queryForPageBooks(int pageNow,int pageSize) {
        return queryObjs("select * from t_book limit ?,?", Book.class,(pageNow-1)*pageSize, pageSize);
    }


	public List<Book> queryForPageBooksByPrice(int pageNow, int pageSize, int min, int max) {
		return queryObjs("select * from t_book where price between ? and ? order by price limit ?,?", Book.class,min,max,(pageNow-1)*pageSize, pageSize);
    }
    
    public int countBooksByPrice(int min,int max) {
        return queryObjs("select * from t_book where price between ? and ?",Book.class,min,max).size();
    }
}