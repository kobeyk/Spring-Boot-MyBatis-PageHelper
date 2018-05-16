package com.appleyk.paging;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.github.pagehelper.Page;

/**
 * 对Page<E>结果进行包装
 * <p/>
 * 新增分页的多项属性，主要参考:http://bbs.csdn.net/topics/360010907
 *
 * @author liuzh/abel533/isea533
 * @version 3.3.0
 * @since 3.2.2
 * 项目地址 : http://git.oschina.net/free/Mybatis_PageHelper
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    //当前页
    private int pageNum;
    //每页的数量
    //private int pageSize;
    //总记录数
    private long total;
    //总页数
    private int pages;
    //结果集
    private List<T> list;
    //是否为第一页
    //private boolean isFirstPage = false;
    //是否为最后一页
    //private boolean isLastPage = false;


    public PageInfo() {
    }

    /**
     * 包装Page对象
     *
     * @param list
     */
    public PageInfo(List<T> list) {
        if (list instanceof Page) {
            Page page = (Page) list;
            this.pageNum = page.getPageNum();
            //this.pageSize = page.getPageSize();

            this.pages = page.getPages();
            this.list = page;
            this.total = page.getTotal();
        } else if (list instanceof Collection) {
            this.pageNum = 1;
            //this.pageSize = list.size();

            this.pages = 1;
            this.list = list;
            this.total = list.size();
        }
        if (list instanceof Collection) {
            //判断页面边界
            judgePageBoudary();
        }
    }
    
    public PageInfo(PageInfo<?> pageInfo, List<T> list) { 
    	this.pageNum = pageInfo.getPageNum();
    	this.pages = pageInfo.getPages() == 0 ? 1 : pageInfo.getPages();
    	this.total = pageInfo.getTotal();
    	this.list = list;
    }
    
    public PageInfo(PageInfo<?> pageInfo1, PageInfo<?> pageInfo2, List<T> list) { 
    	this.pageNum = pageInfo1.getPageNum();
    	int pages1 = pageInfo1.getPages() == 0 ? 1 : pageInfo1.getPages();
    	int pages2 = pageInfo2.getPages() == 0 ? 1 : pageInfo2.getPages();
    	this.pages = pages1 > pages2 ? pages1 : pages2;
    	this.total = pageInfo1.getTotal() + pageInfo2.getTotal();
    	this.list = list;
    }

    /**
     * 判定页面边界
     */
    private void judgePageBoudary() {
        //isFirstPage = pageNum == 1;
        //isLastPage = pageNum == pages;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PageInfo{");
        sb.append("pageNum=").append(pageNum);
        //sb.append(", pageSize=").append(pageSize);
        sb.append(", total=").append(total);
        sb.append(", pages=").append(pages);
        sb.append(", list=").append(list);
        //sb.append(", isFirstPage=").append(isFirstPage);
        //sb.append(", isLastPage=").append(isLastPage);
        sb.append(", navigatepageNums=");
        sb.append('}');
        return sb.toString();
    }
}
