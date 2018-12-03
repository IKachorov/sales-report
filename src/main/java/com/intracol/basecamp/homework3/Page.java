package com.intracol.basecamp.homework3;


public class Page {

    private Integer pageNumber;
    private Integer pageSize;

    public Page(Integer pageNumber, Integer pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
    
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }
    
    public Integer getPageNumber() {
        return pageNumber;
    }
    
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    
    public Integer getPageSize() {
        return pageSize;
    }
    
    public boolean isAllPages() {
        return pageNumber == null || pageSize == null;
    }

    @Override
    public String toString() {
        return "Page [pageNumber=" + pageNumber + ", pageSize=" + pageSize + "]";
    }

}
