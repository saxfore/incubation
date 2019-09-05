package cc.saxfore.model;

import java.io.Serializable;

/**
 * 项目名称：incubation
 * 类 名 称：IBPage
 * 类 描 述：TODO
 * 创建时间：2019/8/11 3:16 PM
 * 创 建 人：wangjiang
 */
public class IBPage implements Serializable {

    protected String currentPage;
    protected String pageSize;
    protected String totalPage;
    protected String totalCount;

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

    public String getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(String totalCount) {
        this.totalCount = totalCount;
    }
}
