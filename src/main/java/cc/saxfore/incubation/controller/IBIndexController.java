package cc.saxfore.incubation.controller;

import cc.saxfore.incubation.common.IBRespResult;
import cc.saxfore.incubation.model.IBResponse;
import org.springframework.web.bind.annotation.*;

/**
 * 项目名称：incubation
 * 类 名 称：IndexController
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:31 PM
 * 创 建 人：wangjiang
 */
@CrossOrigin
@RestController
@RequestMapping("/login")
public class IBIndexController extends IBBaseController {

    @GetMapping("/index")
    public IBResponse index(@RequestParam("username") String username, @RequestParam("password") String password) {

        System.out.println("username = [" + username + "], password = [" + password + "]");

        return IBRespResult.success();

    }

}
