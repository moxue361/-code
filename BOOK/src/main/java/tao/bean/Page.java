package tao.bean;

import java.util.List;

public class Page<T> {
    public static final int PAGE_SIZE = 4;
    private int pageNow;
    private int pageSize=PAGE_SIZE;
    private int pageCount;
    private int recordCount;
    private List<T> pageList;

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public Page() {
    }

 

    public List<T> getPageList() {
        return pageList;
    }

    public void setPageList(List<T> pageList) {
        this.pageList = pageList;
    }

    @Override
    public String toString() {
        return "Page [pageCount=" + pageCount + ", pageList=" + pageList + ", pageNow=" + pageNow + ", pageSize="
                + pageSize + ", recordCount=" + recordCount + "]";
    }

    public Page(int pageNow, int pageCount, int recordCount, List<T> pageList) {
        this.pageNow = pageNow;
        this.pageCount = pageCount;
        this.recordCount = recordCount;
        this.pageList = pageList;
    }

    
    
}