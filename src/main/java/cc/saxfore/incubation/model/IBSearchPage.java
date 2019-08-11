package cc.saxfore.incubation.model;

import java.io.Serializable;

/**
 * 项目名称：incubation
 * 类 名 称：IBSearchPage
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:26 PM
 * 创 建 人：wangjiang
 */
public class IBSearchPage extends IBPage {

    private String searchKeyword;

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }
}
