package com.holley.wxemcp.ent.model.def;

/**
 * 页码基类
 * 
 * @author sc
 */
public class PageBase {

    private int pageIndex;    // 页码
    private int totalProperty; // 总记录数
    private int totalPage;    // 总页数
    private int limit;        // 每页条数

    public PageBase(int totalProperty, int pageIndex, int limit) {
        this.totalProperty = totalProperty;
        this.pageIndex = pageIndex>0?pageIndex:1;
        this.limit = limit;
        if (totalProperty % limit == 0) {
            this.totalPage = totalProperty / limit;
        } else {
            this.totalPage = totalProperty / limit + 1;
        }
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalProperty() {
        return totalProperty;
    }

    public void setTotalProperty(int totalProperty) {
        this.totalProperty = totalProperty;
    }

    public int getTotalPage() {

        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
