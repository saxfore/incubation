package cc.saxfore.incubation.controller;

import cc.saxfore.incubation.common.IBRespResult;
import cc.saxfore.incubation.model.IBResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称：incubation
 * 类 名 称：BaseController
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:18 PM
 * 创 建 人：wangjiang
 */

@CrossOrigin
@RestController
public class IBBaseController {

    @RequestMapping("/")
    public IBResponse index() {
        return IBRespResult.fail("检查你的访问地址是否正确！");
    }

}
