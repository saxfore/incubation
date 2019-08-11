package cc.saxfore.incubation.model;

import java.util.List;

/**
 * 项目名称：incubation
 * 类 名 称：IBResultPage
 * 类 描 述：TODO
 * 创建时间：2019/8/11 3:14 PM
 * 创 建 人：wangjiang
 */
public class IBResultPage<T> extends IBPage {

    private List<T> dataList;

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }
}
