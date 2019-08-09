package cc.saxfore.incubation.controller;

import cc.saxfore.incubation.common.IBApiURL;
import cc.saxfore.incubation.common.IBRespResult;
import cc.saxfore.incubation.entity.IBUser;
import cc.saxfore.incubation.model.IBResponse;
import cc.saxfore.incubation.service.IBUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * 项目名称：incubation
 * 类 名 称：IndexController
 * 类 描 述：TODO
 * 创建时间：2019/8/9 4:31 PM
 * 创 建 人：wangjiang
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class IBApiController extends IBBaseController {

    @Autowired
    IBUserService service;

    @IBApiURL
    @GetMapping("/user/{id}")
    public IBResponse index(@PathVariable(value = "id") String id) {

        Optional<IBUser> user = service.findById(id);
        return IBRespResult.success(user.get());
    }

}
