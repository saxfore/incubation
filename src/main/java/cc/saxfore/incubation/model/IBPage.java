package cc.saxfore.incubation.model;

import java.io.Serializable;

/**
 * 项目名称：incubation
 * 类 名 称：IBPage
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:26 PM
 * 创 建 人：wangjiang
 */
public class IBPage implements Serializable {

    private String searchKey;
    private String currentPage;
    private String pageSize;
    private String totalPage;
    private String total;

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
